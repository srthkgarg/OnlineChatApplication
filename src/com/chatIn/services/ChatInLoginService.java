package com.chatIn.services;

import org.eclipse.jetty.security.IdentityService;
import org.eclipse.jetty.security.LoginService;
import org.eclipse.jetty.server.HttpChannel;
import org.eclipse.jetty.server.UserIdentity;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * Created by Sarthak on 27-10-2016.
 */
public class ChatInLoginService implements LoginService {
  //private final Logger logger = LoggerFactory.getLogger(EzLoginService.class.getPackage().getName());

  @Override
  public String getName() {
    return "ChatInAdminRealm";
  }

  @Override
  public UserIdentity login(String username, Object credentials) {
    Optional<User> userOptional = null;
    final Boolean[] rv = {Boolean.FALSE};
    try {
      userOptional = Optional.ofNullable(User.get(username));
      userOptional.ifPresent(user -> {
        Object pass = credentials;
        String digest = pass.toString();
        rv[0] = (digest == user.getPasscode());
      });
    } catch (Exception e) {
      System.out.println(e);
    }
    if (rv[0]) {
      HttpServletRequest httpServletRequest = HttpChannel.getCurrentHttpChannel().getRequest();
      HttpSession session = httpServletRequest.getSession(true);
      session.setAttribute("user", username);
    }
    return rv[0] ? userOptional.get() : null;
  }

  public boolean validate(org.eclipse.jetty.server.UserIdentity userIdentity) {
    try {
      return userIdentity != null && User.get(userIdentity.getUserPrincipal().getName()) != null;
    } catch (Exception e) {
      System.out.println(e);
    }
    return false;
  }


  public void logout(UserIdentity user) {
    System.out.println("Logout");
  }


  @Override
  public IdentityService getIdentityService() {
    return null;
  }

  @Override
  public void setIdentityService(IdentityService service) {

  }
}
