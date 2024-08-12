package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondPrRulesTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];  

  NanosecondPrRulesTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_pyreason_rules.getFileWriter(team, memberNo, round); 
      NanosecondPrRulesTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondPrRulesTeam1MemberWriter.writerCreated == false) {
      System.out.println("Calling round_pr_rules constructor"); 
      new NanosecondPrRulesTeam1MemberWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondPrRulesTeam1MemberWriter.writerCreated = var; 
  }
}
