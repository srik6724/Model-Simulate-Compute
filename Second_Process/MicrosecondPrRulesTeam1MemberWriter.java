package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondPrRulesTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];  

  MicrosecondPrRulesTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_pyreason_rules.getFileWriter(team, memberNo, round); 
      MicrosecondPrRulesTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondPrRulesTeam1MemberWriter.writerCreated == false) {
      System.out.println("Calling round_pr_rules constructor"); 
      new MicrosecondPrRulesTeam1MemberWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondPrRulesTeam1MemberWriter.writerCreated = var; 
  }
}
