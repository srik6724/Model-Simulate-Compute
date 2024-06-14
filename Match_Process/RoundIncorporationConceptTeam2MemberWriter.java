package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundIncorporationConceptTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundIncorporationConceptTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Incorporation_Concept.getFileWriter(team, memberNo, round); 
      RoundIncorporationConceptTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundIncorporationConceptTeam2MemberWriter.writerCreated == false) {
      new RoundIncorporationConceptTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundIncorporationConceptTeam2MemberWriter.writerCreated = var; 
  }
}
