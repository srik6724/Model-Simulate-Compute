package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckLoggerTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckLoggerTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Logger.getFileWriter(team, memberNo, round); 
      CrossCheckLoggerTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckLoggerTeam1MemberWriter.writerCreated == false) {
      new CrossCheckLoggerTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckLoggerTeam1MemberWriter.writerCreated = var; 
  }
}
