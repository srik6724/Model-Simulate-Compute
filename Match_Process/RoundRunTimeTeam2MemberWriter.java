package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundRunTimeTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundRunTimeTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Process.getFileWriter(team, memberNo, round); 
      RoundRunTimeTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundRunTimeTeam2MemberWriter.writerCreated == true) {
      System.out.println("Calling round_run_time constructor"); 
      new RoundRunTimeTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundRunTimeTeam2MemberWriter.writerCreated = true; 
  }
}
