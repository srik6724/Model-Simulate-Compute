package Second_Process;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class MicrosecondTeam1MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];  

  MicrosecondTeam1MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Recorder.getFileWriter(team, memberNo, round); 
      MicrosecondTeam1MemberSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondTeam1MemberSpellsWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new MicrosecondTeam1MemberSpellsWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondTeam1MemberSpellsWriter.writerCreated = var; 
  }
}
