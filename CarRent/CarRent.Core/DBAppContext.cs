using CarRent.Common;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;
using System.Collections.Generic;

namespace CarRent.Core
{
    public class DbAppContext : DbContext
    {
        public DbSet<User> Users { get; set; }

        public DbSet<Role> Roles { get; set; }

        public DbSet<Car> Cars { get; set; }

        public DbSet<Lease> Leases { get; set; }

        public DbAppContext(DbContextOptions<DbAppContext> options)
            : base(options)
        {
            Database.EnsureCreated();
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            //var roleNameConversion = new StringToEnumConverter<UserRoles>();

            //TODO(AM): Dodaæ FK, indeksy, grupy PK
            //modelBuilder.Entity<Role>().Property(p => p.Name).HasConversion(roleNameConversion);

            base.OnModelCreating(modelBuilder);
        }
    }
}