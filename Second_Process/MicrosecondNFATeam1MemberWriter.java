package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondNFATeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondNFATeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_NFA.getFileWriter(team, memberNo, round); 
      MicrosecondNFATeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondNFATeam1MemberWriter.writerCreated == false) {
      new MicrosecondNFATeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondNFATeam1MemberWriter.writerCreated = var; 
  }
}
