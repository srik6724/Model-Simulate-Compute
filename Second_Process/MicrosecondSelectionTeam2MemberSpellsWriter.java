package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondSelectionTeam2MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  
  MicrosecondSelectionTeam2MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Selection.getFileWriter(team, memberNo, round); 
      MicrosecondSelectionTeam2MemberSpellsWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondSelectionTeam2MemberSpellsWriter.writerCreated == false) {
      new MicrosecondSelectionTeam2MemberSpellsWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondSelectionTeam2MemberSpellsWriter.writerCreated = var; 
  }
}
