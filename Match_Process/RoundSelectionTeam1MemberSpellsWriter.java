package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundSelectionTeam1MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundSelectionTeam1MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Selection.getFileWriter(team, memberNo, round); 
      RoundSelectionTeam1MemberSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundSelectionTeam1MemberSpellsWriter.writerCreated == true) {
      new RoundSelectionTeam1MemberSpellsWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundSelectionTeam1MemberSpellsWriter.writerCreated = true; 
  }
}
