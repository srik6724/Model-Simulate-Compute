package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckLeftOverTeam1MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckLeftOverTeam1MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Remaining.getFileWriter(team, memberNo, round); 
      CrossCheckLeftOverTeam1MemberSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckLeftOverTeam1MemberSpellsWriter.writerCreated == false) {
      new CrossCheckLeftOverTeam1MemberSpellsWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckLeftOverTeam1MemberSpellsWriter.writerCreated = var; 
  }
}
