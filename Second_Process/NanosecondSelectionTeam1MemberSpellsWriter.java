package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondSelectionTeam1MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondSelectionTeam1MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Selection.getFileWriter(team, memberNo, round); 
      NanosecondSelectionTeam1MemberSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondSelectionTeam1MemberSpellsWriter.writerCreated == false) {
      new NanosecondSelectionTeam1MemberSpellsWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondSelectionTeam1MemberSpellsWriter.writerCreated = var; 
  }
}
