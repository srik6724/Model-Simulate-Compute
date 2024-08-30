package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckPrFactsTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];  

  CrossCheckPrFactsTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_pyreason_facts.getFileWriter(team, memberNo, round); 
      CrossCheckPrFactsTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckPrFactsTeam1MemberWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new CrossCheckTeam1MemberSpellsWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckPrFactsTeam1MemberWriter.writerCreated = var; 
  }
}
