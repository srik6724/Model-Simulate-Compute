package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundGenerationWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  RoundGenerationWriter(int round, String team) {
    try {
      file_writer = Round_Generation.getFileWriter(team, round);
      RoundGenerationWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundGenerationWriter.writerCreated == false) {
      System.out.println("Calling round_generation constructor."); 
      new RoundGenerationWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundGenerationWriter.writerCreated = var; 
  }
}
