package dataStructures;

public class HeapInfo {
  private int capacity; 
  private int size; 
  private static int heapifyCalls;
  private Element[] elements; 

  public HeapInfo(int size, int capacity)
  {
    this.size = size; 
    this.capacity = capacity;
    if(compareSizeToCapacity(size, capacity))
    {
      System.out.println("Size: " + size + " is less than or equal to " + capacity); 
    }
    else
    {
      System.out.println("Size: " + size + " is greater than " + capacity); 
      System.exit(1);
    }
    elements = new Element[size]; 
    for(int i = 0; i < elements.length; i++)
    {
      elements[i] = new Element("Insert SpellName Here", 0, "Insert Description Here", "Insert Pip Chance Here", "Insert Number Of Pips Here", "Insert School Name Here", "Insert Type Of Spell Here");
    }
    extractHeapInfo();
  }

  public void incrementHeapifyCalls()
  {
    heapifyCalls++; 
  }

  public boolean compareSizeToCapacity(int size, int capacity)
  {
    boolean check = false; 
    if(size <= capacity)
    {
      return !check;
    }
    return check; 
  }

  public int insertInHeap()
  {
    return 1;
  }

  public void extractHeapInfo()
  {
    System.out.println("Heap of size " + size + " and of capacity " + capacity + " created.");
  }

  public Element[] getElements()
  {
    return elements; 
  }


  public static void main(String[]args)
  {

  }

}
