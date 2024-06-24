package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleGarbageCollectionTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleGarbageCollectionTeam2Writer(int round, String team) {
    try {
      file_writer = Module_Garbage_Collector.getFileWriter(team, round);
      ModuleGarbageCollectionTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleGarbageCollectionTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_garbage_collection constructor.");
      new ModuleGarbageCollectionTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleGarbageCollectionTeam2Writer.writerCreated = var;
  }
}
