package CustomExceptions;

public class EmptyStringException extends Exception {
  public void printMessage()
  {
    System.out.println("The string is empty."); 
  }
}
