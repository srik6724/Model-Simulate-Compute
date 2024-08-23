package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondLeftOverTeam1MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondLeftOverTeam1MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Remaining.getFileWriter(team, memberNo, round); 
      MicrosecondLeftOverTeam1MemberSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondLeftOverTeam1MemberSpellsWriter.writerCreated == false) {
      new MicrosecondLeftOverTeam1MemberSpellsWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondLeftOverTeam1MemberSpellsWriter.writerCreated = var; 
  }
}
