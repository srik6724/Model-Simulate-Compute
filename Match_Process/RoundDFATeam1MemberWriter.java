package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundDFATeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];

  RoundDFATeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_DFA.getFileWriter(team, memberNo, round);
      RoundDFATeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundDFATeam1MemberWriter.writerCreated == false) {
      System.out.println("Calling round_combine constructor");
      new RoundDFATeam1MemberWriter("t1",  memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    RoundDFATeam1MemberWriter.writerCreated = var; 
  }
}
