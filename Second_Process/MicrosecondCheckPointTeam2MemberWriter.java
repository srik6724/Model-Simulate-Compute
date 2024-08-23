package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondCheckPointTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondCheckPointTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_State.getFileWriter(team, memberNo, round); 
      MicrosecondCheckPointTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondCheckPointTeam2MemberWriter.writerCreated == false) {
      new MicrosecondCheckPointTeam1MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondCheckPointTeam2MemberWriter.writerCreated = var; 
  }
}
