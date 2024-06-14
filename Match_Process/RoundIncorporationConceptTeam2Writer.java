package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundIncorporationConceptTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  RoundIncorporationConceptTeam2Writer(int round, String team) {
    try {
      file_writer = Round_Incorporation_Concept.getFileWriter(team, round);
      RoundIncorporationConceptTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundIncorporationConceptTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_incorporation_concept constructor."); 
      new RoundIncorporationConceptTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundIncorporationConceptTeam2Writer.writerCreated = var; 
  }
}
