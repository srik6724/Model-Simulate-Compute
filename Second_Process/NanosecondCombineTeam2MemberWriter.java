package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondCombineTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];

  NanosecondCombineTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Merge_Finalizer.getFileWriter(team, memberNo, round);
      NanosecondCombineTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondCombineTeam2MemberWriter.writerCreated == false) {
      System.out.println("Calling round_combine constructor");
      new NanosecondCombineTeam2MemberWriter("t2",  memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondCombineTeam2MemberWriter.writerCreated = var; 
  }
}
