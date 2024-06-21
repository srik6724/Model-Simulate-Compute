package Product_Threading;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Model_Documentation.MessageDirectory;
import Product_Process.Product;
import Product_Process.ProductWriter;

public class Agent_System_1 implements Runnable {
  protected static boolean messagesCompleted; 
  protected static boolean team1Done = false; 

  public void run()
  {
    System.out.println("Accessing Team 1's run method."); 
    System.out.println("This will be the first team's thread in the 4v4 match."); 

    if(Agent_System_1.messagesCompleted == false)
    {
      new MessageDirectory(); 
    }
    if(Agent_System_1.messagesCompleted == true)
    {
      System.out.println("Starting round for team 1."); 
      try {
        FileWriter matchWriterFinalizer = ProductWriter.get_file_writer(); 
        FileReader roundReading = new FileReader("round_reading.txt");
        int roundNumber = 76; 
        for(int i = 0; i < roundNumber; i++) {
          Product.startRound(0, matchWriterFinalizer, roundReading);
        }
        roundReading.close(); 
        matchWriterFinalizer.close(); 
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

  }

  public static void main(String[]args)
  {
    new Thread(new Agent_System_1()).start(); 
  }
}
