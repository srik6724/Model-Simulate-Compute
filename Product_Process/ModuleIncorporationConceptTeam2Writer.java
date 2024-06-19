package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleIncorporationConceptTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  ModuleIncorporationConceptTeam2Writer(int round, String team) {
    try {
      file_writer = Module_Incorporation_Concept.getFileWriter(team, round);
      ModuleIncorporationConceptTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleIncorporationConceptTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_incorporation_concept constructor."); 
      new ModuleIncorporationConceptTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleIncorporationConceptTeam2Writer.writerCreated = var; 
  }
}
