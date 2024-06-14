package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundTacticalApproachTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundTacticalApproachTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Strategy.getFileWriter(team, memberNo, round);
      RoundTacticalApproachTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundTacticalApproachTeam2MemberWriter.writerCreated == false) {
      new RoundTacticalApproachTeam2MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundTacticalApproachTeam2MemberWriter.writerCreated = var; 
  }
}
