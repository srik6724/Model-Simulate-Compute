package Product_Threading;

public class AgentSystem1XAgentSystem2 implements Runnable {
  private static int countDownTimer = 15; 
  public void run()
  {

    Thread agent_system_1 = new Thread(new Agent_System_1()); 
		Thread agent_system_2 = new Thread(new Agent_System_2()); 

    try{
      agent_system_1.start(); 
      agent_system_1.join(); 
      agent_system_2.start(); 
      agent_system_2.join(); 
    }catch(InterruptedException e)
    {
      e.printStackTrace();
    }

     Agent_System_1.messagesCompleted = true; 
     Agent_System_2.messagesCompleted = true; 

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
    Thread th = new Thread(new AgentSystem1XAgentSystem2());
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