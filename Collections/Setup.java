package Collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Setup {

  public Setup() {
    BlockingQueue<String> q = new BlockingQueue<String>() {
      @Override
      public String element() {
        String s = "element"; 
        return s; 
      }

      @Override
      public String peek() {
        String s = "peek"; 
        return s; 
      }

      @Override
      public String poll() {
        String s = "poll"; 
        return s; 
      }

      @Override
      public String remove() {
        String s = "remove"; 
        return s; 
      }

      @Override
      public boolean addAll(Collection<? extends String> c) {
        return false; 
      }

      @Override
      public void clear() {
        System.out.println("clear function definition"); 
      }

      @Override
      public boolean containsAll(Collection<?> c) {
        return false; 
      }

      @Override
      public boolean isEmpty() {
        return true; 
      }

      @Override
      public Iterator<String> iterator() {
        return null;
      }

      @Override
      public boolean removeAll(Collection<?> c) {
        return false; 
      }

      @Override
      public boolean retainAll(Collection<?> c) {
        return false; 
      }

      @Override
      public int size() {
        int x = 1; 
        return x; 
      }

      @Override
      public Object[] toArray() {
        return null;
      }

      @Override
      public <T> T[] toArray(T[] a) {
        return null;
      }

      @Override
      public boolean add(String e) {
        return true; 
      }

      @Override
      public boolean contains(Object o) {
        return false; 
      }

      @Override
      public int drainTo(Collection<? super String> c) {
        return 1; 
      }

      @Override
      public int drainTo(Collection<? super String> c, int maxElements) {
        return 1; 
      }

      @Override
      public boolean offer(String e) {
        return false; 
      }

      @Override
      public boolean offer(String e, long timeout, TimeUnit unit) throws InterruptedException {
        return false; 
      }

      @Override
      public String poll(long timeout, TimeUnit unit) throws InterruptedException {
        String s = "poll"; 
        return s; 
      }

      @Override
      public void put(String e) throws InterruptedException {
        System.out.println("put function definition"); 
      }

      @Override
      public int remainingCapacity() {
        int remainingCapacity = 2; 
        return remainingCapacity;
      }

      @Override
      public boolean remove(Object o) {
        return false;
      }

      @Override
      public String take() throws InterruptedException {
        String t = "take";
        return t; 
      }
    };

    boolean s1 = q.offer("a;lksdjf"); 
    System.out.println("Boolean Value of s1: " + s1);
  }
}
