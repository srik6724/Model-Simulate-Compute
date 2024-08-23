package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondIncorporationConceptTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  MicrosecondIncorporationConceptTeam2Writer(int round, String team) {
    try {
      file_writer = Microsecond_Incorporation_Concept.getFileWriter(team, round);
      MicrosecondIncorporationConceptTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondIncorporationConceptTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_incorporation_concept constructor."); 
      new MicrosecondIncorporationConceptTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondIncorporationConceptTeam2Writer.writerCreated = var; 
  }
}
