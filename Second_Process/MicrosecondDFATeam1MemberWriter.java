package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondDFATeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];

  MicrosecondDFATeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_DFA.getFileWriter(team, memberNo, round);
      MicrosecondDFATeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondDFATeam1MemberWriter.writerCreated == false) {
      System.out.println("Calling round_combine constructor");
      new MicrosecondDFATeam1MemberWriter("t1",  memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondDFATeam1MemberWriter.writerCreated = var; 
  }
}
