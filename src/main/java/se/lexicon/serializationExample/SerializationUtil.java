package se.lexicon.serializationExample;

import se.lexicon.serializationExample.model.AppUser;

import java.io.*;

public class SerializationUtil {

  public static void serializeAppUser(AppUser appUser){
    String fileName = "AppUser.ser";
    try(
            FileOutputStream outputStream = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(outputStream)
            ){
      out.writeObject(appUser);
      System.out.println("Operation is Done");
    }catch (IOException e){
      e.printStackTrace();
    }
  }

  public static <T> void serialize(T t, String fileName){
    try(
            FileOutputStream outputStream = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(outputStream)
    ){
      out.writeObject(t);
      System.out.println("Operation is Done");
    }catch (IOException e){
      e.printStackTrace();
    }
  }


  public static AppUser deserializeAppUser(String fileName){
    AppUser result = null;
    try(
            InputStream inputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)
            ){
       result =  (AppUser) objectInputStream.readObject();
    }catch (IOException | ClassNotFoundException e){
      e.printStackTrace();
    }
    return result;
  }

  public static <T> T deserialize(String fileName){
    try(
            InputStream inputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)
    ){
      return (T) objectInputStream.readObject();
    }catch (IOException | ClassNotFoundException e){
      e.printStackTrace();
    }
    return null;
  }


}
