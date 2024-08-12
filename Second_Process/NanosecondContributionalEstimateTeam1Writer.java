package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondContributionalEstimateTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  NanosecondContributionalEstimateTeam1Writer(String team, int round) {
    try {
      file_writer = Nanosecond_Relevance.getFileWriter(team, round);
      NanosecondContributionalEstimateTeam1Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondContributionalEstimateTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_contributional_estimate constrcutor");
      new NanosecondContributionalEstimateTeam1Writer("t1", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondContributionalEstimateTeam1Writer.writerCreated = var; 
  }
}
