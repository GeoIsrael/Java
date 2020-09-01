package model;

import java.io.*;

public class DeserializeFromFile {

   public static void main(String[] args) throws IOException, ClassNotFoundException {

       FileInputStream fileInputStream = new FileInputStream("/home/g/eclipse-workspace/JsonJavaExample/src/save.ser");
       ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

       SavedGame savedGame = (SavedGame) objectInputStream.readObject();

       System.out.println(savedGame);
   }
}