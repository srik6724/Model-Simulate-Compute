package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckContributionalEstimateTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckContributionalEstimateTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_State.getFileWriter(team, memberNo, round); 
      CrossCheckContributionalEstimateTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckContributionalEstimateTeam1MemberWriter.writerCreated == false) {
      new CrossCheckContributionalEstimateTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckContributionalEstimateTeam1MemberWriter.writerCreated = var; 
  }
}
