package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondPathTraceTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondPathTraceTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Transducer.getFileWriter(team, memberNo, round); 
      MicrosecondPathTraceTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondPathTraceTeam1MemberWriter.writerCreated == false) {
      new MicrosecondPathTraceTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondPathTraceTeam1MemberWriter.writerCreated = var; 
  }
}
