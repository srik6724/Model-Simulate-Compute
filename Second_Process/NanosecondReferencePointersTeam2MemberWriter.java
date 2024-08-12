package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondReferencePointersTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondReferencePointersTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Simulation.getFileWriter(team, memberNo, round); 
      NanosecondReferencePointersTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondReferencePointersTeam2MemberWriter.writerCreated == false) {
      new NanosecondReferencePointersTeam1MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondReferencePointersTeam2MemberWriter.writerCreated = var; 
  }
}
