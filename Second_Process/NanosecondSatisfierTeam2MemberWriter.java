package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondSatisfierTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondSatisfierTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Solution.getFileWriter(team, memberNo, round); 
      NanosecondSatisfierTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondSatisfierTeam2MemberWriter.writerCreated == true) {
      System.out.println("Calling round_satisfier constructor"); 
      new NanosecondSatisfierTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondSatisfierTeam2MemberWriter.writerCreated = true; 
  }
}
