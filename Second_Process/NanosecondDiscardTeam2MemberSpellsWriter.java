package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondDiscardTeam2MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondDiscardTeam2MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Discarder.getFileWriter(team, memberNo, round); 
      NanosecondDiscardTeam2MemberSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondDiscardTeam2MemberSpellsWriter.writerCreated == false) {
      new NanosecondDiscardTeam2MemberSpellsWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondDiscardTeam2MemberSpellsWriter.writerCreated = var; 
  }
}
