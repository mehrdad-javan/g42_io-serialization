package se.lexicon.serializationExample;


import se.lexicon.serializationExample.model.AppUser;

public class App {
  public static void main(String[] args) {

    //AppUser appUser= new AppUser(1,"user1@test.se","Test", "123456");
    //SerializationUtil.serializeAppUser(appUser);

    AppUser appUser = SerializationUtil.deserializeAppUser("AppUser.ser");
    System.out.println(appUser.getUserId());
    System.out.println(appUser.getEmail());
    System.out.println(appUser.getName());
    System.out.println("----------------------------------------");



  }
}
