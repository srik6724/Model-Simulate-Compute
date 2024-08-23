package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondDFATeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];

  MicrosecondDFATeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_DFA.getFileWriter(team, memberNo, round);
      MicrosecondDFATeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondDFATeam2MemberWriter.writerCreated == false) {
      System.out.println("Calling round_combine constructor");
      new MicrosecondDFATeam2MemberWriter("t2",  memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondDFATeam2MemberWriter.writerCreated = var; 
  }
}
