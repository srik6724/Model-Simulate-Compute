package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckOutputSpellsTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckOutputSpellsTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Transducer.getFileWriter(team, memberNo, round); 
      CrossCheckOutputSpellsTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckOutputSpellsTeam1MemberWriter.writerCreated == false) {
      new CrossCheckOutputSpellsTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckOutputSpellsTeam1MemberWriter.writerCreated = var; 
  }
}
