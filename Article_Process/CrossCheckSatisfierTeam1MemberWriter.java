package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckSatisfierTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckSatisfierTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Solution.getFileWriter(team, memberNo, round); 
      CrossCheckSatisfierTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckSatisfierTeam1MemberWriter.writerCreated == true) {
      System.out.println("Calling round_satisfier constructor"); 
      new CrossCheckSatisfierTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckSatisfierTeam1MemberWriter.writerCreated = true; 
  }
}
