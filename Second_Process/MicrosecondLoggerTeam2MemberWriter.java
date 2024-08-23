package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondLoggerTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondLoggerTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Logger.getFileWriter(team, memberNo, round); 
      MicrosecondLoggerTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondLoggerTeam2MemberWriter.writerCreated == false) {
      new MicrosecondLoggerTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondLoggerTeam2MemberWriter.writerCreated = var; 
  }
}
