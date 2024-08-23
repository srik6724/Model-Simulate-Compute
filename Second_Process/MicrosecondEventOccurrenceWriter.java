package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondEventOccurrenceWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondEventOccurrenceWriter(int round, String team) {
    try {
      file_writer = Microsecond_Timestamp.getFileWriter(team, round); 
      MicrosecondEventOccurrenceWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int module) {
    if(MicrosecondEventOccurrenceWriter.writerCreated == false) {
      System.out.println("Calling module_event_occurrence constructor.");
      new MicrosecondEventOccurrenceWriter(module, "default");
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    MicrosecondEventOccurrenceWriter.writerCreated = var; 
  }
}
