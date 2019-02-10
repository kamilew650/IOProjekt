using Microsoft.Extensions.DependencyInjection;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CarRent
{
    /// <summary>
    /// A shorthand access class to get DI services with nice clean short code
    /// </summary>
    public static class IoC
    {
        /// <summary>
        /// The scoped instance of the <see cref="DbAppContext"/>
        /// </summary>
        public static DbAppContext DbAppContext => IoCContainter.Provider.GetService<DbAppContext>();
    }

    /// <summary>
    /// The dependency injection container making use of the built in .Net Core service provider
    /// </summary>
    public static class IoCContainter
    {
        /// <summary>
        /// The service provider for this application
        /// </summary>
        public static ServiceProvider Provider { get; set; }
    }
}
