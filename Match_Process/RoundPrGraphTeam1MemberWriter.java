package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundPrGraphTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundPrGraphTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_pyreason_graph.getFileWriter(team, memberNo, round);
      RoundPrGraphTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundPrGraphTeam1MemberWriter.writerCreated == false) {
      new RoundPrGraphTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundPrGraphTeam1MemberWriter.writerCreated = var; 
  }
}
