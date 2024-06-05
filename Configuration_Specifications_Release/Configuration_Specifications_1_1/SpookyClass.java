package Configuration_Specifications_1_1;

public class SpookyClass {
  
  {
    System.out.println("We are going to detect which piece of gear we are looking at."); 
  }
  
  public SpookyClass(String gearName, String gearType)
  {
    System.out.println("Spooky Class created."); 
    retrieveStatsInfo(gearName, gearType); 
  }

  private void retrieveStatsInfo(String gearName, String gearType)
  {
    if(gearType.equals("robe"))
    {
      new SpookyRobeStats(gearName); 
    }
  }
}
