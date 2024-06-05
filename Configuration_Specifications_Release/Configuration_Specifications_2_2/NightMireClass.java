package Configuration_Specifications_2_2;

public class NightMireClass {
  
  {
    System.out.println("We are going to detect which piece of gear we are looking at."); 
  }

  public NightMireClass(String gearName, String gearType)
  {
    System.out.println("NightMire Class created."); 
    retrieveStatsInfo(gearName, gearType); 
  }

private void retrieveStatsInfo(String gearName, String gearType) {
    if(gearType.equals("hat"))
    {
      new NightMireHatStats(gearName); 
    }
    else if(gearType.equals("robe"))
    {
      new NightMireCoatStats(gearName); 
    }
    else if(gearType.equals("boots"))
    {
      new NightMireBootsStats(gearName);
    }
  }
}
