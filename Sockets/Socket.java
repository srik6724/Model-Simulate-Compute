package Sockets;
//Socket class Information
//Any socket we have here has a name. 
//Any socket that exists also has a type assigned to them: triangle, circle, square, or tear.
public class Socket {
  private String name; 
  private String type; 
  private String school; 
  private String description; 

  public Socket()
  {
    System.out.println("Socket class created.");
  }

  public Socket(String description)
  {
    System.out.println("Constructor for if socket description is unused."); 
    this.description = description; 
  }

  public Socket(String name, String type, String school, String description)
  {
    this.name = name; 
    this.type= type;
    this.school = school; 
    this.description = description; 
  }

  public String getName()
  {
    return name;
  }

  public String getType()
  {
    return type; 
  }

  public String getSchool()
  {
    return school; 
  }

  public String getDescription()
  {
    return description; 
  }

  public void setDescription(String description)
  {
    this.description = description; 
  }
}
