package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondChangingLanguageTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondChangingLanguageTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Dynamic_Language.getFileWriter(team, memberNo, round);
      NanosecondChangingLanguageTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondChangingLanguageTeam1MemberWriter.writerCreated == false) {
      new NanosecondChangingLanguageTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondChangingLanguageTeam1MemberWriter.writerCreated = var; 
  }
}
