package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondCheckPointTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondCheckPointTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_State.getFileWriter(team, memberNo, round); 
      NanosecondCheckPointTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondCheckPointTeam1MemberWriter.writerCreated == false) {
      new NanosecondCheckPointTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondCheckPointTeam1MemberWriter.writerCreated = var; 
  }
}
