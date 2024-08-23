package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondIncorporationConceptWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  MicrosecondIncorporationConceptWriter(int round, String team) {
    try {
      file_writer = Microsecond_Incorporation_Concept.getFileWriter(team, round);
      MicrosecondIncorporationConceptWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondIncorporationConceptWriter.writerCreated == false) {
      System.out.println("Calling round_incorporation_concept constructor."); 
      new MicrosecondIncorporationConceptWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondIncorporationConceptWriter.writerCreated = var; 
  }
}
