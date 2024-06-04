package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundCombineTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];

  RoundCombineTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Merge_Finalizer.getFileWriter(team, memberNo, round);
      RoundCombineTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundCombineTeam2MemberWriter.writerCreated == false) {
      System.out.println("Calling round_combine constructor");
      new RoundCombineTeam2MemberWriter("t2",  memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    RoundCombineTeam2MemberWriter.writerCreated = var; 
  }
}