package wizPackage;

public class Wizard101LinkedList {
	static Node head; 
	static Wizard101LinkedList list; 
	
	public static int count = 0; 
	
	static class Node
	{
		
		String data; 
		Node next; 
		
		//Constructor
		Node(String d)
		{
			data = d; 
			next = null; 
		}
		
	}
	
	//Method to insert a new Node
	public static Node insert(String data)
	{
		Node new_node = new Node(data); 
		 
		
		if(list.head == null)
		{
			count = count + 1; 
			System.out.println("Count of Wizard Added: " + count); 
			list.head = new_node; 
			System.out.println("Head is " + new_node.data);
			return new_node; 
		}
		else
		{
			Node start = list.head; 
			System.out.println(start.data);
			while(start.next != null)
			{
				start = start.next; 
			}
			start.next = new Node(data); 
			count = count + 1; 
			System.out.println("Count of Wizard Added: " + count); 
			System.out.println("Data inserted: " + data);
			System.out.println("NewNode.data is " + start.next.data); 
			
			return start; 
		} 
	}
	
	public static void printData()
	{
		Wizard101LinkedList.Node retrieveHead = list.head; 
		
		while(retrieveHead != null)
		{
			System.out.println("Data is " + retrieveHead.data); 
			retrieveHead = retrieveHead.next; 
		}
		
	}
}
