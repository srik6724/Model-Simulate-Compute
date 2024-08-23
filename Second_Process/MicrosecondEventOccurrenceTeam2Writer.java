package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondEventOccurrenceTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondEventOccurrenceTeam2Writer(int round, String team) {
    try {
      file_writer = Microsecond_Timestamp.getFileWriter(team, round); 
      MicrosecondEventOccurrenceTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int module) {
    if(MicrosecondEventOccurrenceTeam2Writer.writerCreated == false) {
      System.out.println("Calling module_event_occurrence constructor.");
      new MicrosecondEventOccurrenceTeam2Writer(module, "t2");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondEventOccurrenceTeam2Writer.writerCreated = var; 
  }
}
