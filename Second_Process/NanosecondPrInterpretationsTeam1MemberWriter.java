package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondPrInterpretationsTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondPrInterpretationsTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_pyreason_graph.getFileWriter(team, memberNo, round);
      NanosecondPrInterpretationsTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondPrInterpretationsTeam1MemberWriter.writerCreated == false) {
      new NanosecondPrInterpretationsTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondPrInterpretationsTeam1MemberWriter.writerCreated = var; 
  }
}
