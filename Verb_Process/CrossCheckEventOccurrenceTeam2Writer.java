package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckEventOccurrenceTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckEventOccurrenceTeam2Writer(int round, String team) {
    try {
      file_writer = Cross_Check_Timestamp.getFileWriter(team, round); 
      CrossCheckEventOccurrenceTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int module) {
    if(CrossCheckEventOccurrenceTeam2Writer.writerCreated == false) {
      System.out.println("Calling module_event_occurrence constructor.");
      new CrossCheckEventOccurrenceTeam2Writer(module, "t2");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckEventOccurrenceTeam2Writer.writerCreated = var; 
  }
}
