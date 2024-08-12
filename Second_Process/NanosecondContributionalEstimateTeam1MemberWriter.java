package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondContributionalEstimateTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondContributionalEstimateTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_State.getFileWriter(team, memberNo, round); 
      NanosecondContributionalEstimateTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondContributionalEstimateTeam1MemberWriter.writerCreated == false) {
      new NanosecondContributionalEstimateTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondContributionalEstimateTeam1MemberWriter.writerCreated = var; 
  }
}
