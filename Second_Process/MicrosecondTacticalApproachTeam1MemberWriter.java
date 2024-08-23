package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondTacticalApproachTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondTacticalApproachTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Strategy.getFileWriter(team, memberNo, round);
      MicrosecondTacticalApproachTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondTacticalApproachTeam1MemberWriter.writerCreated == false) {
      new MicrosecondTacticalApproachTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondTacticalApproachTeam1MemberWriter.writerCreated = var; 
  }
}
