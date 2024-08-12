package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondChangingLanguageTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondChangingLanguageTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Dynamic_Language.getFileWriter(team, memberNo, round);
      NanosecondChangingLanguageTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondChangingLanguageTeam2MemberWriter.writerCreated == false) {
      new NanosecondChangingLanguageTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondChangingLanguageTeam2MemberWriter.writerCreated = var; 
  }
}
