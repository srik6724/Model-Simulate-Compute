package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondOrderingPlacementsTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondOrderingPlacementsTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Permutations.getFileWriter(team, memberNo, round); 
      NanosecondOrderingPlacementsTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondOrderingPlacementsTeam2MemberWriter.writerCreated == false) {
      new NanosecondOrderingPlacementsTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondOrderingPlacementsTeam2MemberWriter.writerCreated = var; 
  }
}
