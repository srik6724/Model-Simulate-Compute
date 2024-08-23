package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondIncorporationConceptTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  MicrosecondIncorporationConceptTeam1Writer(int round, String team) {
    try {
      file_writer = Microsecond_Incorporation_Concept.getFileWriter(team, round);
      MicrosecondIncorporationConceptTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondIncorporationConceptTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_incorporation_concept constructor."); 
      new MicrosecondIncorporationConceptTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondIncorporationConceptTeam1Writer.writerCreated = var; 
  }
}
