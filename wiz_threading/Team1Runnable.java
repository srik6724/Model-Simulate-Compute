package wiz_threading;

import java.io.IOException;

import Messages.MessageDirectory;
import wizPackage.Match;

public class Team1Runnable implements Runnable {
  protected static boolean messagesCompleted; 
  protected static boolean team1Done = false; 

  public void run()
  {
    System.out.println("Accessing Team 1's run method."); 
    System.out.println("This will be the first team's thread in the 4v4 match."); 

    if(Team1Runnable.messagesCompleted == false)
    {
      new MessageDirectory(); 
    }
    if(Team1Runnable.messagesCompleted == true)
    {
      System.out.println("Starting round for team 1."); 
      try {
        int roundNumber = 10; 
        for(int i = 0; i < roundNumber; i++) {
          Match.startRound(0);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }

  public static void main(String[]args)
  {
    new Thread(new Team1Runnable()).start(); 
  }
}
