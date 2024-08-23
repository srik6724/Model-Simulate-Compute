package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondExtractDataTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondExtractDataTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Statistics.getFileWriter(team, memberNo, round); 
      MicrosecondExtractDataTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondExtractDataTeam1MemberWriter.writerCreated == false) {
      new MicrosecondDiscardTeam1MemberSpellsWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondExtractDataTeam1MemberWriter.writerCreated = var; 
  }
}