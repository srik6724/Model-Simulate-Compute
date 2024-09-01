package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckStaticLanguageTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];  

  CrossCheckStaticLanguageTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Fixed_Language.getFileWriter(team, memberNo, round); 
      CrossCheckStaticLanguageTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckStaticLanguageTeam1MemberWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new CrossCheckStaticLanguageTeam1MemberWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckStaticLanguageTeam1MemberWriter.writerCreated = var; 
  }
}
