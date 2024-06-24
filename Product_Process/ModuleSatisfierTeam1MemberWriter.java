package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleSatisfierTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleSatisfierTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Solution.getFileWriter(team, memberNo, round); 
      ModuleSatisfierTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleSatisfierTeam1MemberWriter.writerCreated == true) {
      System.out.println("Calling round_satisfier constructor"); 
      new ModuleSatisfierTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleSatisfierTeam1MemberWriter.writerCreated = true; 
  }
}
