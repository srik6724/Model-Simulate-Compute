package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckCombineTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];

  CrossCheckCombineTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Merge_Finalizer.getFileWriter(team, memberNo, round);
      CrossCheckCombineTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckCombineTeam2MemberWriter.writerCreated == false) {
      System.out.println("Calling round_combine constructor");
      new CrossCheckCombineTeam2MemberWriter("t2",  memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckCombineTeam2MemberWriter.writerCreated = var; 
  }
}
