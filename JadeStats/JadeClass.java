package JadeStats;

public class JadeClass {
  
  {
    System.out.println("We are going to detect which piece of gear we are looking at.");
  }

  public JadeClass(String gearName, String gearType)
  {
    System.out.println("Jade Class created."); 
    retrieveStatsInfo(gearName, gearType); 
  }

  private void retrieveStatsInfo(String gearName, String gearType)
  {
    if(gearType.equals("ring"))
    {
      if(gearName.equals("Stone Of The Other Side"))
      {
        new JadeRingOption1Stats(gearName); 
      }
      else if(gearName.equals("Ring Of The Dying Star"))
      {
        new JadeRingOption2Stats(gearName); 
      }
    }
  }


}
