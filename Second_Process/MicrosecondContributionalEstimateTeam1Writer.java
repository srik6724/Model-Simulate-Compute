package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondContributionalEstimateTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  MicrosecondContributionalEstimateTeam1Writer(String team, int round) {
    try {
      file_writer = Microsecond_Relevance.getFileWriter(team, round);
      MicrosecondContributionalEstimateTeam1Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondContributionalEstimateTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_contributional_estimate constrcutor");
      new MicrosecondContributionalEstimateTeam1Writer("t1", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondContributionalEstimateTeam1Writer.writerCreated = var; 
  }
}
