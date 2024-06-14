package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundModeOfOperationsTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundModeOfOperationsTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Hierarchy.getFileWriter(team, memberNo, round); 
      RoundModeOfOperationsTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundModeOfOperationsTeam1MemberWriter.writerCreated == false) {
      new RoundModeOfOperationsTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundModeOfOperationsTeam1MemberWriter.writerCreated = var; 
  }
}
