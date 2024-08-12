package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondAudienceTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  
  NanosecondAudienceTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Engagement.getFileWriter(team, memberNo, round);
      NanosecondAudienceTeam2MemberWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondAudienceTeam2MemberWriter.writerCreated == false) {
      new NanosecondAudienceTeam2MemberWriter("t2", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondAudienceTeam2MemberWriter.writerCreated = var; 
  }
}
