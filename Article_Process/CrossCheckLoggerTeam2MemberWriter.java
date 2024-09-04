package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckLoggerTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckLoggerTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Logger.getFileWriter(team, memberNo, round); 
      CrossCheckLoggerTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckLoggerTeam2MemberWriter.writerCreated == false) {
      new CrossCheckLoggerTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckLoggerTeam2MemberWriter.writerCreated = var; 
  }
}
