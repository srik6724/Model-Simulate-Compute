package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundAudienceTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  
  RoundAudienceTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Engagement.getFileWriter(team, memberNo, round);
      RoundAudienceTeam1MemberWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundAudienceTeam1MemberWriter.writerCreated == false) {
      new RoundAudienceTeam1MemberWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    RoundAudienceTeam1MemberWriter.writerCreated = var; 
  }
}
