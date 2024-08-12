package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondStaticLanguageTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];  

  NanosecondStaticLanguageTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Fixed_Language.getFileWriter(team, memberNo, round); 
      NanosecondStaticLanguageTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondStaticLanguageTeam2MemberWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new NanosecondStaticLanguageTeam2MemberWriter("t2", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondStaticLanguageTeam2MemberWriter.writerCreated = var; 
  }
}
