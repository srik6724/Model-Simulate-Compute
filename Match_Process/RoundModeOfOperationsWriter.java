package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundModeOfOperationsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundModeOfOperationsWriter(int round, String team) {
    try {
      file_writer = Round_Hierarchy.getFileWriter(team, round);
      RoundModeOfOperationsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundModeOfOperationsWriter.writerCreated == false) {
      System.out.println("Calling round_mode_of_operations constructor."); 
      new RoundModeOfOperationsWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundModeOfOperationsWriter.writerCreated = var; 
  }
}
