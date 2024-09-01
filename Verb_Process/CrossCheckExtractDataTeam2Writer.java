package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckExtractDataTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckExtractDataTeam2Writer(int round, String team) {
    try {
      file_writer = Cross_Check_Statistics.getFileWriter(team, round);
      CrossCheckExtractDataTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckExtractDataTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_extract_data constructor.");
      new CrossCheckExtractDataTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckExtractDataTeam2Writer.writerCreated = var;
  }
}
