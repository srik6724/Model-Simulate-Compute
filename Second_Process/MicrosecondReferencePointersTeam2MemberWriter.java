package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondReferencePointersTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondReferencePointersTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Simulation.getFileWriter(team, memberNo, round); 
      MicrosecondReferencePointersTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondReferencePointersTeam2MemberWriter.writerCreated == false) {
      new MicrosecondReferencePointersTeam1MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondReferencePointersTeam2MemberWriter.writerCreated = var; 
  }
}
