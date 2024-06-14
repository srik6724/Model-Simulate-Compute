package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundNFATeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundNFATeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_NFA.getFileWriter(team, memberNo, round); 
      RoundNFATeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundNFATeam1MemberWriter.writerCreated == false) {
      new RoundNFATeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundNFATeam1MemberWriter.writerCreated = var; 
  }
}
