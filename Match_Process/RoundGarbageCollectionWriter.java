package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundGarbageCollectionWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundGarbageCollectionWriter(int round, String team) {
    try {
      file_writer = Round_Garbage_Collector.getFileWriter(team, round); 
      RoundGarbageCollectionWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundGarbageCollectionWriter.writerCreated == false) {
      System.out.println("Calling round_garbage_collection constructor.");
      new RoundGarbageCollectionWriter(round, "default");
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    RoundGarbageCollectionWriter.writerCreated = var; 
  }
}
