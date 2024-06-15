package Match_Documentation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Database.Credentials;
import RunTime.Failure.EmptyStringException;
import RunTime.Failure.TypeException;

public class MessageDirectory {
  private List<Message> messages = new ArrayList<Message>(); 
  private Message[] messageArray; 
  private Scanner sc = new Scanner(System.in); 
  private boolean completed = false; 
  /*
   * Store messages in database that user can select from. 
   * We will output all of the selected options however for the user to see. 
   * 
   * 
   * 
   * 
   */
  public synchronized void initialize() throws EmptyStringException {
    System.out.println("A place to access list of messages either retrieved from database or created by user."); 
    System.out.println("You will have the option to create your own custom message, or to choose one from the database."); 

    boolean temp = true; 

    while(temp)
    {
      System.out.println("For custom message, type CM, or for database message, type DM.");

      String optionSelected = sc.nextLine(); 
      if(optionSelected.equals("CM"))
      {
        System.out.println("Enter your custom message."); 
        String customMessage = sc.nextLine();
        if(customMessage.isEmpty())
        {
          throw new EmptyStringException();
        }
        if(customMessage instanceof String)
        {
          Message message = new Message(customMessage); 
          messageArray = addMessage(message); 
          completed = true;
        }
        else
        {
          System.out.println(customMessage + " is not of type " + String.class); 
        }
      }
      else if(optionSelected.equals("DM"))
      {
        try{
          Connection conn1;
          if(Credentials.authenticate(Credentials.getDB_USERNAME(), Credentials.getDB_PASSWORD()))
          {
            conn1 = DriverManager.getConnection(Credentials.getDB_URL(), Credentials.getDB_USERNAME(), Credentials.getDB_PASSWORD());
            if(conn1 != null)
            {
              String sql = "SELECT * FROM wizard_schema.4v4_sample_messages"; 
              PreparedStatement stmt = conn1.prepareStatement(sql); 
              ResultSet rs = stmt.executeQuery(); 
              int count = 1; 
              while(rs.next())
              {
                System.out.println("Message " + count + ": " + rs.getString("message")); 
                count++; 
                System.out.println("Is this the message you want? Answer y for yes, n for no.");
                String input = sc.nextLine(); 
                if(input.equals("y"))
                {
                  messageArray = addMessage(new Message(rs.getString("message")));
                  System.out.println("Breaking out of loop now."); 
                  break;
                }
                else if(input.equals("n"))
                {
                  continue; 
                }
              }
              completed = true; 
            }
          }
        }
        catch(SQLException e)
        {
          System.out.println("Sorry, an error occurred."); 
        }
      }
      temp = false; 
    }
  }

  {
    try 
    {
      initialize();
    }catch(EmptyStringException e)
    {
      e.printStackTrace();
      e.printMessage();
    }
    System.out.println("Initialization method completed."); 
  }

  public MessageDirectory()
  {
    System.out.println("Inside MessageDirectory() constructor."); 
    //System.out.println(completed); 
    //System.out.println(messageArray); 
    if(completed == true)
    {
      if(messageArray != null)
      {
        for(int i = 0; i < messageArray.length; i++)
        {
          System.out.println("Message " + (i+1) + ": " + messageArray[i].getText()); 
        }
      }
    }
  }

  public synchronized Message[] addMessage(Message message)
  {
    if(messages.size() == 0)
    {
      messages.add(message); 
      System.out.println("Message: " + message.getText() + " has been added.");  
      return messages.toArray(new Message[messages.size()]);  
    }
    for(int i = 0; i < messages.size(); i++)
    {
      if(!(messages.get(i).getText().equals(message.getText())))
      {
        messages.add(message); 
        System.out.println("Message: " + message.getText() + " has been added."); 
        break;
      }
    }
    return messages.toArray(new Message[messages.size()]); 
  }




}
