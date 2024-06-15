package Configuration_Specifications_1_1;

public class TitleClass {
  
  {
    System.out.println("We are going to detect which piece of gear we are looking at."); 
  }
  
  public TitleClass(String gearName, String gearType)
  {
    System.out.println("Spooky Class created."); 
    retrieveStatsInfo(gearName, gearType); 
  }

  private void retrieveStatsInfo(String gearName, String gearType)
  {
    if(gearType.equals("robe"))
    {
      new Title_Bind_1(gearName); 
    }
  }
}
