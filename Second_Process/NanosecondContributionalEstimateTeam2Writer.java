package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondContributionalEstimateTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  NanosecondContributionalEstimateTeam2Writer(String team, int round) {
    try {
      file_writer = Nanosecond_Relevance.getFileWriter(team, round);
      NanosecondContributionalEstimateTeam2Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondContributionalEstimateTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_contributional_estimate constrcutor");
      new NanosecondContributionalEstimateTeam1Writer("t2", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondContributionalEstimateTeam2Writer.writerCreated = var; 
  }
}
