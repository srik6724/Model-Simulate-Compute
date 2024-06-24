package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModulePrFactsTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];  

  ModulePrFactsTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_pyreason_facts.getFileWriter(team, memberNo, round); 
      ModulePrFactsTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModulePrFactsTeam1MemberWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new ModuleTeam1MemberSpellsWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    ModulePrFactsTeam1MemberWriter.writerCreated = var; 
  }
}
