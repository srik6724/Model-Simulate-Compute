package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundContributionalEstimateWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  RoundContributionalEstimateWriter(String team, int round) {
    try {
      file_writer = Round_Relevance.getFileWriter(team, round);
      RoundContributionalEstimateWriter.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundContributionalEstimateWriter.writerCreated == false) {
      System.out.println("Calling round_contributional_estimate constrcutor");
      new RoundContributionalEstimateWriter("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundContributionalEstimateWriter.writerCreated = var; 
  }
}
