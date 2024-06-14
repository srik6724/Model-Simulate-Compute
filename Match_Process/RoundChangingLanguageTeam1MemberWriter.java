package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundChangingLanguageTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundChangingLanguageTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Dynamic_Language.getFileWriter(team, memberNo, round);
      RoundChangingLanguageTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundChangingLanguageTeam1MemberWriter.writerCreated == false) {
      new RoundChangingLanguageTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundChangingLanguageTeam1MemberWriter.writerCreated = var; 
  }
}
