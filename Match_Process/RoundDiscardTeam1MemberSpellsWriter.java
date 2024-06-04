package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundDiscardTeam1MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundDiscardTeam1MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Discarder.getFileWriter(team, memberNo, round); 
      RoundDiscardTeam1MemberSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundDiscardTeam1MemberSpellsWriter.writerCreated == false) {
      new RoundDiscardTeam1MemberSpellsWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundDiscardTeam1MemberSpellsWriter.writerCreated = var; 
  }
}
