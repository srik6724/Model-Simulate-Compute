package wiz_threading;

import java.io.IOException;

import Messages.MessageDirectory;
import wizPackage.Match;

public class Team1Runnable implements Runnable {
  protected static boolean messagesCompleted; 
  protected static boolean team1Done = true; 

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

      if(Team2Runnable.team2Done == true)
      {
        try {
          Match.startRound(0);
        } catch (IOException e) {
          e.printStackTrace();
        } 
        Team1Runnable.team1Done = true; 
        Thread th = new Thread(new Team2Runnable()); 
        th.start(); 
      }
    }
  }

  public static void main(String[]args)
  {
    new Thread(new Team1Runnable()).start(); 
  }
}
