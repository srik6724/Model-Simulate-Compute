package wizPackage;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javafx.scene.layout.Border;

class FileOperation {

  private BufferedReader reader; 
  private FileWriter writer; 

  FileOperation(BufferedReader reader, FileWriter writer) {
    this.reader = reader; 
    this.writer = writer; 
    System.out.println("Calling file operation for a task.");
    //run(); 
  }

  public void run() {
    // Reading lines from the reader
    System.out.println("Reading lines from the reader.");
    Scanner sc = new Scanner(System.in); 
    System.out.println("Read full-card-list or card-by-card for round?"); 
    String optionSelected = sc.nextLine(); 
    if(optionSelected.equals("full-card-list")) {
      try {
        String line; 
        int number = 0;
        while((line = reader.readLine()) != null) {
          System.out.println(line); 
          if(line.contains("Card")) {
            JFrame frame = new JFrame("Card " + ++number + "display"); 
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            System.out.println("Presenting card definitions on frame for better reference."); 
            frame.setLayout(new GridLayout(5, 1)); 
            JLabel label_1 = new JLabel("Name Of Spell");
            JLabel label_2 = new JLabel("Pips Of Spell");
            JLabel label_3 = new JLabel("Pip Chance Of Spell"); 
            JLabel label_4 = new JLabel("Count Of Spell"); 
            JLabel label_5 = new JLabel("Description Of Spell");  
            frame.getContentPane().add(label_1);
            frame.getContentPane().add(label_2);
            frame.getContentPane().add(label_3); 
            frame.getContentPane().add(label_4); 
            frame.getContentPane().add(label_5); 
            frame.pack(); 
            frame.setLocationRelativeTo(null);
            frame.setVisible(true); 
          }
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    else if(optionSelected.equals("card-by-card")) {
      try {
        String line; 
        while((line = reader.readLine()) != null) {

        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    try {
      String line; 
      while((line = reader.readLine()) != null) {
        System.out.println("Reading out each line: " + line); 
        System.exit(0); 
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  

  
}
