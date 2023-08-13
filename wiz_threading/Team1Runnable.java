package wiz_threading;

import Messages.MessageDirectory;

public class Team1Runnable implements Runnable {
  public void run()
  {
    System.out.println("Accessing Team 1's run method."); 
    System.out.println("This will be the first team's thread in the 4v4 match."); 
    new MessageDirectory(); 
  }



  public static void main(String[]args)
  {
    new Thread(new Team1Runnable()).start(); 
  }
}
