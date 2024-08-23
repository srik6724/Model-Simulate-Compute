package Second_Threading;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Model_Documentation.MessageDirectory;
import Second_Process.Second;
import Second_Process.SecondWriter;

public class Agent_System_2 implements Runnable {
  protected static boolean messagesCompleted; 
  protected static boolean team2Done = true; 

  public void run() 
  {
    System.out.println("Accessing Team 2's run method."); 
    System.out.println("This will be the second team's thread in the 4v4 match."); 
    if(Agent_System_2.messagesCompleted == false)
    {
      new MessageDirectory();
    }
    if(Agent_System_2.messagesCompleted == true)
    {
      System.out.println("Starting round for team 2."); 
      try {
        FileWriter matchWriterFinalizer = SecondWriter.get_file_writer();
        FileReader moduleReading;
        FileWriter secondDataPersistor = new FileWriter("second_transdata.txt"); 
        int roundNumber = 1000; 
        for(int i = 8; i < roundNumber; i++) {
          moduleReading = new FileReader("module_reading.txt"); 
          Second.startMicrosecond(1, matchWriterFinalizer, moduleReading, secondDataPersistor);
          moduleReading.close(); 
        }
        secondDataPersistor.close(); 
        matchWriterFinalizer.close(); 
      } catch (Exception e) {
        e.printStackTrace();
      } 
    }
  }

  public static boolean messagesCompleted()
  {
    return Agent_System_2.messagesCompleted; 
  }

  public static void main(String[]args)
  {
    //Utitlize Runnable's method run here
    new Thread(new Agent_System_2()).start(); 
  }
}
