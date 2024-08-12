package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondLeftOverTeam1MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondLeftOverTeam1MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Remaining.getFileWriter(team, memberNo, round); 
      NanosecondLeftOverTeam1MemberSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondLeftOverTeam1MemberSpellsWriter.writerCreated == false) {
      new NanosecondLeftOverTeam1MemberSpellsWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondLeftOverTeam1MemberSpellsWriter.writerCreated = var; 
  }
}
