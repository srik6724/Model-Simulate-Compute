package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundLoggerTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundLoggerTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Logger.getFileWriter(team, memberNo, round); 
      RoundLoggerTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundLoggerTeam2MemberWriter.writerCreated == false) {
      new RoundLoggerTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundLoggerTeam2MemberWriter.writerCreated = var; 
  }
}
