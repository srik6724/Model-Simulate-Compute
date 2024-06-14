package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundPrGraphTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundPrGraphTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_pyreason_graph.getFileWriter(team, memberNo, round);
      RoundPrGraphTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundPrGraphTeam2MemberWriter.writerCreated == false) {
      new RoundPrGraphTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundPrGraphTeam2MemberWriter.writerCreated = var; 
  }
}
