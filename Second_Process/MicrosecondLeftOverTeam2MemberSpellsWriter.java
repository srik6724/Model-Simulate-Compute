package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondLeftOverTeam2MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondLeftOverTeam2MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Remaining.getFileWriter(team, memberNo, round); 
      MicrosecondLeftOverTeam2MemberSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondLeftOverTeam2MemberSpellsWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor."); 
      new MicrosecondLeftOverTeam2MemberSpellsWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondLeftOverTeam2MemberSpellsWriter.writerCreated = var; 
  }
}
