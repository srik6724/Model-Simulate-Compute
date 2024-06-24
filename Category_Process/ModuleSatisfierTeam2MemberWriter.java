package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleSatisfierTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleSatisfierTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Solution.getFileWriter(team, memberNo, round); 
      ModuleSatisfierTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleSatisfierTeam2MemberWriter.writerCreated == true) {
      System.out.println("Calling round_satisfier constructor"); 
      new ModuleSatisfierTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleSatisfierTeam2MemberWriter.writerCreated = true; 
  }
}
