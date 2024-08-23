package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondDiscardTeam1MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondDiscardTeam1MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Discarder.getFileWriter(team, memberNo, round); 
      MicrosecondDiscardTeam1MemberSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondDiscardTeam1MemberSpellsWriter.writerCreated == false) {
      new MicrosecondDiscardTeam1MemberSpellsWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondDiscardTeam1MemberSpellsWriter.writerCreated = var; 
  }
}
