package com.chatIn.services;

import org.eclipse.jetty.server.UserIdentity;

import javax.security.auth.Subject;
import java.security.Principal;
import java.util.concurrent.locks.ReentrantLock;

public class User implements UserIdentity {
  private static ReentrantLock USER_MOD_LOCK = new ReentrantLock();
  private Integer id;
  private String userName;
  private String email;
  private String passcode;

  public User() {
  }

  public static void save(String user, String password, String email) throws Exception {
    user = user.toLowerCase();
    validateArgs(user, password, email);
    thorErrorIsUserNameAlreadyExists(user);
    USER_MOD_LOCK.lock();
    try {
      User userObject = new User();
      userObject.setUserName(user);
      userObject.setPasscode(password);
      userObject.setEmail(email);
      //DBUtil.save(userObject, null); /*Todo: Think and see if invariant needed or not else use optional invariant instead of null*/
    } finally {
      USER_MOD_LOCK.unlock();
    }
  }

  public static void updatePassword(String userName, String password) throws Exception {
    try {
      User userObject = User.get(userName.toLowerCase());
      if (userObject == null) {
        Exception e = new Exception("User not found! Provide a valid User name");
        throw e;
      }
      validateArgs(userObject.getUserName(), password, userObject.getEmail());
      USER_MOD_LOCK.lock();

      userObject.setPasscode(password);
      //DBUtil.update(userObject, null); /*Todo: Think and see if invariant needed or not else use optional invariant instead of null*/
    } finally {
      if (USER_MOD_LOCK.isLocked())
        USER_MOD_LOCK.unlock();
    }
  }

  private static void validateArgs(String user, String password, String email) {
    if (user.isEmpty() || password.isEmpty()) {
      throw new IllegalArgumentException("Values can't be null");
    }
  }

  private static void thorErrorIsUserNameAlreadyExists(String user) throws Exception {
    /*user = user.toLowerCase();
    List<User> userList = DBUtil.list(User.class, Restrictions.eq("userName", user));
    if (userList != null && userList.size() > 0) {
      throw new Exception("User already exists.");
    }*/
  }

  public static User get(String name) throws Exception {
    /*List<User> name1 = DBUtil.list(User.class, Restrictions.eq("userName", name));
    return name1 != null && name1.size() > 0 ? name1.get(0) : null;*/
    return null;
  }

  public String getPasscode() {
    return passcode;
  }

  /**
   * Note: Private.. Can't be public
   *
   * @param passcode
   */
  public void setPasscode(String passcode) {
    this.passcode = passcode;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public Subject getSubject() {
    return null;
  }

  @Override
  public Principal getUserPrincipal() {
    return new Principal() {
      @Override
      public String getName() {
        return userName;
      }
    };
  }

  @Override
  public boolean isUserInRole(String s, Scope scope) {
    //UserType userType = UserType.valueOf(s);
    return true;
  }


}
