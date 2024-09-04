package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckGenerationTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckGenerationTeam1Writer(int round, String team) {
    try {
      file_writer = Cross_Check_Generation.getFileWriter(team, round);
      CrossCheckGenerationTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckGenerationTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_generation constructor.");
      new CrossCheckGenerationTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckGenerationTeam1Writer.writerCreated = var;
  }

}
