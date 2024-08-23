package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondContributionalEstimateTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondContributionalEstimateTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_State.getFileWriter(team, memberNo, round); 
      MicrosecondContributionalEstimateTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondContributionalEstimateTeam1MemberWriter.writerCreated == false) {
      new MicrosecondContributionalEstimateTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondContributionalEstimateTeam1MemberWriter.writerCreated = var; 
  }
}
