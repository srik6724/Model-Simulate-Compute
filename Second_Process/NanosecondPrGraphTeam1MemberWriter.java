package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondPrGraphTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondPrGraphTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_pyreason_graph.getFileWriter(team, memberNo, round);
      NanosecondPrGraphTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondPrGraphTeam1MemberWriter.writerCreated == false) {
      new NanosecondPrGraphTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondPrGraphTeam1MemberWriter.writerCreated = var; 
  }
}
