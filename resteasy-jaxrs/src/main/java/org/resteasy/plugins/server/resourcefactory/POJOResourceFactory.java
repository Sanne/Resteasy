package org.resteasy.plugins.server.resourcefactory;

import org.resteasy.spi.HttpInput;
import org.resteasy.spi.ResourceFactory;

/**
 * Allocates an instance of a class at each invocation
 *
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
public class POJOResourceFactory implements ResourceFactory
{
   private Class<?> scannableClass;

   public POJOResourceFactory(Class<?> scannableClass)
   {
      this.scannableClass = scannableClass;
   }

   public Object createResource(HttpInput input)
   {
      try
      {
         return scannableClass.newInstance();
      }
      catch (InstantiationException e)
      {
         throw new RuntimeException(e.getCause());
      }
      catch (IllegalAccessException e)
      {
         throw new RuntimeException(e);
      }
   }

   public Class<?> getScannableClass()
   {
      return scannableClass;
   }
}
