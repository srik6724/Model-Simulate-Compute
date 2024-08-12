package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondTacticalApproachTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondTacticalApproachTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Strategy.getFileWriter(team, memberNo, round);
      NanosecondTacticalApproachTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondTacticalApproachTeam1MemberWriter.writerCreated == false) {
      new NanosecondTacticalApproachTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondTacticalApproachTeam1MemberWriter.writerCreated = var; 
  }
}
