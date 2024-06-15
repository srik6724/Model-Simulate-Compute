package Configuration_Specifications_2_0;

import java.io.IOException;

public class TitleClass{

  {
    System.out.println("We are going to detect which piece of gear that we are looking at."); 
  }
  public TitleClass(String gearName, String gearType) throws IOException
  {
    System.out.println("Aeon Class created."); 
    retrieveStatsInfo(gearName, gearType);
  }

  private void retrieveStatsInfo(String gearName, String gearType) throws IOException
  {
    System.out.println(gearType); 
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
    else if(gearType.equals("wand"))
    {
      new Title_Bind_4(gearName);
    }
    else if(gearType.equals("athame"))
    {
      new Title_Bind_7(gearName);
    }
    else if(gearType.equals("amulet"))
    {
      new Title_Bind_5(gearName);
    }
    else if(gearType.equals("ring"))
    {
      new Title_Bind_6(gearName);
    }
    else if(gearType.equals("deck"))
    {
      new Title_Bind_8(gearName);
    }
  }
}
