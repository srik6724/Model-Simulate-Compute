package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckTraceToStartTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  

  CrossCheckTraceToStartTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Backtrack.getFileWriter(team, memberNo, round); 
      CrossCheckTraceToStartTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckTraceToStartTeam1MemberWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new CrossCheckTraceToStartTeam1MemberWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckTraceToStartTeam1MemberWriter.writerCreated = var; 
  }
}
