package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondPathTraceTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondPathTraceTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Transducer.getFileWriter(team, memberNo, round); 
      NanosecondPathTraceTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondPathTraceTeam1MemberWriter.writerCreated == false) {
      new NanosecondPathTraceTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondPathTraceTeam1MemberWriter.writerCreated = var; 
  }
}
