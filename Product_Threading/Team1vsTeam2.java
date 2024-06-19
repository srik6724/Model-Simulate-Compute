package Product_Threading;

public class Team1vsTeam2 implements Runnable {
  private static int countDownTimer = 15; 
  public void run()
  {

    Thread team1 = new Thread(new Team1Runnable()); 
		Thread team2 = new Thread(new Team2Runnable()); 

    try{
      team1.start(); 
      team1.join(); 
      team2.start(); 
      team2.join(); 
    }catch(InterruptedException e)
    {
      e.printStackTrace();
    }

     Team1Runnable.messagesCompleted = true; 
     Team2Runnable.messagesCompleted = true; 

    while(countDownTimer >= 1)
    {
      try {
        Thread.sleep(1000);
        System.out.println("Countdown: " + countDownTimer); 
        countDownTimer--; 
      } catch (InterruptedException e) {
        e.printStackTrace();
      } 
    }
  }

  

  public static void main(String[]args)
  {
    Thread th = new Thread(new Team1vsTeam2());
    th.start(); 

    try {
      th.join(); 
    }catch(InterruptedException e)
    {
      //System.out.println("Execution will now resume in the main thread."); 
    }

    System.out.println("Match will now begin. Good luck to both teams!"); 
  }
}