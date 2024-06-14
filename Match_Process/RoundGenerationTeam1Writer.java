package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundGenerationTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundGenerationTeam1Writer(int round, String team) {
    try {
      file_writer = Round_Generation.getFileWriter(team, round);
      RoundGenerationTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundGenerationTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_generation constructor.");
      new RoundGenerationTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundGenerationTeam1Writer.writerCreated = var;
  }

}
