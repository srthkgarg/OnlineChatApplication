package com.chatIn.services;

import org.eclipse.jetty.security.authentication.FormAuthenticator;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;

/**
 * Created by Sarthak on 27-10-2016.
 */
public class StartUp {
  private static StartUp startup;

  private StartUp() {
  }

  public static void main(String[] args) throws Exception {
    int port = 7070;

    QueuedThreadPool qtp = new QueuedThreadPool();
    qtp.setMaxThreads(1000);

    Server server = new Server(qtp);

    ServerConnector serverConnector = new ServerConnector(server);
    serverConnector.setPort(port);
    server.addConnector(serverConnector);

    WebAppContext webapp = new WebAppContext();
    webapp.setContextPath("/");
    webapp.getInitParams().put("org.eclipse.jetty.servlet.Default.useFileMappedBuffer", "false");
    webapp.setInitParameter("org.eclipse.jetty.servlet.Default.dirAllowed", "false");
    File warFilePath = new File("./web");
    webapp.setWar(warFilePath.getAbsolutePath());
    webapp.setParentLoaderPriority(true);
    webapp.getSecurityHandler().setAuthenticator(new LoginFormAuthenticator());
    webapp.getSecurityHandler().setLoginService(new ChatInLoginService());

    ResourceHandler staticHandler = new ResourceHandler();
    HandlerList handlers = new HandlerList();
    handlers.setHandlers(new Handler[]{webapp, staticHandler});
    server.setHandler(handlers);

    server.start();
    server.join();
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
