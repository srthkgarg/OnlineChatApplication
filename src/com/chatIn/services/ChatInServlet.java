package com.chatIn.services;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sarthak on 30-11-2016.
 */
@WebServlet(name = "ChatInServlet")
public class ChatInServlet extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request, response);
  }

  public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request, response);
  }

  public void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write("In chatIn servlet");
  }
}
