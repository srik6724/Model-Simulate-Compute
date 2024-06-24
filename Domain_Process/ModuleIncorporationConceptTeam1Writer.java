package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleIncorporationConceptTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  ModuleIncorporationConceptTeam1Writer(int round, String team) {
    try {
      file_writer = Module_Incorporation_Concept.getFileWriter(team, round);
      ModuleIncorporationConceptTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleIncorporationConceptTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_incorporation_concept constructor."); 
      new ModuleIncorporationConceptTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleIncorporationConceptTeam1Writer.writerCreated = var; 
  }
}
