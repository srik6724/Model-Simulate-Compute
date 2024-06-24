package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModulePrFactsTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];  

  ModulePrFactsTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_pyreason_facts.getFileWriter(team, memberNo, round); 
      ModulePrFactsTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModulePrFactsTeam2MemberWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new ModulePrFactsTeam2MemberWriter("t2", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    ModulePrFactsTeam2MemberWriter.writerCreated = var; 
  }
}
