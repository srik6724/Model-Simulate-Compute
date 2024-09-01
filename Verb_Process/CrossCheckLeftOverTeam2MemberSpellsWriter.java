package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckLeftOverTeam2MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckLeftOverTeam2MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Remaining.getFileWriter(team, memberNo, round); 
      CrossCheckLeftOverTeam2MemberSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckLeftOverTeam2MemberSpellsWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor."); 
      new CrossCheckLeftOverTeam2MemberSpellsWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckLeftOverTeam2MemberSpellsWriter.writerCreated = var; 
  }
}
