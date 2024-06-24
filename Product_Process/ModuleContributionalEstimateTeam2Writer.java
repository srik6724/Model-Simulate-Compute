package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleContributionalEstimateTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  ModuleContributionalEstimateTeam2Writer(String team, int round) {
    try {
      file_writer = Module_Relevance.getFileWriter(team, round);
      ModuleContributionalEstimateTeam2Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleContributionalEstimateTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_contributional_estimate constrcutor");
      new ModuleContributionalEstimateTeam1Writer("t2", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleContributionalEstimateTeam2Writer.writerCreated = var; 
  }
}
