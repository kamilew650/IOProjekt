﻿using CarRent.Services.Contracts;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CarRent.Authorization
{
    public class TokenModel
    {
        public string Token { get; set; }

        public string UserName { get; set; }
        public string RoleName { get; set; }
        public int Id { get; set; }

        public TokenModel(string token, UserModel user = null)
        {
            Token = token;
            if (user != null)
            {
                UserName = user.Email;
                RoleName = user.RoleName;
                Id = user.Id;
            }
        }
    }
}
