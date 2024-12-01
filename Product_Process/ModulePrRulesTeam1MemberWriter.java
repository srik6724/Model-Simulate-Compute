package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModulePrRulesTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];  

  ModulePrRulesTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_pyreason_rules.getFileWriter(team, memberNo, round); 
      ModulePrRulesTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModulePrRulesTeam1MemberWriter.writerCreated == false) {
      System.out.println("Calling round_pr_rules constructor"); 
      new ModuleTeam1MemberSpellsWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    ModulePrRulesTeam1MemberWriter.writerCreated = var; 
  }
}
