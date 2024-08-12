package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondPathTraceTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondPathTraceTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Transducer.getFileWriter(team, memberNo, round); 
      NanosecondPathTraceTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondPathTraceTeam2MemberWriter.writerCreated == false) {
      new NanosecondPathTraceTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondPathTraceTeam2MemberWriter.writerCreated = var; 
  }
}
