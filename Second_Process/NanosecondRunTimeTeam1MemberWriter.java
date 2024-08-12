package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondRunTimeTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondRunTimeTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Process.getFileWriter(team, memberNo, round); 
      NanosecondRunTimeTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondRunTimeTeam1MemberWriter.writerCreated == true) {
      System.out.println("Calling round_run_time constructor"); 
      new NanosecondRunTimeTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondRunTimeTeam1MemberWriter.writerCreated = true; 
  }
}
