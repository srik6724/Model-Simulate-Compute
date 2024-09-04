package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckRunTimeTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckRunTimeTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Process.getFileWriter(team, memberNo, round); 
      CrossCheckRunTimeTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckRunTimeTeam1MemberWriter.writerCreated == true) {
      System.out.println("Calling round_run_time constructor"); 
      new CrossCheckRunTimeTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckRunTimeTeam1MemberWriter.writerCreated = true; 
  }
}
