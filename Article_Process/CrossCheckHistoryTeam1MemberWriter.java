package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckHistoryTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckHistoryTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Documentation.getFileWriter(team, memberNo, round); 
      CrossCheckHistoryTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckHistoryTeam1MemberWriter.writerCreated == false) {
      new CrossCheckHistoryTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckHistoryTeam1MemberWriter.writerCreated = var; 
  }
}
