package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckTacticalApproachTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckTacticalApproachTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Strategy.getFileWriter(team, memberNo, round);
      CrossCheckTacticalApproachTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckTacticalApproachTeam2MemberWriter.writerCreated == false) {
      new CrossCheckTacticalApproachTeam2MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckTacticalApproachTeam2MemberWriter.writerCreated = var; 
  }
}
