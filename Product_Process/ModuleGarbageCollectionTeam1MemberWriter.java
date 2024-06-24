package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleGarbageCollectionTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleGarbageCollectionTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Garbage_Collector.getFileWriter(team, memberNo, round); 
      ModuleGarbageCollectionTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleGarbageCollectionTeam1MemberWriter.writerCreated == false) {
      System.out.println("Calling round_garbage_collection constructor.");
      new ModuleGarbageCollectionTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleGarbageCollectionTeam1MemberWriter.writerCreated = var; 
  }
}
