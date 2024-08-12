package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondTraceToStartTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  

  NanosecondTraceToStartTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Backtrack.getFileWriter(team, memberNo, round); 
      NanosecondTraceToStartTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondTraceToStartTeam1MemberWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new NanosecondTraceToStartTeam1MemberWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondTraceToStartTeam1MemberWriter.writerCreated = var; 
  }
}
