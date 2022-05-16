package se.lexicon;

import java.io.*;

public class IODemo {

  public static void main(String[] args) {
    /*File source = new File("source/java_logo.png");
    File destination = new File("destination/java_logo_copy.png");
    //copy(source, destination);
    copyBuffer(source, new File("destination/java_logo_new_copy.png"));*/


    //String text= "Hello World";
    //writeText(new File("destination/string.txt"), text);
    try {
      String res = readText(new File("destination/string.txt"));
      System.out.println(res);
    }catch (IOException e){
      e.printStackTrace();
    }


  }

  //FileInputStream & FileOutputStream
  public static void copy(File source, File destination) {

    try (
            InputStream inputStream = new FileInputStream(source);
            OutputStream outputStream = new FileOutputStream(destination)
    ) {
      int b;
      while ((b = inputStream.read()) != -1) {
        outputStream.write(b);
      }
      System.out.println("Operation is Done");
    } catch (IOException e) {
      e.printStackTrace();
    }

  }


  // BufferedInputStream && BufferedOutputStream
  public static void copyBuffer(File source, File destination) {

    try (
            InputStream inputStream = new FileInputStream(source);
            BufferedInputStream in = new BufferedInputStream(inputStream);
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destination));
    ) {
      byte[] buffer = new byte[1024]; // 1 M = 1024 KB
      int byteRead;
      while ((byteRead = in.read(buffer)) > 0) {
        out.write(buffer, 0, byteRead);
        out.flush();
      }

      System.out.println("Operation is Done");
    } catch (IOException e) {
      e.printStackTrace();
    }

  }


  //FileWriter
  public static void writeText(File destination, String text) {
    try (
            FileWriter writer = new FileWriter(destination);
    ) {
      if (!destination.exists()) {
        destination.createNewFile();
      }
      writer.write(text);
      System.out.println("Operation is Done");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //FileReader
  public static String readText(File source) throws IOException {
    StringBuilder stringBuilder = new StringBuilder();
    FileReader reader = null;
    try {
      reader = new FileReader(source);

      int i;
      while ((i = reader.read()) != -1) {
        char letter = (char) i;
        stringBuilder.append(letter);
      }

    } finally {
      if (reader != null){
        try {
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    return stringBuilder.toString();
  }

}
