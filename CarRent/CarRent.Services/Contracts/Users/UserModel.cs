using CarRent.Common;
using System;

namespace CarRent.Services.Contracts
{
    public class UserModel
    {
        public int Id { get; set; }
        public string Email { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string Pesel { get; set; }
        public string Address { get; set; }
        public string CreditCardNumber { get; set; }
        public string RoleName { get; set; }

        public UserModel() { }

        public UserModel(User user)
        {
            Id = user.Id;
            Email = user.Email;

            FirstName = user.FirstName;
            LastName = user.LastName;
            Pesel = user.Pesel;
            Address = user.Address;
            CreditCardNumber = user.CreditCardNumber;

            if (user.Role != null)
                RoleName =  user.Role.Name;
        }
    }
}