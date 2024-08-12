package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondHistoryTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondHistoryTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Documentation.getFileWriter(team, memberNo, round); 
      NanosecondHistoryTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondHistoryTeam1MemberWriter.writerCreated == false) {
      new NanosecondHistoryTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondHistoryTeam1MemberWriter.writerCreated = var; 
  }
}
