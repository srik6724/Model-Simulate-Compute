package wiz_threading;

import Messages.MessageDirectory;
import wizPackage.Match;

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
      if(Team1Runnable.team1Done == true)
      {
         Match.startRound(1); 
         Team2Runnable.team2Done = true; 
         Thread th = new Thread(new Team1Runnable()); 
         th.start(); 
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
