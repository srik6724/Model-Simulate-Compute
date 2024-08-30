package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckContributionalEstimateTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  CrossCheckContributionalEstimateTeam1Writer(String team, int round) {
    try {
      file_writer = Cross_Check_Relevance.getFileWriter(team, round);
      CrossCheckContributionalEstimateTeam1Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckContributionalEstimateTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_contributional_estimate constrcutor");
      new CrossCheckContributionalEstimateTeam1Writer("t1", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckContributionalEstimateTeam1Writer.writerCreated = var; 
  }
}
