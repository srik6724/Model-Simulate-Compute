package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundOrderingPlacementsTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundOrderingPlacementsTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Permutations.getFileWriter(team, memberNo, round); 
      RoundOrderingPlacementsTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundOrderingPlacementsTeam2MemberWriter.writerCreated == false) {
      new RoundOrderingPlacementsTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundOrderingPlacementsTeam2MemberWriter.writerCreated = var; 
  }
}
