package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondExtractDataTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondExtractDataTeam1Writer(int round, String team) {
    try {
      file_writer = Nanosecond_Statistics.getFileWriter(team, round);
      NanosecondExtractDataTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondExtractDataTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_extract_data constructor.");
      new NanosecondExtractDataTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondExtractDataTeam1Writer.writerCreated = var;
  }
}
