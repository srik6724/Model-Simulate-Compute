package DragoonStats;

public class DragoonClass {

  {
    System.out.println("We are going to detect which piece of gear we are looking at."); 
  }
  public DragoonClass(String gearName, String gearType)
  {
    System.out.println("Dragoon Class created."); 
    retrieveStatsInfo(gearName, gearType);
  }

  private void retrieveStatsInfo(String gearName, String gearType)
  {
    if(gearType.equals("hat"))
    {
      new DragoonHatStats(gearName); 
    }
    else if(gearType.equals("robe"))
    {
      new DragoonRobeStats(gearName); 
    }
    else if(gearType.equals("boots"))
    {
      new DragoonBootsStats(gearName);
    }
    else if(gearType.equals("athame"))
    {
      new DragoonAthameStats(gearName);
    }
    else if(gearType.equals("amulet"))
    {
      new DragoonAmuletStats(gearName);
    }
    else if(gearType.equals("ring"))
    {
      new DragoonRingStats(gearName);
    }
  }

}
