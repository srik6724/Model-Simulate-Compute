package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondContributionalEstimateTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondContributionalEstimateTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_State.getFileWriter(team, memberNo, round); 
      MicrosecondContributionalEstimateTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondContributionalEstimateTeam2MemberWriter.writerCreated == false) {
      new MicrosecondContributionalEstimateTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondContributionalEstimateTeam2MemberWriter.writerCreated = var; 
  }
}
