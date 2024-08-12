package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondExtractDataWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondExtractDataWriter(int round, String team) {
    try {
      file_writer = Nanosecond_Statistics.getFileWriter(team, round);
      NanosecondExtractDataWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondExtractDataWriter.writerCreated == false) {
      System.out.println("Calling round_extract_data constructor.");
      new NanosecondExtractDataWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondExtractDataWriter.writerCreated = var;
  }
}
