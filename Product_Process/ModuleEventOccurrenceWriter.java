package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleEventOccurrenceWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleEventOccurrenceWriter(int round, String team) {
    try {
      file_writer = Module_Timestamp.getFileWriter(team, round); 
      ModuleEventOccurrenceWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int module) {
    if(ModuleEventOccurrenceWriter.writerCreated == false) {
      System.out.println("Calling module_event_occurrence constructor.");
      new ModuleEventOccurrenceWriter(module, "default");
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    ModuleEventOccurrenceWriter.writerCreated = var; 
  }
}
