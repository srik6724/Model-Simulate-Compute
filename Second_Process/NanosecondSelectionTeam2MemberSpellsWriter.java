package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondSelectionTeam2MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  
  NanosecondSelectionTeam2MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Selection.getFileWriter(team, memberNo, round); 
      NanosecondSelectionTeam2MemberSpellsWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondSelectionTeam2MemberSpellsWriter.writerCreated == false) {
      new NanosecondSelectionTeam2MemberSpellsWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondSelectionTeam2MemberSpellsWriter.writerCreated = var; 
  }
}
