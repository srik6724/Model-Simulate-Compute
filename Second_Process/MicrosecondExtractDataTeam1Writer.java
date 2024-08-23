package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondExtractDataTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondExtractDataTeam1Writer(int round, String team) {
    try {
      file_writer = Microsecond_Statistics.getFileWriter(team, round);
      MicrosecondExtractDataTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondExtractDataTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_extract_data constructor.");
      new MicrosecondExtractDataTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondExtractDataTeam1Writer.writerCreated = var;
  }
}
