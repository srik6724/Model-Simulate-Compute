package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondCompletionTimeTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondCompletionTimeTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Duration.getFileWriter(team, memberNo, round); 
      MicrosecondCompletionTimeTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondCompletionTimeTeam2MemberWriter.writerCreated == false) {
      new MicrosecondCompletionTimeTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondCompletionTimeTeam2MemberWriter.writerCreated = var; 
  }
}
