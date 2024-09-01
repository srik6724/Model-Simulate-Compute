package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckTacticalApproachTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckTacticalApproachTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Strategy.getFileWriter(team, memberNo, round);
      CrossCheckTacticalApproachTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckTacticalApproachTeam1MemberWriter.writerCreated == false) {
      new CrossCheckTacticalApproachTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckTacticalApproachTeam1MemberWriter.writerCreated = var; 
  }
}
