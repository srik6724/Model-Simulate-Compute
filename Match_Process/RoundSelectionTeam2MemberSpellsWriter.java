package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundSelectionTeam2MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  
  RoundSelectionTeam2MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Selection.getFileWriter(team, memberNo, round); 
      RoundSelectionTeam2MemberSpellsWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundSelectionTeam2MemberSpellsWriter.writerCreated == true) {
      new RoundSelectionTeam2MemberSpellsWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundSelectionTeam2MemberSpellsWriter.writerCreated = true; 
  }
}
