using CarRent.Common;
using CarRent.Core;
using CarRent.Services.Contracts;
using Microsoft.AspNetCore.Http;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Logging;
using System;
using System.Linq;
using System.Security.Claims;

namespace CarRent.Services
{
    public class BaseService
    {
        protected readonly DbAppContext _dbContext;
        protected readonly ILogger _logger;
        private HttpContext _httpContext;

        public BaseService(DbAppContext dbContext,
            ILogger logger,
            IHttpContextAccessor httpContextAccessor)
        {
            _dbContext = dbContext;
            _logger = logger;
            _httpContext = httpContextAccessor.HttpContext;
        }

        protected UserClaimModel GetCurrentUserClaims()
        {
            var userEmail = _httpContext.User.FindFirst(ClaimTypes.NameIdentifier).Value;
            var currentUser = _dbContext.Users
                                        .Include(u => u.Role)
                                        .FirstOrDefault(u => u.Email == userEmail);

            return new UserClaimModel(currentUser);
        }

        protected void AllowedOnlyForAdminAndOwner()
        {
            var currentUserClaims = GetCurrentUserClaims();
            if (currentUserClaims.UserNotFound)
                throw new ResourceNotFoundException("Current user not found.");
            if (!currentUserClaims.IsOwner && !currentUserClaims.IsAdmin)
                throw new CustomValidationException("User is not allowed to get resource.");
        }

        protected TResponse ExecuteAction<TResponse>(Action<TResponse> action)
            where TResponse : BaseContractResponse, new()
        {
            var response = new TResponse();
            try
            {
                action(response);
            }
            catch (CustomValidationException ex)
            {
                _logger.LogInformation(ex.Message);
                response.Success = false;
                response.ErrorMessage = ex.Message;
            }
            catch (Exception ex)
            {
                _logger.LogError(ex, ex.Message);
                response.Success = false;
                response.ErrorMessage = ex.Message;
            }
            return response;
        }
    }
}
