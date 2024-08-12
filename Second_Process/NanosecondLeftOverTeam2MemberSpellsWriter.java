package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondLeftOverTeam2MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondLeftOverTeam2MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Remaining.getFileWriter(team, memberNo, round); 
      NanosecondLeftOverTeam2MemberSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondLeftOverTeam2MemberSpellsWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor."); 
      new NanosecondLeftOverTeam2MemberSpellsWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondLeftOverTeam2MemberSpellsWriter.writerCreated = var; 
  }
}
