package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckModeOfOperationsTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckModeOfOperationsTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Hierarchy.getFileWriter(team, memberNo, round); 
      CrossCheckModeOfOperationsTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckModeOfOperationsTeam2MemberWriter.writerCreated == false) {
      new CrossCheckModeOfOperationsTeam1MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckModeOfOperationsTeam2MemberWriter.writerCreated = var; 
  }
}
