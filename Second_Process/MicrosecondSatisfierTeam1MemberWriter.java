package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondSatisfierTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondSatisfierTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Solution.getFileWriter(team, memberNo, round); 
      MicrosecondSatisfierTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondSatisfierTeam1MemberWriter.writerCreated == true) {
      System.out.println("Calling round_satisfier constructor"); 
      new MicrosecondSatisfierTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondSatisfierTeam1MemberWriter.writerCreated = true; 
  }
}
