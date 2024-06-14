package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundStaticLanguageTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];  

  RoundStaticLanguageTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Fixed_Language.getFileWriter(team, memberNo, round); 
      RoundStaticLanguageTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundStaticLanguageTeam2MemberWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new RoundStaticLanguageTeam2MemberWriter("t2", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    RoundStaticLanguageTeam2MemberWriter.writerCreated = var; 
  }
}
