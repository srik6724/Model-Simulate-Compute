package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondCompletionTimeTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondCompletionTimeTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Duration.getFileWriter(team, memberNo, round); 
      MicrosecondCompletionTimeTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondCompletionTimeTeam1MemberWriter.writerCreated == false) {
      new MicrosecondCompletionTimeTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondCompletionTimeTeam1MemberWriter.writerCreated = var; 
  }
}
