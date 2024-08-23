package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondPathTraceTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondPathTraceTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Transducer.getFileWriter(team, memberNo, round); 
      MicrosecondPathTraceTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondPathTraceTeam2MemberWriter.writerCreated == false) {
      new MicrosecondPathTraceTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondPathTraceTeam2MemberWriter.writerCreated = var; 
  }
}
