package se.lexicon.serializationExample;


import se.lexicon.serializationExample.model.AppUser;
import se.lexicon.serializationExample.model.Car;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {

    //AppUser appUser= new AppUser(1,"user1@test.se","Test", "123456");
    //SerializationUtil.serializeAppUser(appUser);

    /*AppUser appUser = SerializationUtil.deserializeAppUser("AppUser.ser");
    System.out.println(appUser.getUserId());
    System.out.println(appUser.getEmail());
    System.out.println(appUser.getName());
    System.out.println("----------------------------------------");*/


    JSONUtil jsonUtil = new JSONUtil();
    List<Car> carList = new ArrayList<>();
    carList.add(new Car("R123", "VOLVO", "CX40", LocalDate.now()));
    carList.add(new Car("R222", "VW", "ID4", LocalDate.now()));
    carList.add(new Car("R333", "BMW", "X6", LocalDate.now()));

    /*File file = new File("Cars.json");
    //jsonUtil.serializeListOfCars(carList,file);
    List<Car> cars = jsonUtil.deserializeCarsJson(file);
    System.out.println(cars);*/


    Car test = new Car("R123", "VOLVO", "CX40", LocalDate.now());
    String jsonMessage = jsonUtil.toJson(test);
    System.out.println("jsonMessage = " + jsonMessage);

    Car res = jsonUtil.toObject(Car.class, jsonMessage);
    System.out.println(res.getId());
    System.out.println(res.getBrand());
    System.out.println(res.getModel());


  }
}
