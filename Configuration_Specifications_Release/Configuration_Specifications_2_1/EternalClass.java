package Configuration_Specifications_2_1;

public class EternalClass {
  
  {
    System.out.println("We are going to detect which piece of gear we are looking at."); 
  }

  public EternalClass(String gearName, String gearType)
  {
    System.out.println("Eternal Class created.");
    retrieveStatsInfo(gearName, gearType);   
  }

  private void retrieveStatsInfo(String gearName, String gearType) {
    if(gearType.equals("hat"))
    {
      new EternalHatStats(gearName); 
    }
    else if(gearType.equals("robe"))
    {
      new EternalRobeStats(gearName); 
    }
    else if(gearType.equals("boots"))
    {
      new EternalBootsStats(gearName);
    }
    else if(gearType.equals("wand"))
    {
      new EternalWandStats(gearName);
    }
    else if(gearType.equals("athame"))
    {
      new EternalAthameStats(gearName);
    }
    else if(gearType.equals("amulet"))
    {
      new EternalAmuletStats(gearName);
    }
    else if(gearType.equals("ring"))
    {
      new EternalRingStats(gearName);
    }
    else if(gearType.equals("deck"))
    {
      new EternalDeckStats(gearName);
    }
  }
}
