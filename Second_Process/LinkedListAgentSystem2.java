package Second_Process;

import java.util.List;

public class LinkedListAgentSystem2 {
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

  void insert(LinkedListAgentSystem2.Node newNode)
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
}
