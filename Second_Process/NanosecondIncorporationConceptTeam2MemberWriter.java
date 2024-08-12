package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondIncorporationConceptTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondIncorporationConceptTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Incorporation_Concept.getFileWriter(team, memberNo, round); 
      NanosecondIncorporationConceptTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondIncorporationConceptTeam2MemberWriter.writerCreated == false) {
      new NanosecondIncorporationConceptTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondIncorporationConceptTeam2MemberWriter.writerCreated = var; 
  }
}
