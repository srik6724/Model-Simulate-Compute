package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondIncorporationConceptTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  NanosecondIncorporationConceptTeam1Writer(int round, String team) {
    try {
      file_writer = Nanosecond_Incorporation_Concept.getFileWriter(team, round);
      NanosecondIncorporationConceptTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondIncorporationConceptTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_incorporation_concept constructor."); 
      new NanosecondIncorporationConceptTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondIncorporationConceptTeam1Writer.writerCreated = var; 
  }
}
