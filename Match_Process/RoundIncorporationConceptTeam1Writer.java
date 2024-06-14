package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundIncorporationConceptTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  RoundIncorporationConceptTeam1Writer(int round, String team) {
    try {
      file_writer = Round_Incorporation_Concept.getFileWriter(team, round);
      RoundIncorporationConceptTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundIncorporationConceptTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_incorporation_concept constructor."); 
      new RoundIncorporationConceptTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundIncorporationConceptTeam1Writer.writerCreated = var; 
  }
}
