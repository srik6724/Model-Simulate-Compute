package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModulePrRulesTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];  

  ModulePrRulesTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_pyreason_rules.getFileWriter(team, memberNo, round); 
      ModulePrRulesTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModulePrRulesTeam2MemberWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new ModulePrRulesTeam2MemberWriter("t2", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    ModulePrRulesTeam2MemberWriter.writerCreated = var; 
  }
}
