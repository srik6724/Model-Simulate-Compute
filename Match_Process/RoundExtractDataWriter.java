package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundExtractDataWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundExtractDataWriter(int round, String team) {
    try {
      file_writer = Round_Statistics.getFileWriter(team, round);
      RoundExtractDataWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundExtractDataWriter.writerCreated == false) {
      System.out.println("Calling round_extract_data constructor.");
      new RoundExtractDataWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundExtractDataWriter.writerCreated = var;
  }
}
