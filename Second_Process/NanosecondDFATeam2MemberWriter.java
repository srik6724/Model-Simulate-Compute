package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondDFATeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];

  NanosecondDFATeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_DFA.getFileWriter(team, memberNo, round);
      NanosecondDFATeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondDFATeam2MemberWriter.writerCreated == false) {
      System.out.println("Calling round_combine constructor");
      new NanosecondDFATeam2MemberWriter("t2",  memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondDFATeam2MemberWriter.writerCreated = var; 
  }
}
