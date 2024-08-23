package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondPrInterpretationsTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondPrInterpretationsTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_pyreason_graph.getFileWriter(team, memberNo, round);
      MicrosecondPrInterpretationsTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondPrInterpretationsTeam1MemberWriter.writerCreated == false) {
      new MicrosecondPrInterpretationsTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondPrInterpretationsTeam1MemberWriter.writerCreated = var; 
  }
}
