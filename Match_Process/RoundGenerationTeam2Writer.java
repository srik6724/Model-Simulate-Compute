package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundGenerationTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundGenerationTeam2Writer(int round, String team) {
    try {
      file_writer = Round_Generation.getFileWriter(team, round);
      RoundGenerationTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundGenerationTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_generation constructor.");
      new RoundGenerationTeam2Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundGenerationTeam2Writer.writerCreated = var;
  }
}
