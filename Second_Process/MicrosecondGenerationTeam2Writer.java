package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondGenerationTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondGenerationTeam2Writer(int round, String team) {
    try {
      file_writer = Microsecond_Generation.getFileWriter(team, round);
      MicrosecondGenerationTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondGenerationTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_generation constructor.");
      new MicrosecondGenerationTeam2Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondGenerationTeam2Writer.writerCreated = var;
  }
}
