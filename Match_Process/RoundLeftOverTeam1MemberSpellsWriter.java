package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundLeftOverTeam1MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundLeftOverTeam1MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Remaining.getFileWriter(team, memberNo, round); 
      RoundLeftOverTeam1MemberSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundLeftOverTeam1MemberSpellsWriter.writerCreated == false) {
      new RoundLeftOverTeam1MemberSpellsWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundLeftOverTeam1MemberSpellsWriter.writerCreated = var; 
  }
}
