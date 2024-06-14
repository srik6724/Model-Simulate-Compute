package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundIncorporationConceptWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  RoundIncorporationConceptWriter(int round, String team) {
    try {
      file_writer = Round_Incorporation_Concept.getFileWriter(team, round);
      RoundIncorporationConceptWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundIncorporationConceptWriter.writerCreated == false) {
      System.out.println("Calling round_incorporation_concept constructor."); 
      new RoundIncorporationConceptWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundIncorporationConceptWriter.writerCreated = var; 
  }
}
