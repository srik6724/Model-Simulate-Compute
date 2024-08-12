package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondGarbageCollectionWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondGarbageCollectionWriter(int round, String team) {
    try {
      file_writer = Nanosecond_Garbage_Collector.getFileWriter(team, round); 
      NanosecondGarbageCollectionWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondGarbageCollectionWriter.writerCreated == false) {
      System.out.println("Calling round_garbage_collection constructor.");
      new NanosecondGarbageCollectionWriter(round, "default");
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    NanosecondGarbageCollectionWriter.writerCreated = var; 
  }
}
