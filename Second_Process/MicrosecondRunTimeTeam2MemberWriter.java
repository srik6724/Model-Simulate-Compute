package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondRunTimeTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondRunTimeTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Process.getFileWriter(team, memberNo, round); 
      MicrosecondRunTimeTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondRunTimeTeam2MemberWriter.writerCreated == true) {
      System.out.println("Calling round_run_time constructor"); 
      new MicrosecondRunTimeTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondRunTimeTeam2MemberWriter.writerCreated = true; 
  }
}
