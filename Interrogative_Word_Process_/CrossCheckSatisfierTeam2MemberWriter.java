package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckSatisfierTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckSatisfierTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Solution.getFileWriter(team, memberNo, round); 
      CrossCheckSatisfierTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckSatisfierTeam2MemberWriter.writerCreated == true) {
      System.out.println("Calling round_satisfier constructor"); 
      new CrossCheckSatisfierTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckSatisfierTeam2MemberWriter.writerCreated = true; 
  }
}
