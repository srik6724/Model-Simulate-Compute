package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundOrderingPlacementsTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundOrderingPlacementsTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Permutations.getFileWriter(team, memberNo, round); 
      RoundOrderingPlacementsTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundOrderingPlacementsTeam1MemberWriter.writerCreated == false) {
      new RoundLeftOverTeam1MemberSpellsWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundOrderingPlacementsTeam1MemberWriter.writerCreated = var; 
  }
}
