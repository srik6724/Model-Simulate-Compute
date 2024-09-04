package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckHistoryTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckHistoryTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Documentation.getFileWriter(team, memberNo, round); 
      CrossCheckHistoryTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckHistoryTeam2MemberWriter.writerCreated == false) {
      new CrossCheckHistoryTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckHistoryTeam2MemberWriter.writerCreated = var; 
  }
}
