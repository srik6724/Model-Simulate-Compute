package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleEventOccurrenceTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleEventOccurrenceTeam1Writer(int round, String team) {
    try {
      file_writer = Module_Timestamp.getFileWriter(team, round); 
      ModuleEventOccurrenceTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int module) {
    if(ModuleEventOccurrenceTeam1Writer.writerCreated == false) {
      System.out.println("Calling module_event_occurrence constructor.");
      new ModuleEventOccurrenceTeam1Writer(module, "t1");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleEventOccurrenceTeam1Writer.writerCreated = var; 
  }
}
