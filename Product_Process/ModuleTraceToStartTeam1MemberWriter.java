package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleTraceToStartTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  

  ModuleTraceToStartTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Backtrack.getFileWriter(team, memberNo, round); 
      ModuleTraceToStartTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleTraceToStartTeam1MemberWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new ModuleTraceToStartTeam1MemberWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleTraceToStartTeam1MemberWriter.writerCreated = var; 
  }
}
