package Article_Process;

import java.util.Arrays;
import java.util.List;

public class LinkedListAgentSystem1 {

  static Node head; 

  static class Node
  {
    String wizard; 
    List<String> data; 
    Node next; 

    Node(String wizard, List<String> data)
    { 
      this.wizard = wizard; 
      this.data = data; 
    }
  }

  void insert(LinkedListAgentSystem1.Node newNode)
  {
    if(head == null)
    {
      head = newNode; 
    }
    else 
    {
      Node root = head;
      while(root.next != null)
      {
        root = root.next; 
      }
      root.next = newNode; 
    }
  }


  void printNodeData()
  {
    if(head == null)
    {
      System.out.println("List is fully cleared.");
      return; 
    }
    Node current = head; 
    while(current.next != null)
    {
      System.out.println(current.wizard); 
      System.out.println(current.data);  
      current = current.next; 
    }
    System.out.println(current.wizard); 
    System.out.println(current.data); 
  }

  public static void main(String[]args)
  {
    LinkedListAgentSystem1.Node firstTestNode = new LinkedListAgentSystem1.Node("Travis Waterblood", Arrays.asList("Abstract Aeon Helm", "Abstract Aeon Cape", "Abstract Aeon Boots", "Abstract Aeon Sword", "Abstract Aeon Athame", "Abstract Aeon Amulet", "Abstract Aeon Ring", "Abstract Aeon Deck"));
    LinkedListAgentSystem1.Node secondTestNode = new LinkedListAgentSystem1.Node("Travis Waterblood", Arrays.asList("Macabre Aeon Helm", "Macabre Aeon Cape", "Macabre Aeon Boots", "Macabre Aeon Sword", "Macabre Aeon Athame", "Macabre Aeon Amulet", "Macabre Aeon Ring", "Macabre Aeon Deck"));
    LinkedListAgentSystem1.Node thirdTestNode = new LinkedListAgentSystem1.Node("Travis Waterblood", Arrays.asList("Inspired Aeon Helm", "Inspired Aeon Cape", "Inspired Aeon Boots", "Inspired Aeon Sword", "Inspired Aeon Athame", "Inspired Aeon Amulet", "Inspired Aeon Ring", "Inspired Aeon Deck"));


    LinkedListAgentSystem1 list = new LinkedListAgentSystem1(); 
    list.insert(firstTestNode); 
    list.insert(secondTestNode); 
    list.insert(thirdTestNode);

    //list.setPreviousPointers();

    list.printNodeData(); 

    list.printNodeData();
    
    
  }



}
