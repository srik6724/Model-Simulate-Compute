package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundCheckPointTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundCheckPointTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_State.getFileWriter(team, memberNo, round); 
      RoundCheckPointTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundCheckPointTeam1MemberWriter.writerCreated == false) {
      new RoundCheckPointTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundCheckPointTeam1MemberWriter.writerCreated = var; 
  }
}
