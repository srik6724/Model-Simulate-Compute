package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleTraceToStartTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  

  ModuleTraceToStartTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Backtrack.getFileWriter(team, memberNo, round); 
      ModuleTraceToStartTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleTraceToStartTeam2MemberWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new ModuleTraceToStartTeam2MemberWriter("t2", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleTraceToStartTeam2MemberWriter.writerCreated = var; 
  }
}
