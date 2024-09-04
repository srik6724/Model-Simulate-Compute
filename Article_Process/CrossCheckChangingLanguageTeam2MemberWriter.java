package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckChangingLanguageTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckChangingLanguageTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Dynamic_Language.getFileWriter(team, memberNo, round);
      CrossCheckChangingLanguageTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckChangingLanguageTeam2MemberWriter.writerCreated == false) {
      new CrossCheckChangingLanguageTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckChangingLanguageTeam2MemberWriter.writerCreated = var; 
  }
}
