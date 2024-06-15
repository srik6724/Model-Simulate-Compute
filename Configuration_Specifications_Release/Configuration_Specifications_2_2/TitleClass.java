package Configuration_Specifications_2_2;

public class TitleClass {
  
  {
    System.out.println("We are going to detect which piece of gear we are looking at."); 
  }

  public TitleClass(String gearName, String gearType)
  {
    System.out.println("NightMire Class created."); 
    retrieveStatsInfo(gearName, gearType); 
  }

private void retrieveStatsInfo(String gearName, String gearType) {
    if(gearType.equals("hat"))
    {
      new Title_Bind_1(gearName); 
    }
    else if(gearType.equals("robe"))
    {
      new Title_Bind_2(gearName); 
    }
    else if(gearType.equals("boots"))
    {
      new Title_Bind_3(gearName);
    }
  }
}
