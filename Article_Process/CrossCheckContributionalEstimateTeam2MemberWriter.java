package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckContributionalEstimateTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckContributionalEstimateTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_State.getFileWriter(team, memberNo, round); 
      CrossCheckContributionalEstimateTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckContributionalEstimateTeam2MemberWriter.writerCreated == false) {
      new CrossCheckContributionalEstimateTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckContributionalEstimateTeam2MemberWriter.writerCreated = var; 
  }
}
