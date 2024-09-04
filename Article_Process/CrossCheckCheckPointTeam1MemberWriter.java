package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckCheckPointTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckCheckPointTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_State.getFileWriter(team, memberNo, round); 
      CrossCheckCheckPointTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckCheckPointTeam1MemberWriter.writerCreated == false) {
      new CrossCheckCheckPointTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckCheckPointTeam1MemberWriter.writerCreated = var; 
  }
}
