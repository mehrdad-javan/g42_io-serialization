package se.lexicon;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Stream;

public class NIODemo {
  public static void main(String[] args) {
    ex3();
  }


  public static void ex1() {
    String content = "\nnew text";
    try {
      //Files.write(Paths.get("dir/test.txt"), content.getBytes(), StandardOpenOption.APPEND);
      Files.write(Paths.get("dir/test.txt"), content.getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public static void ex2(){
    try {
     Stream<String> stringStream = Files.lines(Paths.get("dir/test.txt"));
     stringStream.forEach(s -> System.out.println(s));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void ex3(){
    try {
      Files.copy(Paths.get("source/java_logo.png"), Paths.get("destination/nio.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
