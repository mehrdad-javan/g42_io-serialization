package se.lexicon.serializationExample.model;

import java.io.Serializable;

public class AppUser implements Serializable {

  private static final String NO_EMAIL = "No email set";
  private static final String NO_NAME = "Anonymous";

  private int userId;
  private String email;
  private String name;
  private transient String password;

  public AppUser() {
  }

  public AppUser(int userId, String email, String name, String password) {
    this.userId = userId;
    this.email = email;
    this.name = name;
    this.password = password;
  }

  public static String getNoEmail() {
    return NO_EMAIL;
  }

  public static String getNoName() {
    return NO_NAME;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "AppUser{" +
            "userId=" + userId +
            ", email='" + email + '\'' +
            ", name='" + name + '\'' +
            '}';
  }
}
