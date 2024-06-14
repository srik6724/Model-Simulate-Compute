package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundPrInterpretationsTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundPrInterpretationsTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_pyreason_graph.getFileWriter(team, memberNo, round);
      RoundPrInterpretationsTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundPrInterpretationsTeam2MemberWriter.writerCreated == false) {
      new RoundPrInterpretationsTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundPrInterpretationsTeam2MemberWriter.writerCreated = var; 
  }
}
