package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundStaticLanguageTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];  

  RoundStaticLanguageTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Fixed_Language.getFileWriter(team, memberNo, round); 
      RoundStaticLanguageTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundStaticLanguageTeam1MemberWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new RoundStaticLanguageTeam1MemberWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    RoundStaticLanguageTeam1MemberWriter.writerCreated = var; 
  }
}
