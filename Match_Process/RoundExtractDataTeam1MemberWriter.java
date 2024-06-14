package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundExtractDataTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundExtractDataTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Statistics.getFileWriter(team, memberNo, round); 
      RoundExtractDataTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundExtractDataTeam1MemberWriter.writerCreated == false) {
      new RoundDiscardTeam1MemberSpellsWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundExtractDataTeam1MemberWriter.writerCreated = var; 
  }
}