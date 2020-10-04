package model;

import java.io.*;

public class DeserializeFromFile {

   public static void main(String[] args) throws IOException, ClassNotFoundException {

	   														///home/g/git/Java/JsonJavaExample/src/save.ser
       FileInputStream fileInputStream = new FileInputStream("/home/g/git/Java/JsonJavaExample/src/save.ser");
       ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

       SavedGame savedGame = (SavedGame) objectInputStream.readObject();

       System.out.println(savedGame);
   }
}