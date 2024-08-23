package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondExtractDataTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondExtractDataTeam2Writer(int round, String team) {
    try {
      file_writer = Microsecond_Statistics.getFileWriter(team, round);
      MicrosecondExtractDataTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondExtractDataTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_extract_data constructor.");
      new MicrosecondExtractDataTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondExtractDataTeam2Writer.writerCreated = var;
  }
}
