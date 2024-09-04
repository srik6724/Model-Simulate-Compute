package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckIncorporationConceptWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  CrossCheckIncorporationConceptWriter(int round, String team) {
    try {
      file_writer = Cross_Check_Incorporation_Concept.getFileWriter(team, round);
      CrossCheckIncorporationConceptWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckIncorporationConceptWriter.writerCreated == false) {
      System.out.println("Calling round_incorporation_concept constructor."); 
      new CrossCheckIncorporationConceptWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckIncorporationConceptWriter.writerCreated = var; 
  }
}
