package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckIncorporationConceptTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  CrossCheckIncorporationConceptTeam2Writer(int round, String team) {
    try {
      file_writer = Cross_Check_Incorporation_Concept.getFileWriter(team, round);
      CrossCheckIncorporationConceptTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckIncorporationConceptTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_incorporation_concept constructor."); 
      new CrossCheckIncorporationConceptTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckIncorporationConceptTeam2Writer.writerCreated = var; 
  }
}
