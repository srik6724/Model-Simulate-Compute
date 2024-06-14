package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundExtractDataTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundExtractDataTeam2Writer(int round, String team) {
    try {
      file_writer = Round_Statistics.getFileWriter(team, round);
      RoundExtractDataTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundExtractDataTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_extract_data constructor.");
      new RoundExtractDataTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundExtractDataTeam2Writer.writerCreated = var;
  }
}
