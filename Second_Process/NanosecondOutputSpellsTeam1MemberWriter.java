package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondOutputSpellsTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondOutputSpellsTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Transducer.getFileWriter(team, memberNo, round); 
      NanosecondOutputSpellsTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondOutputSpellsTeam1MemberWriter.writerCreated == false) {
      new NanosecondOutputSpellsTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondOutputSpellsTeam1MemberWriter.writerCreated = var; 
  }
}
