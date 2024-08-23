package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondIncorporationConceptTeam1MemberWriter {
   private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondIncorporationConceptTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Incorporation_Concept.getFileWriter(team, memberNo, round); 
      MicrosecondIncorporationConceptTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondIncorporationConceptTeam1MemberWriter.writerCreated == false) {
      new MicrosecondIncorporationConceptTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondIncorporationConceptTeam1MemberWriter.writerCreated = var; 
  }
}
