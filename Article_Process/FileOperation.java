package Article_Process;

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
import java.io.FileReader;
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
  private FileWriter writerTemp;
  private FileReader reader1;
  private String label;
  private int round;
  private String line1; 
  private String line2; 
  private String line3;
  private int size; 

  FileOperation(BufferedReader reader, FileWriter selectionWriter, FileWriter excessWriter, FileWriter remainsWriter, FileWriter combineWriter, FileReader processReader, String teamLabel, int round, String selectionStart, String discardStart, String remainingStart, int size) throws IOException {
    this.reader = reader; 
    this.writer1 = selectionWriter; 
    this.writer2 = excessWriter; 
    this.writer3 = remainsWriter; 
    this.reader1 = processReader;
    this.writerTemp = combineWriter;
    this.label = teamLabel;
    this.round = round;
    this.line1 = selectionStart;
    this.line2 = discardStart;
    this.line3 = remainingStart;
    this.size = size; 
    System.out.println("Calling file operation for a task.");
    System.out.println("Cross checking team-label: " + this.label); 
  }

  public void run() throws IOException {
    System.out.println("Read full-card-list or card-by-card for round?"); ; 
    BufferedReader round_reader = new BufferedReader(reader1); 
    String input = round_reader.readLine(); 
    round_reader.close(); 
    if(input.equals("full-card-list")) {
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
                  writer1.write(line1 + "\n");
                  writerTemp.write(line1 + "\n");
                  writer1.write("----------------------------\n");
                  writerTemp.write("----------------------------\n");
                  writer1.write(nameOfSpell + "\n"); 
                  writerTemp.write(nameOfSpell + "\n"); 
                  writer1.write(pipsOfSpell + "\n");
                  writerTemp.write(pipsOfSpell + "\n"); 
                  writer1.write(pipChanceOfSpell + "\n");
                  writerTemp.write(pipChanceOfSpell + "\n");
                  writer1.write(countOfSpell + "\n");
                  writerTemp.write(countOfSpell + "\n"); 
                  writer1.write(descriptionOfSpell + "\n");
                  writerTemp.write(descriptionOfSpell + "\n");
                  writer1.write("----------------------------\n");
                  writerTemp.write("----------------------------\n");
                  writer1.close(); 
                  if(label.equals("t1")) {
                    for(int i = 0; i < size; i++) {
                      CrossCheckSelectionTeam1MemberSpellsWriter.file_writers[size].write(line1 + "\n"); 
                      CrossCheckSelectionTeam1MemberSpellsWriter.file_writers[size].write("----------------------------\n"); 
                      CrossCheckSelectionTeam1MemberSpellsWriter.file_writers[size].write(nameOfSpell + "\n"); 
                      CrossCheckSelectionTeam1MemberSpellsWriter.file_writers[size].write(pipsOfSpell + "\n"); 
                      CrossCheckSelectionTeam1MemberSpellsWriter.file_writers[size].write(pipChanceOfSpell + "\n"); 
                      CrossCheckSelectionTeam1MemberSpellsWriter.file_writers[size].write(countOfSpell + "\n"); 
                      CrossCheckSelectionTeam1MemberSpellsWriter.file_writers[size].write(descriptionOfSpell + "\n"); 
                      CrossCheckSelectionTeam1MemberSpellsWriter.file_writers[size].write("----------------------------\n");
                    }
                  }
                  else if(label.equals("t2")) {
                      CrossCheckSelectionTeam2MemberSpellsWriter.file_writers[size].write(line1 + "\n"); 
                      CrossCheckSelectionTeam2MemberSpellsWriter.file_writers[size].write("----------------------------\n"); 
                      CrossCheckSelectionTeam2MemberSpellsWriter.file_writers[size].write(nameOfSpell + "\n"); 
                      CrossCheckSelectionTeam2MemberSpellsWriter.file_writers[size].write(pipsOfSpell + "\n"); 
                      CrossCheckSelectionTeam2MemberSpellsWriter.file_writers[size].write(pipChanceOfSpell + "\n"); 
                      CrossCheckSelectionTeam2MemberSpellsWriter.file_writers[size].write(countOfSpell + "\n"); 
                      CrossCheckSelectionTeam2MemberSpellsWriter.file_writers[size].write(descriptionOfSpell + "\n"); 
                      CrossCheckSelectionTeam2MemberSpellsWriter.file_writers[size].write("----------------------------\n");
                  }
                } catch (IOException e1) {
                  try {
                    if(label.equals("t1")) {
                      CrossCheckSelectionTeam1Writer.setWriterCreated(false);
                      writer1 = CrossCheckSelectionTeam1Writer.get_file_writer(round);
                      writer1.write("----------------------------\n");
                      writerTemp.write("----------------------------\n");
                      writer1.write(nameOfSpell + "\n"); 
                      writerTemp.write(nameOfSpell + "\n");
                      writer1.write(pipsOfSpell + "\n");
                      writerTemp.write(pipsOfSpell + "\n");
                      writer1.write(pipChanceOfSpell + "\n");
                      writerTemp.write(pipChanceOfSpell + "\n");
                      writer1.write(countOfSpell  + "\n");
                      writerTemp.write(countOfSpell + "\n");
                      writer1.write(descriptionOfSpell + "\n");
                      writerTemp.write(descriptionOfSpell + "\n");
                      writer1.write("----------------------------\n");
                      writerTemp.write("----------------------------\n");
                      writer1.close(); 
                      for(int i = 0; i < size; i++) {
                        CrossCheckSelectionTeam1MemberSpellsWriter.file_writers[size].write("----------------------------\n"); 
                        CrossCheckSelectionTeam1MemberSpellsWriter.file_writers[size].write(nameOfSpell + "\n"); 
                        CrossCheckSelectionTeam1MemberSpellsWriter.file_writers[size].write(pipsOfSpell + "\n"); 
                        CrossCheckSelectionTeam1MemberSpellsWriter.file_writers[size].write(pipChanceOfSpell + "\n"); 
                        CrossCheckSelectionTeam1MemberSpellsWriter.file_writers[size].write(countOfSpell + "\n"); 
                        CrossCheckSelectionTeam1MemberSpellsWriter.file_writers[size].write(descriptionOfSpell + "\n"); 
                        CrossCheckSelectionTeam1MemberSpellsWriter.file_writers[size].write("----------------------------\n");
                      }
                    }
                    else if(label.equals("t2")) {
                      CrossCheckSelectionTeam2Writer.setWriterCreated(false);
                      writer1 = CrossCheckSelectionTeam2Writer.get_file_writer(round);
                      writer1.write("----------------------------\n");
                      writerTemp.write("----------------------------\n");
                      writer1.write(nameOfSpell + "\n"); 
                      writerTemp.write(nameOfSpell + "\n");
                      writer1.write(pipsOfSpell + "\n");
                      writerTemp.write(pipsOfSpell + "\n");
                      writer1.write(pipChanceOfSpell + "\n");
                      writerTemp.write(pipChanceOfSpell + "\n");
                      writer1.write(countOfSpell + "\n");
                      writerTemp.write(countOfSpell + "\n");
                      writer1.write(descriptionOfSpell + "\n");
                      writerTemp.write(descriptionOfSpell + "\n");
                      writer1.write("----------------------------\n");
                      writerTemp.write("----------------------------\n");
                      writer1.close(); 
                      for(int i = 0; i < size; i++) {
                        CrossCheckSelectionTeam2MemberSpellsWriter.file_writers[size].write("----------------------------\n"); 
                        CrossCheckSelectionTeam2MemberSpellsWriter.file_writers[size].write(nameOfSpell + "\n"); 
                        CrossCheckSelectionTeam2MemberSpellsWriter.file_writers[size].write(pipsOfSpell + "\n"); 
                        CrossCheckSelectionTeam2MemberSpellsWriter.file_writers[size].write(pipChanceOfSpell + "\n"); 
                        CrossCheckSelectionTeam2MemberSpellsWriter.file_writers[size].write(countOfSpell + "\n"); 
                        CrossCheckSelectionTeam2MemberSpellsWriter.file_writers[size].write(descriptionOfSpell + "\n"); 
                        CrossCheckSelectionTeam2MemberSpellsWriter.file_writers[size].write("----------------------------\n");
                      } 
                    }
                  } catch (IOException sube1) {
                    System.out.println("Will not reach unless problem reading file.");
                  }
                } 
              }
              else if(checkBox2.isSelected() && !checkBox1.isSelected()) {
                try {
                  System.out.println("Check-box not selected on window-closing."); 
                  writer2.write(line2 + "\n");
                  writerTemp.write(line2 + "\n");
                  writer2.write("----------------------------\n");
                  writerTemp.write("----------------------------\n");
                  writer2.write(nameOfSpell + "\n"); 
                  writerTemp.write(nameOfSpell + "\n");
                  writer2.write(pipsOfSpell + "\n"); 
                  writerTemp.write(pipsOfSpell + "\n");
                  writer2.write(pipChanceOfSpell + "\n"); 
                  writerTemp.write(pipChanceOfSpell + "\n");
                  writer2.write(countOfSpell + "\n"); 
                  writerTemp.write(countOfSpell + "\n");
                  writer2.write(descriptionOfSpell + "\n"); 
                  writerTemp.write(descriptionOfSpell + "\n");
                  writer2.write("----------------------------\n");
                  writerTemp.write("----------------------------\n");
                  writer2.close(); 
                  if(label.equals("t1")) {
                    for(int i = 0; i < size; i++) {
                      CrossCheckDiscardTeam1MemberSpellsWriter.file_writers[size].write(line2 + "\n");
                      CrossCheckDiscardTeam1MemberSpellsWriter.file_writers[size].write("----------------------------\n"); 
                      CrossCheckDiscardTeam1MemberSpellsWriter.file_writers[size].write(nameOfSpell + "\n"); 
                      CrossCheckDiscardTeam1MemberSpellsWriter.file_writers[size].write(pipsOfSpell + "\n"); 
                      CrossCheckDiscardTeam1MemberSpellsWriter.file_writers[size].write(pipChanceOfSpell + "\n"); 
                      CrossCheckDiscardTeam1MemberSpellsWriter.file_writers[size].write(countOfSpell + "\n"); 
                      CrossCheckDiscardTeam1MemberSpellsWriter.file_writers[size].write(descriptionOfSpell + "\n"); 
                      CrossCheckDiscardTeam1MemberSpellsWriter.file_writers[size].write("----------------------------\n");
                    }
                  }
                  else if(label.equals("t2")) {
                    for(int i = 0; i < size; i++) {
                      CrossCheckDiscardTeam2MemberSpellsWriter.file_writers[size].write(line2 + "\n");
                      CrossCheckDiscardTeam2MemberSpellsWriter.file_writers[size].write("----------------------------\n"); 
                      CrossCheckDiscardTeam2MemberSpellsWriter.file_writers[size].write(nameOfSpell + "\n"); 
                      CrossCheckDiscardTeam2MemberSpellsWriter.file_writers[size].write(pipsOfSpell + "\n"); 
                      CrossCheckDiscardTeam2MemberSpellsWriter.file_writers[size].write(pipChanceOfSpell + "\n"); 
                      CrossCheckDiscardTeam2MemberSpellsWriter.file_writers[size].write(countOfSpell + "\n"); 
                      CrossCheckDiscardTeam2MemberSpellsWriter.file_writers[size].write(descriptionOfSpell + "\n"); 
                      CrossCheckDiscardTeam2MemberSpellsWriter.file_writers[size].write("----------------------------\n");
                    }
                  }
                } catch (IOException e2) {
                  try {
                    if(label.equals("t1")) {
                      CrossCheckDiscardSpellsTeam1Writer.setWriterCreated(false);
                      writer2 = CrossCheckDiscardSpellsTeam1Writer.get_file_writer(round); 
                      writer2.write("----------------------------\n");
                      writerTemp.write("----------------------------\n");
                      writer2.write(nameOfSpell + "\n"); 
                      writerTemp.write(nameOfSpell + "\n");
                      writer2.write(pipsOfSpell + "\n"); 
                      writerTemp.write(pipsOfSpell + "\n");
                      writer2.write(pipChanceOfSpell + "\n"); 
                      writerTemp.write(pipChanceOfSpell + "\n");
                      writer2.write(countOfSpell + "\n"); 
                      writerTemp.write(countOfSpell + "\n");
                      writer2.write(descriptionOfSpell + "\n"); 
                      writerTemp.write(descriptionOfSpell + "\n");
                      writer2.write("----------------------------\n");
                      writerTemp.write("----------------------------\n");
                      writer2.close(); 
                      for(int i = 0; i < size; i++) {
                        CrossCheckDiscardTeam1MemberSpellsWriter.file_writers[size].write(line2 + "\n");
                        CrossCheckDiscardTeam1MemberSpellsWriter.file_writers[size].write("----------------------------\n"); 
                        CrossCheckDiscardTeam1MemberSpellsWriter.file_writers[size].write(nameOfSpell + "\n"); 
                        CrossCheckDiscardTeam1MemberSpellsWriter.file_writers[size].write(pipsOfSpell + "\n"); 
                        CrossCheckDiscardTeam1MemberSpellsWriter.file_writers[size].write(pipChanceOfSpell + "\n"); 
                        CrossCheckDiscardTeam1MemberSpellsWriter.file_writers[size].write(countOfSpell + "\n"); 
                        CrossCheckDiscardTeam1MemberSpellsWriter.file_writers[size].write(descriptionOfSpell + "\n"); 
                        CrossCheckDiscardTeam1MemberSpellsWriter.file_writers[size].write("----------------------------\n");
                      }
                    }
                    else if(label.equals("t2")) {
                      CrossCheckDiscardSpellsTeam2Writer.setWriterCreated(false);
                      writer2 = CrossCheckDiscardSpellsTeam2Writer.get_file_writer(round); 
                      writer2.write("----------------------------\n");
                      writerTemp.write("----------------------------\n");
                      writer2.write(nameOfSpell + "\n"); 
                      writerTemp.write(nameOfSpell + "\n"); 
                      writer2.write(pipsOfSpell + "\n"); 
                      writerTemp.write(pipsOfSpell + "\n"); 
                      writer2.write(pipChanceOfSpell + "\n"); 
                      writerTemp.write(pipChanceOfSpell + "\n"); 
                      writer2.write(countOfSpell + "\n"); 
                      writerTemp.write(countOfSpell + "\n");
                      writer2.write(descriptionOfSpell + "\n"); 
                      writerTemp.write(descriptionOfSpell + "\n"); 
                      writer2.write("----------------------------\n");
                      writerTemp.write("----------------------------\n");
                      writer2.close(); 
                      for(int i = 0; i < size; i++) {
                        CrossCheckDiscardTeam2MemberSpellsWriter.file_writers[size].write(line2 + "\n");
                        CrossCheckDiscardTeam2MemberSpellsWriter.file_writers[size].write("----------------------------\n"); 
                        CrossCheckDiscardTeam2MemberSpellsWriter.file_writers[size].write(nameOfSpell + "\n"); 
                        CrossCheckDiscardTeam2MemberSpellsWriter.file_writers[size].write(pipsOfSpell + "\n"); 
                        CrossCheckDiscardTeam2MemberSpellsWriter.file_writers[size].write(pipChanceOfSpell + "\n"); 
                        CrossCheckDiscardTeam2MemberSpellsWriter.file_writers[size].write(countOfSpell + "\n"); 
                        CrossCheckDiscardTeam2MemberSpellsWriter.file_writers[size].write(descriptionOfSpell + "\n"); 
                        CrossCheckDiscardTeam2MemberSpellsWriter.file_writers[size].write("----------------------------\n");
                      }
                    }
                  } catch (IOException sube2) {
                    System.out.println("Will not reach unless problem reading file."); 
                  }
                }
              }
              else if(!checkBox1.isSelected() && !checkBox2.isSelected()) {
                try {
                  System.out.println("No boxes selected on window-closing."); 
                  writer3.write(line3 + "\n");
                  writerTemp.write(line3 + "\n");
                  writer3.write("----------------------------\n"); 
                  writerTemp.write("----------------------------\n");
                  writer3.write(nameOfSpell + "\n"); 
                  writerTemp.write(nameOfSpell + "\n"); 
                  writer3.write(pipsOfSpell + "\n"); 
                  writerTemp.write(pipsOfSpell + "\n");
                  writer3.write(pipChanceOfSpell + "\n"); 
                  writerTemp.write(pipChanceOfSpell + "\n"); 
                  writer3.write(countOfSpell + "\n"); 
                  writerTemp.write(countOfSpell + "\n");
                  writer3.write(descriptionOfSpell + "\n"); 
                  writerTemp.write(descriptionOfSpell + "\n");
                  writer3.write("----------------------------\n");
                  writerTemp.write("----------------------------\n");
                  writer3.close(); 
                  if(label.equals("t1")) {
                    for(int i = 0; i < size; i++) {
                      CrossCheckDiscardTeam1MemberSpellsWriter.file_writers[size].write(line3 + "\n");
                      CrossCheckDiscardTeam1MemberSpellsWriter.file_writers[size].write("----------------------------\n"); 
                      CrossCheckDiscardTeam1MemberSpellsWriter.file_writers[size].write(nameOfSpell + "\n"); 
                      CrossCheckDiscardTeam1MemberSpellsWriter.file_writers[size].write(pipsOfSpell + "\n"); 
                      CrossCheckDiscardTeam1MemberSpellsWriter.file_writers[size].write(pipChanceOfSpell + "\n"); 
                      CrossCheckDiscardTeam1MemberSpellsWriter.file_writers[size].write(countOfSpell + "\n"); 
                      CrossCheckDiscardTeam1MemberSpellsWriter.file_writers[size].write(descriptionOfSpell + "\n"); 
                      CrossCheckDiscardTeam1MemberSpellsWriter.file_writers[size].write("----------------------------\n");
                    }
                  }
                  else if(label.equals("t2")) {
                    for(int i = 0; i < size; i++) {
                      CrossCheckDiscardTeam2MemberSpellsWriter.file_writers[size].write(line3 + "\n");
                      CrossCheckDiscardTeam2MemberSpellsWriter.file_writers[size].write("----------------------------\n"); 
                      CrossCheckDiscardTeam2MemberSpellsWriter.file_writers[size].write(nameOfSpell + "\n"); 
                      CrossCheckDiscardTeam2MemberSpellsWriter.file_writers[size].write(pipsOfSpell + "\n"); 
                      CrossCheckDiscardTeam2MemberSpellsWriter.file_writers[size].write(pipChanceOfSpell + "\n"); 
                      CrossCheckDiscardTeam2MemberSpellsWriter.file_writers[size].write(countOfSpell + "\n"); 
                      CrossCheckDiscardTeam2MemberSpellsWriter.file_writers[size].write(descriptionOfSpell + "\n"); 
                      CrossCheckDiscardTeam2MemberSpellsWriter.file_writers[size].write("----------------------------\n");
                    }
                  }
                } catch (IOException e3) {
                  try {
                    if(label.equals("t1")) {
                      CrossCheckLeftOverSpellsTeam1Writer.setWriterCreated(false);
                      writer3 = CrossCheckLeftOverSpellsTeam1Writer.get_file_writer(round); 
                      writer3.write("----------------------------\n"); 
                      writerTemp.write("----------------------------\n"); 
                      writer3.write(nameOfSpell + "\n"); 
                      writerTemp.write(nameOfSpell + "\n"); 
                      writer3.write(pipsOfSpell + "\n"); 
                      writerTemp.write(pipsOfSpell + "\n"); 
                      writer3.write(pipChanceOfSpell + "\n"); 
                      writerTemp.write(pipChanceOfSpell + "\n");
                      writer3.write(countOfSpell + "\n"); 
                      writerTemp.write(countOfSpell + "\n");
                      writer3.write(descriptionOfSpell + "\n"); 
                      writerTemp.write(descriptionOfSpell + "\n");
                      writer3.write("----------------------------\n");
                      writerTemp.write("----------------------------\n");
                      writer3.close(); 
                      for(int i = 0; i < size; i++) {
                        CrossCheckLeftOverTeam1MemberSpellsWriter.file_writers[size].write(line3 + "\n");
                        CrossCheckLeftOverTeam1MemberSpellsWriter.file_writers[size].write("----------------------------\n"); 
                        CrossCheckLeftOverTeam1MemberSpellsWriter.file_writers[size].write(nameOfSpell + "\n"); 
                        CrossCheckLeftOverTeam1MemberSpellsWriter.file_writers[size].write(pipsOfSpell + "\n"); 
                        CrossCheckLeftOverTeam1MemberSpellsWriter.file_writers[size].write(pipChanceOfSpell + "\n"); 
                        CrossCheckLeftOverTeam1MemberSpellsWriter.file_writers[size].write(countOfSpell + "\n"); 
                        CrossCheckLeftOverTeam1MemberSpellsWriter.file_writers[size].write(descriptionOfSpell + "\n"); 
                        CrossCheckLeftOverTeam1MemberSpellsWriter.file_writers[size].write("----------------------------\n");
                      }
                    }
                    else if(label.equals("t2")) {
                      CrossCheckLeftOverSpellsTeam2Writer.setWriterCreated(false);
                      writer3 = CrossCheckLeftOverSpellsTeam2Writer.get_file_writer(round); 
                      writer3.write("----------------------------\n"); 
                      writerTemp.write("----------------------------\n");
                      writer3.write(nameOfSpell + "\n"); 
                      writerTemp.write(nameOfSpell + "\n"); 
                      writer3.write(pipsOfSpell + "\n"); 
                      writerTemp.write(pipsOfSpell + "\n");
                      writer3.write(pipChanceOfSpell + "\n"); 
                      writerTemp.write(pipChanceOfSpell + "\n");
                      writer3.write(countOfSpell + "\n"); 
                      writerTemp.write(countOfSpell + "\n"); 
                      writer3.write(descriptionOfSpell + "\n"); 
                      writerTemp.write(descriptionOfSpell + "\n");
                      writer3.write("----------------------------\n");
                      writerTemp.write("----------------------------\n");
                      writer3.close(); 
                      for(int i = 0; i < size; i++) {
                        CrossCheckLeftOverTeam2MemberSpellsWriter.file_writers[size].write(line3 + "\n");
                        CrossCheckLeftOverTeam2MemberSpellsWriter.file_writers[size].write("----------------------------\n"); 
                        CrossCheckLeftOverTeam2MemberSpellsWriter.file_writers[size].write(nameOfSpell + "\n"); 
                        CrossCheckLeftOverTeam2MemberSpellsWriter.file_writers[size].write(pipsOfSpell + "\n"); 
                        CrossCheckLeftOverTeam2MemberSpellsWriter.file_writers[size].write(pipChanceOfSpell + "\n"); 
                        CrossCheckLeftOverTeam2MemberSpellsWriter.file_writers[size].write(countOfSpell + "\n"); 
                        CrossCheckLeftOverTeam2MemberSpellsWriter.file_writers[size].write(descriptionOfSpell + "\n"); 
                        CrossCheckLeftOverTeam2MemberSpellsWriter.file_writers[size].write("----------------------------\n");
                      }
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
    else if(reader.readLine().equals("card-by-card")) {
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
