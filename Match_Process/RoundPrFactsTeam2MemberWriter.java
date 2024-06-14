package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundPrFactsTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];  

  RoundPrFactsTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_pyreason_facts.getFileWriter(team, memberNo, round); 
      RoundPrFactsTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundPrFactsTeam2MemberWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new RoundPrFactsTeam2MemberWriter("t2", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    RoundPrFactsTeam2MemberWriter.writerCreated = var; 
  }
}
