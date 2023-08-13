package wiz_threading;

import Messages.MessageDirectory;

public class Team2Runnable implements Runnable {
  public void run()
  {
    System.out.println("Accessing Team 2's run method."); 
    System.out.println("This will be the second team's thread in the 4v4 match."); 
    new MessageDirectory();
  }

  public static void main(String[]args)
  {
    //Utitlize Runnable's method run here
    new Thread(new Team2Runnable()).start(); 
  }
}
