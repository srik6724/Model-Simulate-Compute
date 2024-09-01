package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckIncorporationConceptTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckIncorporationConceptTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Incorporation_Concept.getFileWriter(team, memberNo, round); 
      CrossCheckIncorporationConceptTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckIncorporationConceptTeam2MemberWriter.writerCreated == false) {
      new CrossCheckIncorporationConceptTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckIncorporationConceptTeam2MemberWriter.writerCreated = var; 
  }
}
