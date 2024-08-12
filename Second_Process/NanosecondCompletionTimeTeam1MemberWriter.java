package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondCompletionTimeTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondCompletionTimeTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Duration.getFileWriter(team, memberNo, round); 
      NanosecondCompletionTimeTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondCompletionTimeTeam1MemberWriter.writerCreated == false) {
      new NanosecondCompletionTimeTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondCompletionTimeTeam1MemberWriter.writerCreated = var; 
  }
}
