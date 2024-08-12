package Second_Threading;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Model_Documentation.MessageDirectory;
import Second_Process.Second;
import Second_Process.SecondWriter;

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
        FileWriter secondWriterFinalizer = SecondWriter.get_file_writer(); 
        FileReader moduleReading = new FileReader("module_reading.txt");
        int moduleNumber = 1000; 
        for(int i = 0; i < moduleNumber; i++) {
          Second.startModule(0, secondWriterFinalizer, moduleReading);
        }
        moduleReading.close(); 
        secondWriterFinalizer.close(); 
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
