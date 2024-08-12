package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondIncorporationConceptTeam1MemberWriter {
   private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondIncorporationConceptTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Incorporation_Concept.getFileWriter(team, memberNo, round); 
      NanosecondIncorporationConceptTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondIncorporationConceptTeam1MemberWriter.writerCreated == false) {
      new NanosecondIncorporationConceptTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondIncorporationConceptTeam1MemberWriter.writerCreated = var; 
  }
}
