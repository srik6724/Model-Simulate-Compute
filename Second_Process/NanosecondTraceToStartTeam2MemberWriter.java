package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondTraceToStartTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  

  NanosecondTraceToStartTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Backtrack.getFileWriter(team, memberNo, round); 
      NanosecondTraceToStartTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondTraceToStartTeam2MemberWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new NanosecondTraceToStartTeam2MemberWriter("t2", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondTraceToStartTeam2MemberWriter.writerCreated = var; 
  }
}
