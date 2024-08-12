package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondModeOfOperationsTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondModeOfOperationsTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Hierarchy.getFileWriter(team, memberNo, round); 
      NanosecondModeOfOperationsTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondModeOfOperationsTeam2MemberWriter.writerCreated == false) {
      new NanosecondModeOfOperationsTeam1MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondModeOfOperationsTeam2MemberWriter.writerCreated = var; 
  }
}
