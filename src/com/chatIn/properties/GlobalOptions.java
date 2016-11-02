package com.chatIn.properties;

/*
* Created by Rahul
* Date: Nov 13, 2008
* Copyright (c): All rights reserved by the author
*/
public class GlobalOptions {
  public static void setServer(boolean server) {
    isServer = server;
  }

  public static boolean isServer() {
    return isServer;
  }

  private static boolean isServer = false;
}
