package Mechanisms;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

interface BlockingQueueIntermediary<T> {
  Object element(); 
  Object peek(); 
  Object remove(); 
  int poll(int entry);
  Object addAll(Collection<?> c); 
  void clear(); 
  boolean containsAll(Collection<?> c);
  boolean isEmpty();
  Iterator<Object> iterator(); 
  boolean removeAll(Collection<?> c);
  boolean retainAll(Collection<?> c);
  int size(); 
  Object[] toArray(); 
  <T> T[] toArray(T[] a);
  boolean contains(Object o);
  int drainTo(Collection<?> c);
  int drainTo(Collection<?> c, int maxElements);
  boolean offer(String e);
  boolean offer(String e, long timeout, TimeUnit unit) throws InterruptedException;
}
