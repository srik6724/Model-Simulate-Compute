package Domain_Process;

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


public class Domain_Queue<T> {
	//private Match_List<Object> matches = new Match_List<Object>();
	public static void main(String[]args) throws InterruptedException, IOException
	{
		Predicate<Path> criteria = path -> {
			String fileName = path.getFileName().toString(); 
			return fileName.endsWith(".txt") && (fileName.contains("module") || fileName.contains("domain") || fileName.contains("category") || fileName.contains("token")); 
		}; 

		Predicate<Path> fileCountCriteria = path -> { 
			String fileName = path.getFileName().toString(); 
			return fileName.contains("module"); 
		}; 

		Path startPath = Paths.get("C:/Users/srik6/OneDrive/Desktop/Match (Model, Simulate, Compute)"); 

		deleteFiles(startPath, criteria); 

		File module_reading = new File("module_reading.txt");
		FileWriter module_reading_writer = new FileWriter(module_reading);
		module_reading_writer.write("full-card-list"); 
		module_reading_writer.close();
		Domain assembly = new Domain(module_reading); 
		assembly.enroll2Teams(args); 

		Path directory = Paths.get("C:/Users/srik6/OneDrive/Desktop/Match (Model, Simulate, Compute)");
		long fileCount = Files.list(directory).filter(fileCountCriteria).count();
		System.out.println("Final count of round, module files in local directory: " + fileCount);
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