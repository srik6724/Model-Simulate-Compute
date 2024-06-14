package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundOutputSpellsTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundOutputSpellsTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Transducer.getFileWriter(team, memberNo, round); 
      RoundOutputSpellsTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundOutputSpellsTeam2MemberWriter.writerCreated == false) {
      new RoundOutputSpellsTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundOutputSpellsTeam2MemberWriter.writerCreated = var; 
  }
}
