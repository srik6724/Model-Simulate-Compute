package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondOrderingPlacementsTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondOrderingPlacementsTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Permutations.getFileWriter(team, memberNo, round); 
      MicrosecondOrderingPlacementsTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondOrderingPlacementsTeam1MemberWriter.writerCreated == false) {
      new MicrosecondLeftOverTeam1MemberSpellsWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondOrderingPlacementsTeam1MemberWriter.writerCreated = var; 
  }
}
