package wizPackage;

import java.awt.BorderLayout;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;
import java.util.function.Predicate;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	public static void main(String[]args) throws InterruptedException, IOException
	{
		Predicate<Path> criteria = path -> {
			String fileName = path.getFileName().toString(); 
			return fileName.endsWith(".txt") && (fileName.contains("round") || fileName.contains("match")); 
		}; 

		Predicate<Path> fileCountCriteria = path -> {
			String fileName = path.getFileName().toString(); 
			return fileName.contains("round"); 
		};

		Path startPath = Paths.get("C:/Users/srik6/OneDrive/Desktop/wiz-simulator-new");

		deleteFiles(startPath, criteria);

		Match match = new Match(); 
		match.enroll2Teams(args); 

		Path directory = Paths.get("C:/Users/srik6/OneDrive/Desktop/wiz-simulator-new");
		long fileCount = Files.list(directory).filter(fileCountCriteria).count();
		System.out.println("Final count of round, match files in local directory: " + fileCount);
	}

	private static void deleteFiles(Path startPath, Predicate<Path> criteria) throws IOException {
		Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
						@Override
          	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (criteria.test(file)) {
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