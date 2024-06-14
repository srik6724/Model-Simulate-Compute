package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundHistoryTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundHistoryTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Documentation.getFileWriter(team, memberNo, round); 
      RoundHistoryTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundHistoryTeam1MemberWriter.writerCreated == false) {
      new RoundHistoryTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundHistoryTeam1MemberWriter.writerCreated = var; 
  }
}
