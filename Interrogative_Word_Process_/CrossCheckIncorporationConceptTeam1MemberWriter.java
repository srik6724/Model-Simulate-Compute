package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckIncorporationConceptTeam1MemberWriter {
   private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckIncorporationConceptTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Incorporation_Concept.getFileWriter(team, memberNo, round); 
      CrossCheckIncorporationConceptTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckIncorporationConceptTeam1MemberWriter.writerCreated == false) {
      new CrossCheckIncorporationConceptTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckIncorporationConceptTeam1MemberWriter.writerCreated = var; 
  }
}
