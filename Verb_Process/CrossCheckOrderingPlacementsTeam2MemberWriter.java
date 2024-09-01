package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckOrderingPlacementsTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckOrderingPlacementsTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Permutations.getFileWriter(team, memberNo, round); 
      CrossCheckOrderingPlacementsTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckOrderingPlacementsTeam2MemberWriter.writerCreated == false) {
      new CrossCheckOrderingPlacementsTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckOrderingPlacementsTeam2MemberWriter.writerCreated = var; 
  }
}
