package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondHistoryTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondHistoryTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Documentation.getFileWriter(team, memberNo, round); 
      MicrosecondHistoryTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondHistoryTeam2MemberWriter.writerCreated == false) {
      new MicrosecondHistoryTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondHistoryTeam2MemberWriter.writerCreated = var; 
  }
}
