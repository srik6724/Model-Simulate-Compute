package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckEventOccurrenceWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckEventOccurrenceWriter(int round, String team) {
    try {
      file_writer = Cross_Check_Timestamp.getFileWriter(team, round); 
      CrossCheckEventOccurrenceWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int module) {
    if(CrossCheckEventOccurrenceWriter.writerCreated == false) {
      System.out.println("Calling module_event_occurrence constructor.");
      new CrossCheckEventOccurrenceWriter(module, "default");
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    CrossCheckEventOccurrenceWriter.writerCreated = var; 
  }
}
