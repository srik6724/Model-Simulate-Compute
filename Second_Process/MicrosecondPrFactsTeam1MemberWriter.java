package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondPrFactsTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];  

  MicrosecondPrFactsTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_pyreason_facts.getFileWriter(team, memberNo, round); 
      MicrosecondPrFactsTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondPrFactsTeam1MemberWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new MicrosecondTeam1MemberSpellsWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondPrFactsTeam1MemberWriter.writerCreated = var; 
  }
}
