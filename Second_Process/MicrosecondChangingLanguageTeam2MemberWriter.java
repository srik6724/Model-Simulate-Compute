package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondChangingLanguageTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondChangingLanguageTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Dynamic_Language.getFileWriter(team, memberNo, round);
      MicrosecondChangingLanguageTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondChangingLanguageTeam2MemberWriter.writerCreated == false) {
      new MicrosecondChangingLanguageTeam1MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondChangingLanguageTeam2MemberWriter.writerCreated = var; 
  }
}
