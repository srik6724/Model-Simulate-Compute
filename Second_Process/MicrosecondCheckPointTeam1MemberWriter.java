package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondCheckPointTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondCheckPointTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_State.getFileWriter(team, memberNo, round); 
      MicrosecondCheckPointTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondCheckPointTeam1MemberWriter.writerCreated == false) {
      new MicrosecondCheckPointTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondCheckPointTeam1MemberWriter.writerCreated = var; 
  }
}
