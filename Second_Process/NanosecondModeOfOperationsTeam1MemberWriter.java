package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondModeOfOperationsTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondModeOfOperationsTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Hierarchy.getFileWriter(team, memberNo, round); 
      NanosecondModeOfOperationsTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondModeOfOperationsTeam1MemberWriter.writerCreated == false) {
      new NanosecondModeOfOperationsTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondModeOfOperationsTeam1MemberWriter.writerCreated = var; 
  }
}
