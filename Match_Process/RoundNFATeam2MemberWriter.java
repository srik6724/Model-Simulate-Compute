package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundNFATeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundNFATeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_NFA.getFileWriter(team, memberNo, round); 
      RoundNFATeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundNFATeam2MemberWriter.writerCreated == false) {
      new RoundNFATeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundNFATeam2MemberWriter.writerCreated = var; 
  }
}
