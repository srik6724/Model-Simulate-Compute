package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondAudienceTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  
  MicrosecondAudienceTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Engagement.getFileWriter(team, memberNo, round);
      MicrosecondAudienceTeam2MemberWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondAudienceTeam2MemberWriter.writerCreated == false) {
      new MicrosecondAudienceTeam2MemberWriter("t2", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondAudienceTeam2MemberWriter.writerCreated = var; 
  }
}
