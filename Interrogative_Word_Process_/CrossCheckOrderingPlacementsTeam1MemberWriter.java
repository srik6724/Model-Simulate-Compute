package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckOrderingPlacementsTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckOrderingPlacementsTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Permutations.getFileWriter(team, memberNo, round); 
      CrossCheckOrderingPlacementsTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckOrderingPlacementsTeam1MemberWriter.writerCreated == false) {
      new CrossCheckLeftOverTeam1MemberSpellsWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckOrderingPlacementsTeam1MemberWriter.writerCreated = var; 
  }
}
