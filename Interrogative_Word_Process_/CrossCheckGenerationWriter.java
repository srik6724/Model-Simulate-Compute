package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckGenerationWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  CrossCheckGenerationWriter(int round, String team) {
    try {
      file_writer = Cross_Check_Generation.getFileWriter(team, round);
      CrossCheckGenerationWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckGenerationWriter.writerCreated == false) {
      System.out.println("Calling round_generation constructor."); 
      new CrossCheckGenerationWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckGenerationWriter.writerCreated = var; 
  }
}
