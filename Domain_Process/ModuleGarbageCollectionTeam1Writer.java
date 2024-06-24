package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleGarbageCollectionTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleGarbageCollectionTeam1Writer(int round, String team) {
    try {
      file_writer = Module_Garbage_Collector.getFileWriter(team, round);
      ModuleGarbageCollectionTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleGarbageCollectionTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_garbage_collection constructor.");
      new ModuleGarbageCollectionTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleGarbageCollectionTeam1Writer.writerCreated = var;
  }
}
