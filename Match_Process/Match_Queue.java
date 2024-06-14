package Match_Process;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Collections.Setup;

public class Match_Queue<T> {
	//private Match_List<Object> matches = new Match_List<Object>();
	public static void main(String[]args) throws InterruptedException, IOException
	{
		/*BlockingQueue<String> q = new BlockingQueue<String>() {
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
        return true;
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

		q.add("a;lksdjf");
		q.put("a;lksdjf");
    boolean s1 = q.offer("a;lksdjf"); 
    System.out.println("Boolean Value of s1: " + s1);
    boolean elementIsContained = q.contains("a;lksdjf");
    System.out.println("Boolean Value of elementIsContained: " + elementIsContained);
		System.exit(0); */
  
		Predicate<Path> criteria = path -> {
			String fileName = path.getFileName().toString(); 
			return fileName.endsWith(".txt") && (fileName.contains("round") || fileName.contains("match") || fileName.contains("category")); 
		}; 

		Predicate<Path> fileCountCriteria = path -> { 
			String fileName = path.getFileName().toString(); 
			return fileName.contains("round"); 
		}; 

		Path startPath = Paths.get("C:/Users/srik6/OneDrive/Desktop/Match (Model, Simulate, Compute)"); 

		deleteFiles(startPath, criteria); 

		File round_reading = new File("round_reading.txt");
		FileWriter round_reading_writer = new FileWriter(round_reading);
		round_reading_writer.write("full-card-list"); 
		round_reading_writer.close();
		Match match = new Match(round_reading); 
		match.enroll2Teams(args); 

		Path directory = Paths.get("C:/Users/srik6/OneDrive/Desktop/Match (Model, Simulate, Compute)");
		long fileCount = Files.list(directory).filter(fileCountCriteria).count();
		System.out.println("Final count of round, match files in local directory: " + fileCount);
	}

	private static void deleteFiles(Path startPath, Predicate<Path> criteria) throws IOException {
		Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
						@Override 
          	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if(criteria.test(file)) {
                    Files.delete(file);
                    System.out.println("Deleted file: " + file); 
                }
                return FileVisitResult.CONTINUE; 
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                // Handle the situation when a file visit fails (e.g., due to permissions issues)
                System.err.println("Failed to visit file: " + file + " due to " + exc);
                return FileVisitResult.CONTINUE; 
            }
		}); 
	}

}