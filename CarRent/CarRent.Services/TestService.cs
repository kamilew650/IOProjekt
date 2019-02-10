using CarRent.Core;
using CarRent.Services;
using Microsoft.AspNetCore.Http;
using Microsoft.Extensions.Logging;
using System;
using System.Collections.Generic;
using System.Text;

namespace CarRent.Services
{
    public class TestService : BaseService, ITestService
    {
        public TestService(DbAppContext dbContext, ILogger logger, IHttpContextAccessor httpContextAccessor) 
            : base(dbContext, logger, httpContextAccessor)
        {
        }
    }
}
