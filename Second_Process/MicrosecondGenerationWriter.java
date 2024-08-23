package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondGenerationWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  MicrosecondGenerationWriter(int round, String team) {
    try {
      file_writer = Microsecond_Generation.getFileWriter(team, round);
      MicrosecondGenerationWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondGenerationWriter.writerCreated == false) {
      System.out.println("Calling round_generation constructor."); 
      new MicrosecondGenerationWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondGenerationWriter.writerCreated = var; 
  }
}
