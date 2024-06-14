package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundSatisfierTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundSatisfierTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Solution.getFileWriter(team, memberNo, round); 
      RoundSatisfierTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundSatisfierTeam1MemberWriter.writerCreated == true) {
      System.out.println("Calling round_satisfier constructor"); 
      new RoundSatisfierTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundSatisfierTeam1MemberWriter.writerCreated = true; 
  }
}
