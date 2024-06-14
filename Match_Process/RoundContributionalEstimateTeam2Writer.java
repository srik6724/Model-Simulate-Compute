package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundContributionalEstimateTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  RoundContributionalEstimateTeam2Writer(String team, int round) {
    try {
      file_writer = Round_Relevance.getFileWriter(team, round);
      RoundContributionalEstimateTeam2Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundContributionalEstimateTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_contributional_estimate constrcutor");
      new RoundContributionalEstimateTeam1Writer("t2", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundContributionalEstimateTeam2Writer.writerCreated = var; 
  }
}
