package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckExtractDataWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckExtractDataWriter(int round, String team) {
    try {
      file_writer = Cross_Check_Statistics.getFileWriter(team, round);
      CrossCheckExtractDataWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckExtractDataWriter.writerCreated == false) {
      System.out.println("Calling round_extract_data constructor.");
      new CrossCheckExtractDataWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckExtractDataWriter.writerCreated = var;
  }
}
