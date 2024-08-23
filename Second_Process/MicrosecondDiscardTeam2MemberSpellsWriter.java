package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondDiscardTeam2MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondDiscardTeam2MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Discarder.getFileWriter(team, memberNo, round); 
      MicrosecondDiscardTeam2MemberSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondDiscardTeam2MemberSpellsWriter.writerCreated == false) {
      new MicrosecondDiscardTeam2MemberSpellsWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondDiscardTeam2MemberSpellsWriter.writerCreated = var; 
  }
}
