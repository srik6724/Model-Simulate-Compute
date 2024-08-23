package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondNFATeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondNFATeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_NFA.getFileWriter(team, memberNo, round); 
      MicrosecondNFATeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondNFATeam2MemberWriter.writerCreated == false) {
      new MicrosecondNFATeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondNFATeam2MemberWriter.writerCreated = var; 
  }
}
