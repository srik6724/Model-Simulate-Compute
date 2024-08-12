package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondStaticLanguageTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];  

  NanosecondStaticLanguageTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Fixed_Language.getFileWriter(team, memberNo, round); 
      NanosecondStaticLanguageTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondStaticLanguageTeam1MemberWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new NanosecondStaticLanguageTeam1MemberWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondStaticLanguageTeam1MemberWriter.writerCreated = var; 
  }
}
