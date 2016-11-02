package com.chatIn.services;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Created by Sarthak on 27-10-2016.
 */
public class StartUp {
  private static StartUp startup;

  private StartUp() {
  }

  public static void main(String[] args) throws Exception {
    Server server = new Server(7070);
    /*ServletHandler handler = new ServletHandler();
    server.setHandler(handler);
    final String servletName = "DefaultServlet";
    ServletHolder servlet = new ServletHolder(servletName, Default.class);
    handler.addServlet(servlet);
    ServletMapping servletMapping = new ServletMapping();
    servletMapping.setServletName(servletName);
    servletMapping.setPathSpecs(new String[]{"", "/jsp/index.jsp", "/index.jsp"});
    handler.addServletMapping(servletMapping);*/
    /*ServletContextHandler handler = new ServletContextHandler(server, "/DefaultServlet");
    handler.addServlet(Default.class, "/");
    server.setHandler(handler);
    server.start();*/

    WebAppContext ctx = new WebAppContext();
    ctx.setResourceBase("web");
    ctx.setContextPath("/index");
    ctx.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",".*/[^/]*jstl.*\\.jar$");
    org.eclipse.jetty.webapp.Configuration.ClassList classlist = org.eclipse.jetty.webapp.Configuration.ClassList.setServerDefault(server);
    classlist.addAfter("org.eclipse.jetty.webapp.FragmentConfiguration", "org.eclipse.jetty.plus.webapp.EnvConfiguration", "org.eclipse.jetty.plus.webapp.PlusConfiguration");
    classlist.addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration", "org.eclipse.jetty.annotations.AnnotationConfiguration");
    server.setHandler(ctx);
    server.start();
    server.join();

    /*startup = new StartUp();
    *//*startup.setupAll();
    startup.join(); // block forever till the thread dies*//*
    startup.start();
    System.exit(1);*/
  }

  public void start() {
    try {
      startup.setupAll();
      startup.join();
    } catch (Exception e) {
      e.printStackTrace();
    }
    //
  }

  private void join() {
    try {
      Thread.currentThread().join();
    } catch (InterruptedException e) {
      //ErrorBase.onFatal(e);
      System.out.println(e);
    } finally {
      //_logger.info(MsgKeys.THE_END);
      System.out.println("THE_END");
    }
  }

  private void setupAll(){

  }
}
