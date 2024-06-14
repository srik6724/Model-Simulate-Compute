package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundChangingLanguageTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundChangingLanguageTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Dynamic_Language.getFileWriter(team, memberNo, round);
      RoundChangingLanguageTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundChangingLanguageTeam2MemberWriter.writerCreated == false) {
      new RoundChangingLanguageTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundChangingLanguageTeam2MemberWriter.writerCreated = var; 
  }
}
