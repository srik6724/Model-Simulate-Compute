package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondNFATeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondNFATeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_NFA.getFileWriter(team, memberNo, round); 
      NanosecondNFATeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondNFATeam2MemberWriter.writerCreated == false) {
      new NanosecondNFATeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondNFATeam2MemberWriter.writerCreated = var; 
  }
}
