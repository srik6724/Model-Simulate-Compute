package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondOrderingPlacementsTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondOrderingPlacementsTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Permutations.getFileWriter(team, memberNo, round); 
      NanosecondOrderingPlacementsTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondOrderingPlacementsTeam1MemberWriter.writerCreated == false) {
      new NanosecondLeftOverTeam1MemberSpellsWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondOrderingPlacementsTeam1MemberWriter.writerCreated = var; 
  }
}
