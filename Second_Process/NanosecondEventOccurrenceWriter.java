package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondEventOccurrenceWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondEventOccurrenceWriter(int round, String team) {
    try {
      file_writer = Nanosecond_Timestamp.getFileWriter(team, round); 
      NanosecondEventOccurrenceWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int module) {
    if(NanosecondEventOccurrenceWriter.writerCreated == false) {
      System.out.println("Calling module_event_occurrence constructor.");
      new NanosecondEventOccurrenceWriter(module, "default");
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    NanosecondEventOccurrenceWriter.writerCreated = var; 
  }
}
