package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondEventOccurrenceTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondEventOccurrenceTeam1Writer(int round, String team) {
    try {
      file_writer = Microsecond_Timestamp.getFileWriter(team, round); 
      MicrosecondEventOccurrenceTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int module) {
    if(MicrosecondEventOccurrenceTeam1Writer.writerCreated == false) {
      System.out.println("Calling module_event_occurrence constructor.");
      new MicrosecondEventOccurrenceTeam1Writer(module, "t1");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondEventOccurrenceTeam1Writer.writerCreated = var; 
  }
}
