package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckIncorporationConceptTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  CrossCheckIncorporationConceptTeam1Writer(int round, String team) {
    try {
      file_writer = Cross_Check_Incorporation_Concept.getFileWriter(team, round);
      CrossCheckIncorporationConceptTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckIncorporationConceptTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_incorporation_concept constructor."); 
      new CrossCheckIncorporationConceptTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckIncorporationConceptTeam1Writer.writerCreated = var; 
  }
}
