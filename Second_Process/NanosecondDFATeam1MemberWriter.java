package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondDFATeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];

  NanosecondDFATeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_DFA.getFileWriter(team, memberNo, round);
      NanosecondDFATeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondDFATeam1MemberWriter.writerCreated == false) {
      System.out.println("Calling round_combine constructor");
      new NanosecondDFATeam1MemberWriter("t1",  memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondDFATeam1MemberWriter.writerCreated = var; 
  }
}
