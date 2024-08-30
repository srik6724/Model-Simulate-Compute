package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckDFATeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];

  CrossCheckDFATeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_DFA.getFileWriter(team, memberNo, round);
      CrossCheckDFATeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckDFATeam1MemberWriter.writerCreated == false) {
      System.out.println("Calling round_combine constructor");
      new CrossCheckDFATeam1MemberWriter("t1",  memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckDFATeam1MemberWriter.writerCreated = var; 
  }
}
