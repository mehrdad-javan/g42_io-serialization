package se.lexicon.serializationExample.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.UUID;

public class Car {

  private String id;
  private String registerNumber;
  private String brand;
  private String model;
  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private LocalDate regDate;

  public Car() {
    this.id = UUID.randomUUID().toString();
  }

  public Car(String registerNumber, String brand, String model, LocalDate regDate) {
    this();
    this.registerNumber = registerNumber;
    this.brand = brand;
    this.model = model;
    this.regDate = regDate;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getRegisterNumber() {
    return registerNumber;
  }

  public void setRegisterNumber(String registerNumber) {
    this.registerNumber = registerNumber;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public LocalDate getRegDate() {
    return regDate;
  }

  public void setRegDate(LocalDate regDate) {
    this.regDate = regDate;
  }

  @Override
  public String toString() {
    return "Car{" +
            "id='" + id + '\'' +
            ", registerNumber='" + registerNumber + '\'' +
            ", brand='" + brand + '\'' +
            ", model='" + model + '\'' +
            ", regDate=" + regDate +
            '}';
  }
}
