package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundPrFactsTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];  

  RoundPrFactsTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_pyreason_facts.getFileWriter(team, memberNo, round); 
      RoundPrFactsTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundPrFactsTeam1MemberWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new RoundTeam1MemberSpellsWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    RoundPrFactsTeam1MemberWriter.writerCreated = var; 
  }
}
