package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondIncorporationConceptTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  NanosecondIncorporationConceptTeam2Writer(int round, String team) {
    try {
      file_writer = Nanosecond_Incorporation_Concept.getFileWriter(team, round);
      NanosecondIncorporationConceptTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondIncorporationConceptTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_incorporation_concept constructor."); 
      new NanosecondIncorporationConceptTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondIncorporationConceptTeam2Writer.writerCreated = var; 
  }
}
