package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckSelectionTeam2MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  
  CrossCheckSelectionTeam2MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Selection.getFileWriter(team, memberNo, round); 
      CrossCheckSelectionTeam2MemberSpellsWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckSelectionTeam2MemberSpellsWriter.writerCreated == false) {
      new CrossCheckSelectionTeam2MemberSpellsWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckSelectionTeam2MemberSpellsWriter.writerCreated = var; 
  }
}
