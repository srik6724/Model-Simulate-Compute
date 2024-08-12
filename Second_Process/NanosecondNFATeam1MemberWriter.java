package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondNFATeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondNFATeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_NFA.getFileWriter(team, memberNo, round); 
      NanosecondNFATeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondNFATeam1MemberWriter.writerCreated == false) {
      new NanosecondNFATeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondNFATeam1MemberWriter.writerCreated = var; 
  }
}
