package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckEventOccurrenceTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckEventOccurrenceTeam1Writer(int round, String team) {
    try {
      file_writer = Cross_Check_Timestamp.getFileWriter(team, round); 
      CrossCheckEventOccurrenceTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int module) {
    if(CrossCheckEventOccurrenceTeam1Writer.writerCreated == false) {
      System.out.println("Calling module_event_occurrence constructor.");
      new CrossCheckEventOccurrenceTeam1Writer(module, "t1");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckEventOccurrenceTeam1Writer.writerCreated = var; 
  }
}
