package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondSelectionTeam1MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondSelectionTeam1MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Selection.getFileWriter(team, memberNo, round); 
      MicrosecondSelectionTeam1MemberSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondSelectionTeam1MemberSpellsWriter.writerCreated == false) {
      new MicrosecondSelectionTeam1MemberSpellsWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondSelectionTeam1MemberSpellsWriter.writerCreated = var; 
  }
}
