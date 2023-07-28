package wizPackage;

import java.util.Arrays;
import java.util.List;

public class LinkedList {

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

  void insert(LinkedList.Node newNode)
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

  void deleteAllNodeData()
  {
    head = null;
  }

  public static void main(String[]args)
  {
    LinkedList.Node firstTestNode = new LinkedList.Node("Travis Waterblood", Arrays.asList("Abstract Aeon Helm", "Abstract Aeon Cape", "Abstract Aeon Boots", "Abstract Aeon Sword", "Abstract Aeon Athame", "Abstract Aeon Amulet", "Abstract Aeon Ring", "Abstract Aeon Deck"));
    LinkedList.Node secondTestNode = new LinkedList.Node("Travis Waterblood", Arrays.asList("Macabre Aeon Helm", "Macabre Aeon Cape", "Macabre Aeon Boots", "Macabre Aeon Sword", "Macabre Aeon Athame", "Macabre Aeon Amulet", "Macabre Aeon Ring", "Macabre Aeon Deck"));
    LinkedList.Node thirdTestNode = new LinkedList.Node("Travis Waterblood", Arrays.asList("Inspired Aeon Helm", "Inspired Aeon Cape", "Inspired Aeon Boots", "Inspired Aeon Sword", "Inspired Aeon Athame", "Inspired Aeon Amulet", "Inspired Aeon Ring", "Inspired Aeon Deck"));


    LinkedList list = new LinkedList(); 
    list.insert(firstTestNode); 
    list.insert(secondTestNode); 
    list.insert(thirdTestNode);

    //list.setPreviousPointers();

    list.printNodeData(); 

    list.deleteAllNodeData();

    list.printNodeData();
    
    
  }



}
