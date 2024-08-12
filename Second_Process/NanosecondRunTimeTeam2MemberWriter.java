package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondRunTimeTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondRunTimeTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Process.getFileWriter(team, memberNo, round); 
      NanosecondRunTimeTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondRunTimeTeam2MemberWriter.writerCreated == true) {
      System.out.println("Calling round_run_time constructor"); 
      new NanosecondRunTimeTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondRunTimeTeam2MemberWriter.writerCreated = true; 
  }
}
