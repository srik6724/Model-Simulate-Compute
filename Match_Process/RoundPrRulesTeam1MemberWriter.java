package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundPrRulesTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];  

  RoundPrRulesTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_pyreason_rules.getFileWriter(team, memberNo, round); 
      RoundPrRulesTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundPrRulesTeam1MemberWriter.writerCreated == false) {
      System.out.println("Calling round_pr_rules constructor"); 
      new RoundTeam1MemberSpellsWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    RoundPrRulesTeam1MemberWriter.writerCreated = var; 
  }
}
