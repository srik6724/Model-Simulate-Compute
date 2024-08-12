package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondExtractDataTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondExtractDataTeam2Writer(int round, String team) {
    try {
      file_writer = Nanosecond_Statistics.getFileWriter(team, round);
      NanosecondExtractDataTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondExtractDataTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_extract_data constructor.");
      new NanosecondExtractDataTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondExtractDataTeam2Writer.writerCreated = var;
  }
}
