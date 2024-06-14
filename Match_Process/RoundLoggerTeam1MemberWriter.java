package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundLoggerTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundLoggerTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Logger.getFileWriter(team, memberNo, round); 
      RoundLoggerTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundLoggerTeam1MemberWriter.writerCreated == false) {
      new RoundLoggerTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundLoggerTeam1MemberWriter.writerCreated = var; 
  }
}
