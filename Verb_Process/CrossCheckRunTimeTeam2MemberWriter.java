package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckRunTimeTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckRunTimeTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Process.getFileWriter(team, memberNo, round); 
      CrossCheckRunTimeTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckRunTimeTeam2MemberWriter.writerCreated == true) {
      System.out.println("Calling round_run_time constructor"); 
      new CrossCheckRunTimeTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckRunTimeTeam2MemberWriter.writerCreated = true; 
  }
}
