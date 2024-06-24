package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleIncorporationConceptWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  ModuleIncorporationConceptWriter(int round, String team) {
    try {
      file_writer = Module_Incorporation_Concept.getFileWriter(team, round);
      ModuleIncorporationConceptWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleIncorporationConceptWriter.writerCreated == false) {
      System.out.println("Calling round_incorporation_concept constructor."); 
      new ModuleIncorporationConceptWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleIncorporationConceptWriter.writerCreated = var; 
  }
}
