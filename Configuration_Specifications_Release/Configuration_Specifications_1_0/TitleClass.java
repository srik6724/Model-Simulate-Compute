package Configuration_Specifications_1_0;

public class TitleClass {

  {
    System.out.println("We are going to detect which piece of gear we are looking at."); 
  }
  public TitleClass(String gearName, String gearType)
  {
    System.out.println("Dragoon Class created."); 
    retrieveStatsInfo(gearName, gearType);
  }

  private void retrieveStatsInfo(String gearName, String gearType)
  {
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
    else if(gearType.equals("athame"))
    {
      new Title_Bind_6(gearName);
    }
    else if(gearType.equals("amulet"))
    {
      new Title_Bind_5_(gearName);
    }
    else if(gearType.equals("ring"))
    {
      new Title_Bind_7(gearName);
    }
  }

}
