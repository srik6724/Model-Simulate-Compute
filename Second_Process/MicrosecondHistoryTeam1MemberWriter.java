package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondHistoryTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondHistoryTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Documentation.getFileWriter(team, memberNo, round); 
      MicrosecondHistoryTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondHistoryTeam1MemberWriter.writerCreated == false) {
      new MicrosecondHistoryTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondHistoryTeam1MemberWriter.writerCreated = var; 
  }
}
