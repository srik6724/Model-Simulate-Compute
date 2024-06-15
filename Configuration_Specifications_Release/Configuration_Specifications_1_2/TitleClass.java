package Configuration_Specifications_1_2;

public class TitleClass {
  
  {
    System.out.println("We are going to detect which piece of gear we are looking at.");
  }

  public TitleClass(String gearName, String gearType)
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
        new Title_Bind_7_Option_1(gearName); 
      }
      else if(gearName.equals("Ring Of The Dying Star"))
      {
        new Title_Bind_7_Option_2(gearName); 
      }
    }
  }


}
