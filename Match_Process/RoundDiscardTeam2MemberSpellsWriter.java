package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundDiscardTeam2MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundDiscardTeam2MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Discarder.getFileWriter(team, memberNo, round); 
      RoundDiscardTeam2MemberSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundDiscardTeam2MemberSpellsWriter.writerCreated == false) {
      new RoundDiscardTeam2MemberSpellsWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundDiscardTeam2MemberSpellsWriter.writerCreated = var; 
  }
}
