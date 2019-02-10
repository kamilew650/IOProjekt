using System;
using System.Collections.Generic;
using System.Text;

namespace CarRent.Common
{
    public class CustomValidationException : Exception
    {
        public CustomValidationException(string message) : base(message)
        {
        }
    }
}
