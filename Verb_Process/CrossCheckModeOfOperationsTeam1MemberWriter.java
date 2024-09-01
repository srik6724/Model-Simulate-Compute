package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckModeOfOperationsTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckModeOfOperationsTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Hierarchy.getFileWriter(team, memberNo, round); 
      CrossCheckModeOfOperationsTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckModeOfOperationsTeam1MemberWriter.writerCreated == false) {
      new CrossCheckModeOfOperationsTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckModeOfOperationsTeam1MemberWriter.writerCreated = var; 
  }
}
