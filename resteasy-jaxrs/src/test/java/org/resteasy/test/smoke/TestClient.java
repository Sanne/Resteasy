package org.resteasy.test.smoke;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.resteasy.plugins.client.httpclient.ProxyFactory;
import org.resteasy.plugins.server.servlet.HttpServletDispatcher;
import org.resteasy.test.EmbeddedServletContainer;

/**
 * Simple smoke test
 *
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
public class TestClient
{

   private static HttpServletDispatcher dispatcher;

   @BeforeClass
   public static void before() throws Exception
   {
      dispatcher = EmbeddedServletContainer.start();
   }

   @AfterClass
   public static void after() throws Exception
   {
      EmbeddedServletContainer.stop();
   }

   @Test
   public void testNoDefaultsResource() throws Exception
   {
      int oldSize = dispatcher.getRegistry().getSize();
      dispatcher.getRegistry().addResource(SimpleResource.class);
      Assert.assertTrue(oldSize < dispatcher.getRegistry().getSize());

      SimpleClient client = ProxyFactory.create(SimpleClient.class, "http://localhost:8081");

      Assert.assertEquals("basic", client.getBasic());
      client.putBasic("hello world");
      Assert.assertEquals("hello world", client.getQueryParam("hello world"));
      Assert.assertEquals(1234, client.getUriParam(1234));

      dispatcher.getRegistry().removeRegistrations(SimpleResource.class);
      Assert.assertEquals(oldSize, dispatcher.getRegistry().getSize());
   }


}