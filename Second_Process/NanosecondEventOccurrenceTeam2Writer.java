package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondEventOccurrenceTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondEventOccurrenceTeam2Writer(int round, String team) {
    try {
      file_writer = Nanosecond_Timestamp.getFileWriter(team, round); 
      NanosecondEventOccurrenceTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int module) {
    if(NanosecondEventOccurrenceTeam2Writer.writerCreated == false) {
      System.out.println("Calling module_event_occurrence constructor.");
      new NanosecondEventOccurrenceTeam2Writer(module, "t2");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondEventOccurrenceTeam2Writer.writerCreated = var; 
  }
}
