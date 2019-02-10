using System;
using System.Collections.Generic;
using System.Text;

namespace CarRent.Common
{
    public class ResourceNotFoundException : Exception
    {
        public ResourceNotFoundException(string message) : base(message)
        {
        }
    }
}
