package se.lexicon.serializationExample;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import se.lexicon.serializationExample.model.Car;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONUtil {

  private ObjectMapper objectMapper;

  public JSONUtil() {
    objectMapper = new ObjectMapper();
    objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    objectMapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
    objectMapper.registerModule(new JavaTimeModule());
  }


  public void serializeListOfCars(List<Car> cars, File file) {
    try {
      if (!file.exists()) {
        file.createNewFile();
      }
      objectMapper.writeValue(file, cars);
      System.out.println("Operation is Done");
    } catch (IOException e) {
      e.printStackTrace();
    }

  }



  public List<Car> deserializeCarsJson(File file){
    List<Car> result = new ArrayList<>();
    try {
      result = objectMapper.readValue(file, new TypeReference<List<Car>>() {});
    }catch (IOException e){
      e.printStackTrace();
    }
    return result;
  }

  public  <T> String toJson(T t){
    String json = null;
    try{
      json = objectMapper.writeValueAsString(t);
    }catch (IOException e){
      e.printStackTrace();
    }

    return json;
  }

  public <T> T toObject(Class<T> type, String json){
    T result = null;
    try{
      result = objectMapper.readValue(json,type);
    }catch (IOException e){
      e.printStackTrace();
    }
    return result;
  }

  //....



}
