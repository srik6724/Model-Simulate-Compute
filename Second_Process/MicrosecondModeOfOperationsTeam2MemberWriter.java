package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondModeOfOperationsTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondModeOfOperationsTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Hierarchy.getFileWriter(team, memberNo, round); 
      MicrosecondModeOfOperationsTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondModeOfOperationsTeam2MemberWriter.writerCreated == false) {
      new MicrosecondModeOfOperationsTeam1MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondModeOfOperationsTeam2MemberWriter.writerCreated = var; 
  }
}
