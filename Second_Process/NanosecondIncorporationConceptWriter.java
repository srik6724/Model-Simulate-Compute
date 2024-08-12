package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondIncorporationConceptWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  NanosecondIncorporationConceptWriter(int round, String team) {
    try {
      file_writer = Nanosecond_Incorporation_Concept.getFileWriter(team, round);
      NanosecondIncorporationConceptWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondIncorporationConceptWriter.writerCreated == false) {
      System.out.println("Calling round_incorporation_concept constructor."); 
      new NanosecondIncorporationConceptWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondIncorporationConceptWriter.writerCreated = var; 
  }
}
