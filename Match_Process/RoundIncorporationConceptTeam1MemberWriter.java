package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundIncorporationConceptTeam1MemberWriter {
   private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundIncorporationConceptTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Incorporation_Concept.getFileWriter(team, memberNo, round); 
      RoundIncorporationConceptTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundIncorporationConceptTeam1MemberWriter.writerCreated == false) {
      new RoundIncorporationConceptTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundIncorporationConceptTeam1MemberWriter.writerCreated = var; 
  }
}
