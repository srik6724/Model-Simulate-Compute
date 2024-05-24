package wizPackage;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

class FileOperation {

  private BufferedReader reader; 
  private FileWriter writer1;
  private FileWriter writer2; 
  private FileWriter writer3;  
  private String label;
  private int round;

  FileOperation(BufferedReader reader, FileWriter selectionWriter, FileWriter excessWriter, FileWriter remainsWriter, String teamLabel, int round) throws IOException {
    this.reader = reader; 
    this.writer1 = selectionWriter; 
    this.writer2 = excessWriter; 
    this.writer3 = remainsWriter; 
    this.label = teamLabel;
    this.round = round;
    System.out.println("Calling file operation for a task.");
    System.out.println("Cross checking team-label: " + this.label); 
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
            JFrame frame = new JFrame("Card " + ++number + " display for " + label); 
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            System.out.println("Presenting card definitions on frame for better reference."); 
            frame.setLayout(new GridLayout(5, 1)); 
            final String nameOfSpell = reader.readLine(); 
            JLabel label_1 = new JLabel(nameOfSpell);
            JLabel new_line_1 = new JLabel("\n"); 
            final String pipsOfSpell = reader.readLine(); 
            JLabel label_2 = new JLabel(pipsOfSpell);
            JLabel new_line_2 = new JLabel("\n"); 
            final String pipChanceOfSpell = reader.readLine(); 
            JLabel label_3 = new JLabel(pipChanceOfSpell); 
            JLabel new_line_3 = new JLabel("\n"); 
            final String countOfSpell = reader.readLine();
            JLabel label_4 = new JLabel(countOfSpell); 
            JLabel new_line_4 = new JLabel("\n"); 
            final String descriptionOfSpell = reader.readLine();
            JLabel label_5 = new JLabel(descriptionOfSpell);  
            JLabel new_line_5 = new JLabel("\n"); 
            JCheckBox checkBox1 = new JCheckBox("Select Spell"); 
            JCheckBox checkBox2 = new JCheckBox("Discard Spell"); 

            ItemListener itemListener = new ItemListener() {
              @Override
              public void itemStateChanged(ItemEvent e) {
                  if (e.getSource() == checkBox1 && checkBox1.isSelected()) {
                      checkBox2.setSelected(false);
                  } else if (e.getSource() == checkBox2 && checkBox2.isSelected()) {
                      checkBox1.setSelected(false);
                  }
              }
          };
          
          checkBox1.addItemListener(itemListener);
          checkBox2.addItemListener(itemListener);
            
          frame.getContentPane().add(label_1);
          frame.getContentPane().add(new_line_1); 
          frame.getContentPane().add(label_2);
          frame.getContentPane().add(new_line_2); 
          frame.getContentPane().add(label_3); 
          frame.getContentPane().add(new_line_3); 
          frame.getContentPane().add(label_4); 
          frame.getContentPane().add(new_line_4); 
          frame.getContentPane().add(label_5); 
          frame.getContentPane().add(new_line_5); 
          frame.getContentPane().add(checkBox1); 
          frame.getContentPane().add(checkBox2);

          frame.addWindowListener(new WindowAdapter() {
            @Override 
            public void windowClosing(WindowEvent e) {
              if(checkBox1.isSelected() && !checkBox2.isSelected()) {
                System.out.println("Check-box selected on window-closing."); 
                try {
                  writer1.write("----------------------------");
                  writer1.write(nameOfSpell); 
                  writer1.write(pipsOfSpell);
                  writer1.write(pipChanceOfSpell);
                  writer1.write(countOfSpell);
                  writer1.write(descriptionOfSpell);
                  writer1.write("----------------------------");
                  writer1.close(); 
                } catch (IOException e1) {
                  try {
                    if(label.equals("t1")) {
                      RoundSelectionLineTeam1Writer.setWriterCreated(false);
                      writer1 = RoundSelectionLineTeam1Writer.get_file_writer(round);
                      writer1.write("----------------------------");
                      writer1.write(nameOfSpell); 
                      writer1.write(pipsOfSpell);
                      writer1.write(pipChanceOfSpell);
                      writer1.write(countOfSpell);
                      writer1.write(descriptionOfSpell);
                      writer1.write("----------------------------");
                      writer1.close(); 
                    }
                    else if(label.equals("t2")) {
                      RoundSelectionLineTeam2Writer.setWriterCreated(false);
                      writer1 = RoundSelectionLineTeam2Writer.get_file_writer(round);
                      writer1.write("----------------------------");
                      writer1.write(nameOfSpell); 
                      writer1.write(pipsOfSpell);
                      writer1.write(pipChanceOfSpell);
                      writer1.write(countOfSpell);
                      writer1.write(descriptionOfSpell);
                      writer1.write("----------------------------");
                      writer1.close(); 
                    }
                  } catch (IOException sube1) {
                    System.out.println("Will not reach unless problem reading file.");
                  }
                } 
              }
              else if(checkBox2.isSelected() && !checkBox1.isSelected()) {
                try {
                  System.out.println("Check-box not selected on window-closing."); 
                  writer2.write("----------------------------");
                  writer2.write(nameOfSpell); 
                  writer2.write(pipsOfSpell); 
                  writer2.write(pipChanceOfSpell); 
                  writer2.write(countOfSpell); 
                  writer2.write(descriptionOfSpell); 
                  writer2.write("----------------------------");
                  writer2.close(); 
                } catch (IOException e2) {
                  try {
                    if(label.equals("t1")) {
                      RoundDiscardSpellsTeam1Writer.setWriterCreated(false);
                      writer2 = RoundDiscardSpellsTeam1Writer.get_file_writer(round); 
                      writer2.write("----------------------------");
                      writer2.write(nameOfSpell); 
                      writer2.write(pipsOfSpell); 
                      writer2.write(pipChanceOfSpell); 
                      writer2.write(countOfSpell); 
                      writer2.write(descriptionOfSpell); 
                      writer2.write("----------------------------");
                      writer2.close(); 
                    }
                    else if(label.equals("t2")) {
                      RoundDiscardSpellsTeam2Writer.setWriterCreated(false);
                      writer2 = RoundDiscardSpellsTeam2Writer.get_file_writer(round); 
                      writer2.write("----------------------------");
                      writer2.write(nameOfSpell); 
                      writer2.write(pipsOfSpell); 
                      writer2.write(pipChanceOfSpell); 
                      writer2.write(countOfSpell); 
                      writer2.write(descriptionOfSpell); 
                      writer2.write("----------------------------");
                      writer2.close(); 
                    }
                  } catch (IOException sube2) {
                    System.out.println("Will not reach unless problem reading file."); 
                  }
                }
              }
              else if(!checkBox1.isSelected() && !checkBox2.isSelected()) {
                try {
                  System.out.println("No boxes selected on window-closing."); 
                  writer3.write("----------------------------"); 
                  writer3.write(nameOfSpell); 
                  writer3.write(pipsOfSpell); 
                  writer3.write(pipChanceOfSpell); 
                  writer3.write(countOfSpell); 
                  writer3.write(descriptionOfSpell); 
                  writer3.write("----------------------------");
                  writer3.close(); 
                } catch (IOException e3) {
                  try {
                    if(label.equals("t1")) {
                      RoundLeftOverSpellsTeam1Writer.setWriterCreated(false);
                      writer3 = RoundLeftOverSpellsTeam1Writer.get_file_writer(round); 
                      writer3.write("----------------------------"); 
                      writer3.write(nameOfSpell); 
                      writer3.write(pipsOfSpell); 
                      writer3.write(pipChanceOfSpell); 
                      writer3.write(countOfSpell); 
                      writer3.write(descriptionOfSpell); 
                      writer3.write("----------------------------");
                      writer3.close(); 
                    }
                    else if(label.equals("t2")) {
                      RoundLeftOverSpellsTeam2Writer.setWriterCreated(false);
                      writer3 = RoundLeftOverSpellsTeam2Writer.get_file_writer(round); 
                      writer3.write("----------------------------"); 
                      writer3.write(nameOfSpell); 
                      writer3.write(pipsOfSpell); 
                      writer3.write(pipChanceOfSpell); 
                      writer3.write(countOfSpell); 
                      writer3.write(descriptionOfSpell); 
                      writer3.write("----------------------------");
                      writer3.close(); 
                    }
                  } catch (IOException sube3) {
                    System.out.println("Will not reach unless problem reading file."); 
                  }
                }
              }
              }
            });
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
  }
}
