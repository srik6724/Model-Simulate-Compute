package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondOrderingPlacementsTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondOrderingPlacementsTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Permutations.getFileWriter(team, memberNo, round); 
      MicrosecondOrderingPlacementsTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondOrderingPlacementsTeam2MemberWriter.writerCreated == false) {
      new MicrosecondOrderingPlacementsTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondOrderingPlacementsTeam2MemberWriter.writerCreated = var; 
  }
}
