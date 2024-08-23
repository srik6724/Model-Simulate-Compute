package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondPrFactsTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];  

  MicrosecondPrFactsTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_pyreason_facts.getFileWriter(team, memberNo, round); 
      MicrosecondPrFactsTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondPrFactsTeam2MemberWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new MicrosecondPrFactsTeam2MemberWriter("t2", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondPrFactsTeam2MemberWriter.writerCreated = var; 
  }
}
