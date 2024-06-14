package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundHistoryTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundHistoryTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Documentation.getFileWriter(team, memberNo, round); 
      RoundHistoryTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundHistoryTeam2MemberWriter.writerCreated == false) {
      new RoundHistoryTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundHistoryTeam2MemberWriter.writerCreated = var; 
  }
}
