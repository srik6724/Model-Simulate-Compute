package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondSatisfierTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondSatisfierTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Solution.getFileWriter(team, memberNo, round); 
      MicrosecondSatisfierTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondSatisfierTeam2MemberWriter.writerCreated == true) {
      System.out.println("Calling round_satisfier constructor"); 
      new MicrosecondSatisfierTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondSatisfierTeam2MemberWriter.writerCreated = true; 
  }
}
