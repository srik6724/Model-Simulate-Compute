package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundReferencePointersTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundReferencePointersTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Simulation.getFileWriter(team, memberNo, round); 
      RoundReferencePointersTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundReferencePointersTeam1MemberWriter.writerCreated == false) {
      new RoundReferencePointersTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundReferencePointersTeam1MemberWriter.writerCreated = var; 
  }
}
