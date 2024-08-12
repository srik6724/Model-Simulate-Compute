package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondSatisfierTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondSatisfierTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Solution.getFileWriter(team, memberNo, round); 
      NanosecondSatisfierTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondSatisfierTeam1MemberWriter.writerCreated == true) {
      System.out.println("Calling round_satisfier constructor"); 
      new NanosecondSatisfierTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondSatisfierTeam1MemberWriter.writerCreated = true; 
  }
}
