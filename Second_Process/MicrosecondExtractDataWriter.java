package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondExtractDataWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondExtractDataWriter(int round, String team) {
    try {
      file_writer = Microsecond_Statistics.getFileWriter(team, round);
      MicrosecondExtractDataWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondExtractDataWriter.writerCreated == false) {
      System.out.println("Calling round_extract_data constructor.");
      new MicrosecondExtractDataWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondExtractDataWriter.writerCreated = var;
  }
}
