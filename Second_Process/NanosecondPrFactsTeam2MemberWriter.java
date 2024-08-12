package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondPrFactsTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];  

  NanosecondPrFactsTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_pyreason_facts.getFileWriter(team, memberNo, round); 
      NanosecondPrFactsTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondPrFactsTeam2MemberWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new NanosecondPrFactsTeam2MemberWriter("t2", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondPrFactsTeam2MemberWriter.writerCreated = var; 
  }
}
