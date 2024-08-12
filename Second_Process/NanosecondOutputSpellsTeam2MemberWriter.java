package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondOutputSpellsTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondOutputSpellsTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Transducer.getFileWriter(team, memberNo, round); 
      NanosecondOutputSpellsTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondOutputSpellsTeam2MemberWriter.writerCreated == false) {
      new NanosecondOutputSpellsTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondOutputSpellsTeam2MemberWriter.writerCreated = var; 
  }
}
