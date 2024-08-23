package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondAudienceTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  
  MicrosecondAudienceTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Engagement.getFileWriter(team, memberNo, round);
      MicrosecondAudienceTeam1MemberWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondAudienceTeam1MemberWriter.writerCreated == false) {
      new MicrosecondAudienceTeam1MemberWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondAudienceTeam1MemberWriter.writerCreated = var; 
  }
}
