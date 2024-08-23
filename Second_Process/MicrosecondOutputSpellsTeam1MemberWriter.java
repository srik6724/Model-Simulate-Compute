package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondOutputSpellsTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondOutputSpellsTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Transducer.getFileWriter(team, memberNo, round); 
      MicrosecondOutputSpellsTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondOutputSpellsTeam1MemberWriter.writerCreated == false) {
      new MicrosecondOutputSpellsTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondOutputSpellsTeam1MemberWriter.writerCreated = var; 
  }
}
