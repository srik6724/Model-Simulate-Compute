package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleContributionalEstimateWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  ModuleContributionalEstimateWriter(String team, int round) {
    try {
      file_writer = Module_Relevance.getFileWriter(team, round);
      ModuleContributionalEstimateWriter.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleContributionalEstimateWriter.writerCreated == false) {
      System.out.println("Calling round_contributional_estimate constrcutor");
      new ModuleContributionalEstimateWriter("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleContributionalEstimateWriter.writerCreated = var; 
  }
}
