package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundContributionalEstimateTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  RoundContributionalEstimateTeam1Writer(String team, int round) {
    try {
      file_writer = Round_Relevance.getFileWriter(team, round);
      RoundContributionalEstimateTeam1Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundContributionalEstimateTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_contributional_estimate constrcutor");
      new RoundContributionalEstimateTeam1Writer("t1", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundContributionalEstimateTeam1Writer.writerCreated = var; 
  }
}
