package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckExtractDataTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckExtractDataTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Statistics.getFileWriter(team, memberNo, round); 
      CrossCheckExtractDataTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckExtractDataTeam1MemberWriter.writerCreated == false) {
      new CrossCheckDiscardTeam1MemberSpellsWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckExtractDataTeam1MemberWriter.writerCreated = var; 
  }
}