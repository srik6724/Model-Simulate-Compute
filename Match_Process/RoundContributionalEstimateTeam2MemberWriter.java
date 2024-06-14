package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundContributionalEstimateTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundContributionalEstimateTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_State.getFileWriter(team, memberNo, round); 
      RoundContributionalEstimateTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundContributionalEstimateTeam2MemberWriter.writerCreated == false) {
      new RoundContributionalEstimateTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundContributionalEstimateTeam2MemberWriter.writerCreated = var; 
  }
}
