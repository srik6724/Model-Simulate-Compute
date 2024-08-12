package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondContributionalEstimateWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  NanosecondContributionalEstimateWriter(String team, int round) {
    try {
      file_writer = Nanosecond_Relevance.getFileWriter(team, round);
      NanosecondContributionalEstimateWriter.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondContributionalEstimateWriter.writerCreated == false) {
      System.out.println("Calling round_contributional_estimate constrcutor");
      new NanosecondContributionalEstimateWriter("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondContributionalEstimateWriter.writerCreated = var; 
  }
}
