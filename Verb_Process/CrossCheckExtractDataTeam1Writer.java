package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckExtractDataTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckExtractDataTeam1Writer(int round, String team) {
    try {
      file_writer = Cross_Check_Statistics.getFileWriter(team, round);
      CrossCheckExtractDataTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckExtractDataTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_extract_data constructor.");
      new CrossCheckExtractDataTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckExtractDataTeam1Writer.writerCreated = var;
  }
}
