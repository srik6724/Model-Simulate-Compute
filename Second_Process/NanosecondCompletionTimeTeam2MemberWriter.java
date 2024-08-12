package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondCompletionTimeTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondCompletionTimeTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Duration.getFileWriter(team, memberNo, round); 
      NanosecondCompletionTimeTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondCompletionTimeTeam2MemberWriter.writerCreated == false) {
      new NanosecondCompletionTimeTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondCompletionTimeTeam2MemberWriter.writerCreated = var; 
  }
}
