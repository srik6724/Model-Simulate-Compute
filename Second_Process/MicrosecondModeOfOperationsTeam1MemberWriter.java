package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondModeOfOperationsTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondModeOfOperationsTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Hierarchy.getFileWriter(team, memberNo, round); 
      MicrosecondModeOfOperationsTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondModeOfOperationsTeam1MemberWriter.writerCreated == false) {
      new MicrosecondModeOfOperationsTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondModeOfOperationsTeam1MemberWriter.writerCreated = var; 
  }
}
