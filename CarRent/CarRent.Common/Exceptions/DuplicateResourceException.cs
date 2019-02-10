using System;
using System.Collections.Generic;
using System.Text;

namespace CarRent.Common
{
    public class DuplicateResourceException : Exception
    {
        public DuplicateResourceException(string message) : base(message)
        {
        }
    }
}
