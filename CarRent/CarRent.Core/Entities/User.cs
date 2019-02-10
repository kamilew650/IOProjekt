using Microsoft.AspNetCore.Identity;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace CarRent
{
    public class User : IdentityUser<int>
    {
        [StringLength(20)]
        public string FirstName { get; set; }
        [StringLength(30)]
        public string LastName { get; set; }
        [StringLength(11)]
        public string Pesel { get; set; }
        [StringLength(50)]
        public string Address { get; set; }
        [StringLength(19)]
        public string CreditCardNumber { get; set; }

        [Required, ForeignKey("Role")]
        public int RoleId { get; set; }
        public Role Role { get; set; }
    }
}
