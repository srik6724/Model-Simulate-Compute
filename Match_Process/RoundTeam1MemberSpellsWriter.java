package Match_Process;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class RoundTeam1MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];  

  RoundTeam1MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Recorder.getFileWriter(team, memberNo, round); 
      RoundTeam1MemberSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundTeam1MemberSpellsWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new RoundTeam1MemberSpellsWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    RoundTeam1MemberSpellsWriter.writerCreated = var; 
  }
}
