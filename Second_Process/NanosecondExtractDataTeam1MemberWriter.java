package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondExtractDataTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondExtractDataTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Statistics.getFileWriter(team, memberNo, round); 
      NanosecondExtractDataTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondExtractDataTeam1MemberWriter.writerCreated == false) {
      new NanosecondDiscardTeam1MemberSpellsWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondExtractDataTeam1MemberWriter.writerCreated = var; 
  }
}