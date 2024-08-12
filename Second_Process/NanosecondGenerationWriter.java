package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondGenerationWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  NanosecondGenerationWriter(int round, String team) {
    try {
      file_writer = Nanosecond_Generation.getFileWriter(team, round);
      NanosecondGenerationWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondGenerationWriter.writerCreated == false) {
      System.out.println("Calling round_generation constructor."); 
      new NanosecondGenerationWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondGenerationWriter.writerCreated = var; 
  }
}
