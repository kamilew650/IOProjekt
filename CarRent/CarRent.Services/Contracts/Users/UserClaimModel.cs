using CarRent.Common;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;
using System;
using System.Collections.Generic;
using System.Text;

namespace CarRent.Services
{
    public class UserClaimModel
    {
        public User User { get; set; }

        public bool UserNotFound { get; private set; }

        public bool IsOwner
        {
            get
            {
                return RoleExist() && User.Role.Name == UserRoles.Owner.ToString();
            }
            private set { }
        }

        public bool IsAdmin
        {
            get
            {
                return RoleExist() && User.Role.Name == UserRoles.Admin.ToString();
            }
            private set { }
        }

        public bool IsSupport
        {
            get
            {
                return RoleExist() && User.Role.Name == UserRoles.Support.ToString();
            }
            private set { }
        }

        public bool IsUser
        {
            get
            {
                return RoleExist() && User.Role.Name == UserRoles.User.ToString();
            }
            private set { }
        }

        public UserClaimModel(User user)
        {
            User = user;
            UserNotFound = user == null;
        }

        private bool RoleExist()
        {
            return !UserNotFound && User.Role != null;
        }
    }
}
