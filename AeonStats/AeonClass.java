package AeonStats;

public class AeonClass {

  {
    System.out.println("We are going to detect which piece of gear that we are looking at."); 
  }
  public AeonClass(String gearName, String gearType)
  {
    System.out.println("Aeon Class created."); 
    retrieveStatsInfo(gearName, gearType);
  }

  private void retrieveStatsInfo(String gearName, String gearType)
  {
    if(gearType.equals("hat"))
    {
      new AeonHatStats(gearName); 
    }
    else if(gearType.equals("robe"))
    {
      new AeonRobeStats(gearName); 
    }
    else if(gearType.equals("boots"))
    {
      new AeonBootsStats(gearName);
    }
    else if(gearType.equals("wand"))
    {
      new AeonWandStats(gearName);
    }
    else if(gearType.equals("athame"))
    {
      new AeonAthameStats(gearName);
    }
    else if(gearType.equals("amulet"))
    {
      new AeonAmuletStats(gearName);
    }
    else if(gearType.equals("ring"))
    {
      new AeonRingStats(gearName);
    }
    else if(gearType.equals("deck"))
    {
      new AeonDeckStats(gearName);
    }
  }
}
