package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckStaticLanguageTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];  

  CrossCheckStaticLanguageTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Fixed_Language.getFileWriter(team, memberNo, round); 
      CrossCheckStaticLanguageTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckStaticLanguageTeam2MemberWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new CrossCheckStaticLanguageTeam2MemberWriter("t2", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckStaticLanguageTeam2MemberWriter.writerCreated = var; 
  }
}
