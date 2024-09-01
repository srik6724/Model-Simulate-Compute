package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckTraceToStartTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  

  CrossCheckTraceToStartTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Backtrack.getFileWriter(team, memberNo, round); 
      CrossCheckTraceToStartTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckTraceToStartTeam2MemberWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new CrossCheckTraceToStartTeam2MemberWriter("t2", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckTraceToStartTeam2MemberWriter.writerCreated = var; 
  }
}
