package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckDFATeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];

  CrossCheckDFATeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_DFA.getFileWriter(team, memberNo, round);
      CrossCheckDFATeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckDFATeam2MemberWriter.writerCreated == false) {
      System.out.println("Calling round_combine constructor");
      new CrossCheckDFATeam2MemberWriter("t2",  memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckDFATeam2MemberWriter.writerCreated = var; 
  }
}
