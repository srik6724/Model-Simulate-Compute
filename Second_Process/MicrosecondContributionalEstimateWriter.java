package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondContributionalEstimateWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  MicrosecondContributionalEstimateWriter(String team, int round) {
    try {
      file_writer = Microsecond_Relevance.getFileWriter(team, round);
      MicrosecondContributionalEstimateWriter.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondContributionalEstimateWriter.writerCreated == false) {
      System.out.println("Calling round_contributional_estimate constrcutor");
      new MicrosecondContributionalEstimateWriter("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondContributionalEstimateWriter.writerCreated = var; 
  }
}
