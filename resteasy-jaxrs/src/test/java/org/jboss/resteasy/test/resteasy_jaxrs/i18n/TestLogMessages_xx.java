package org.jboss.resteasy.test.resteasy_jaxrs.i18n;

import java.util.Locale;

/**
 * 
 * @author <a href="ron.sigal@jboss.com">Ron Sigal</a>
 * @version $Revision: 1.1 $
 * 
 * Copyright Sep 26, 2014
 */
public class TestLogMessages_xx extends TestLogMessages_Abstract
{
   @Override
   protected Locale getLocale()
   {
      return new Locale("xx");
   }
}
