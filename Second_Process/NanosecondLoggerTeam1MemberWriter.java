package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondLoggerTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondLoggerTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Logger.getFileWriter(team, memberNo, round); 
      NanosecondLoggerTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondLoggerTeam1MemberWriter.writerCreated == false) {
      new NanosecondLoggerTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondLoggerTeam1MemberWriter.writerCreated = var; 
  }
}
