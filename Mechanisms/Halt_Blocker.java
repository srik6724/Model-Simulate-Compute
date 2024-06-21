package Mechanisms;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Halt_Blocker<Host> {

  private boolean isFixed;
  private boolean isDynamic;
  private boolean isArray; 
  private Object dataCollection;

  private Halt_Blocker(String typeStructure, Object dataCollection)  {
    this.dataCollection = dataCollection;
    System.out.println("Figure out the type of the structure."); 
    if(typeStructure.equals("fixed")) {
      isFixed = true;
      Class<?> c = dataCollection.getClass();
      isArray = this.isArray(c, int.class); 
      System.out.println("isArray bool value: " + isArray); 
    }
    else if(typeStructure.equals("dynamic")) {
      isDynamic = true; 
    }
  }

  private boolean isArray(Class<?> host, Class<?> dataType) {
    return host.isArray() && host.getComponentType() == dataType;
  }  

  public Halt_Blocker(Object dataCollection, String typeStructure) {
    this(typeStructure, dataCollection); 
    // Use producer-consumer 
    BlockingQueueIntermediary<Object> q = new BlockingQueueIntermediary<Object>() {

      public Object element() {
        return "A halt_mechanism serving as an intermediary for data-collection of the agent-system";
      }

      public Object peek() {
        String s = "peek"; 
        return s; 
      }

      public Object remove() {
        String s = "remove"; 
        return s; 
      }

      public int poll(int entry) {
        int data = 0; 
        if(isFixed) {
          if(isArray) {
            int [] arr = (int []) dataCollection;
            int entryConversion = (int) entry;
            System.out.println("Entry Conversion: " + entryConversion);
            for(int e: arr) {
              if(e == entryConversion) {
                System.out.println("Data of e: " + e);
                data = e;
                break;
              }
            } 
          }
        }
        return data; 
      }

      public Object addAll(Collection<?> c) {
        return false; 
      }

      public void clear() {
        System.out.println("clear function definition"); 
      }

      public boolean containsAll(Collection<?> c) {
        return false; 
      }

      public boolean isEmpty() {
        return true; 
      }

      public Iterator<Object> iterator() {
        return null;
      }

      public boolean removeAll(Collection<?> c) {
        return false; 
      }

      public boolean retainAll(Collection<?> c) {
        return false; 
      }  
      
      public int size() {
        int size = 0; 
        if(isFixed) {
          if(isArray){
            int [] arr = (int [] ) dataCollection;
            size = arr.length;
          }
        }
        return size;
      }

      public Object[] toArray() {
        return null;
      }

      public <T> T[] toArray(T[] a) {
        return null;
      }

      public boolean contains(Object o) {
        return false; 
      }

      public int drainTo(Collection<?> c) {
        return 1; 
      }

      public int drainTo(Collection<?> c, int maxElements) {
        return 1; 
      }

      public boolean offer(String e) {
        return false; 
      }

      public boolean offer(String e, long timeout, TimeUnit unit) throws InterruptedException {
        return false; 
      }

    };

    Object purpose = q.element(); 
    int agentSystemSize = q.size(); 
    System.out.println("Purpose: " + purpose);
    System.out.println("Size Of Agent System: " + agentSystemSize);
    System.out.println("Conducting a poll for an element");
    Object entry1 = q.poll(1);
    Object entry2 = q.poll(2); 
    Object entry3  = q.poll(3); 
    Object entry4 = q.poll(4); 
    System.out.println("Entry 1: " + entry1);
    System.out.println("Entry 2: " + entry2);
    System.out.println("Entry 3: " + entry3);
    System.out.println("Entry 4: "  + entry4);
    // boolean s1 = q.offer("a;lksdjf"); 
    // System.out.println("Boolean Value of s1: " + s1);
    // boolean elementIsContained = q.contains("a;lksdjf");
    // System.out.println("Boolean Value of elementIsContained: " + elementIsContained);
  }
}