package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleRunTimeTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleRunTimeTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Process.getFileWriter(team, memberNo, round); 
      ModuleRunTimeTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleRunTimeTeam2MemberWriter.writerCreated == true) {
      System.out.println("Calling round_run_time constructor"); 
      new ModuleRunTimeTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleRunTimeTeam2MemberWriter.writerCreated = true; 
  }
}
