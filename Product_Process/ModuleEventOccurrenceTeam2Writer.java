package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleEventOccurrenceTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleEventOccurrenceTeam2Writer(int round, String team) {
    try {
      file_writer = Module_Timestamp.getFileWriter(team, round); 
      ModuleEventOccurrenceTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int module) {
    if(ModuleEventOccurrenceTeam2Writer.writerCreated == false) {
      System.out.println("Calling module_event_occurrence constructor.");
      new ModuleEventOccurrenceTeam2Writer(module, "t2");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleEventOccurrenceTeam2Writer.writerCreated = var; 
  }
}
