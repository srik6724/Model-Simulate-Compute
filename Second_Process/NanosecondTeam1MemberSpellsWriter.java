package Second_Process;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class NanosecondTeam1MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];  

  NanosecondTeam1MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Recorder.getFileWriter(team, memberNo, round); 
      NanosecondTeam1MemberSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondTeam1MemberSpellsWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new NanosecondTeam1MemberSpellsWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondTeam1MemberSpellsWriter.writerCreated = var; 
  }
}
