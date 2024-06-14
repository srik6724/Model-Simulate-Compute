package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundExtractDataTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundExtractDataTeam1Writer(int round, String team) {
    try {
      file_writer = Round_Statistics.getFileWriter(team, round);
      RoundExtractDataTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundExtractDataTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_extract_data constructor.");
      new RoundExtractDataTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundExtractDataTeam1Writer.writerCreated = var;
  }
}
