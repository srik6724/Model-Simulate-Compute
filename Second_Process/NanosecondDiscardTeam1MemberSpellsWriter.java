package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondDiscardTeam1MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondDiscardTeam1MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Discarder.getFileWriter(team, memberNo, round); 
      NanosecondDiscardTeam1MemberSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondDiscardTeam1MemberSpellsWriter.writerCreated == false) {
      new NanosecondDiscardTeam1MemberSpellsWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondDiscardTeam1MemberSpellsWriter.writerCreated = var; 
  }
}
