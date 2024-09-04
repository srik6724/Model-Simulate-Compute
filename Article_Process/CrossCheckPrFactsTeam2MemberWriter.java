package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckPrFactsTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];  

  CrossCheckPrFactsTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_pyreason_facts.getFileWriter(team, memberNo, round); 
      CrossCheckPrFactsTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckPrFactsTeam2MemberWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new CrossCheckPrFactsTeam2MemberWriter("t2", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckPrFactsTeam2MemberWriter.writerCreated = var; 
  }
}
