package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundPrRulesTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];  

  RoundPrRulesTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_pyreason_rules.getFileWriter(team, memberNo, round); 
      RoundPrRulesTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundPrRulesTeam2MemberWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new RoundPrRulesTeam2MemberWriter("t2", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    RoundPrRulesTeam2MemberWriter.writerCreated = var; 
  }
}