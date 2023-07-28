package wiz_threading;

public class Team1vsTeam2 implements Runnable {
  private static int countDownTimer = 15; 
  public void run()
  {
    while(countDownTimer >= 1)
    {
      try {
        Thread.sleep(1000);
        System.out.println("Countdown: " + countDownTimer); 
        countDownTimer--; 
        System.out.println("Countdown after decrement: " + countDownTimer);
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
