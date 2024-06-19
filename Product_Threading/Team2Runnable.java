package Product_Threading;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Model_Documentation.MessageDirectory;
import Product_Process.Product;
import Product_Process.ProductWriter;

public class Team2Runnable implements Runnable {
  protected static boolean messagesCompleted; 
  protected static boolean team2Done = true; 

  public void run() 
  {
    System.out.println("Accessing Team 2's run method."); 
    System.out.println("This will be the second team's thread in the 4v4 match."); 
    if(Team2Runnable.messagesCompleted == false)
    {
      new MessageDirectory();
    }
    if(Team2Runnable.messagesCompleted == true)
    {
      System.out.println("Starting round for team 2."); 
      try {
        FileWriter matchWriterFinalizer = ProductWriter.get_file_writer();
        FileReader roundReading;
        int roundNumber = 76; 
        for(int i = 0; i < roundNumber; i++) {
          roundReading = new FileReader("round_reading.txt"); 
          Product.startRound(1, matchWriterFinalizer, roundReading);
          roundReading.close(); 
        }
        matchWriterFinalizer.close(); 
      } catch (Exception e) {
        e.printStackTrace();
      } 
    }
  }

  public static boolean messagesCompleted()
  {
    return Team2Runnable.messagesCompleted; 
  }

  public static void main(String[]args)
  {
    //Utitlize Runnable's method run here
    new Thread(new Team2Runnable()).start(); 
  }
}
