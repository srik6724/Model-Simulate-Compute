package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondTraceToStartTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  

  MicrosecondTraceToStartTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Backtrack.getFileWriter(team, memberNo, round); 
      MicrosecondTraceToStartTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondTraceToStartTeam1MemberWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new MicrosecondTraceToStartTeam1MemberWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondTraceToStartTeam1MemberWriter.writerCreated = var; 
  }
}
