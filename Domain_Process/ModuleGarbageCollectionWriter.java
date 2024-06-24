package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleGarbageCollectionWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleGarbageCollectionWriter(int round, String team) {
    try {
      file_writer = Module_Garbage_Collector.getFileWriter(team, round); 
      ModuleGarbageCollectionWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleGarbageCollectionWriter.writerCreated == false) {
      System.out.println("Calling round_garbage_collection constructor.");
      new ModuleGarbageCollectionWriter(round, "default");
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    ModuleGarbageCollectionWriter.writerCreated = var; 
  }
}
