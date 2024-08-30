package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckContributionalEstimateWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  CrossCheckContributionalEstimateWriter(String team, int round) {
    try {
      file_writer = Cross_Check_Relevance.getFileWriter(team, round);
      CrossCheckContributionalEstimateWriter.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckContributionalEstimateWriter.writerCreated == false) {
      System.out.println("Calling round_contributional_estimate constrcutor");
      new CrossCheckContributionalEstimateWriter("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckContributionalEstimateWriter.writerCreated = var; 
  }
}
