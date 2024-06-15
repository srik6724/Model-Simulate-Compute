package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundOutputSpellsTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundOutputSpellsTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Transducer.getFileWriter(team, memberNo, round); 
      RoundOutputSpellsTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundOutputSpellsTeam1MemberWriter.writerCreated == false) {
      new RoundOutputSpellsTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundOutputSpellsTeam1MemberWriter.writerCreated = var; 
  }
}