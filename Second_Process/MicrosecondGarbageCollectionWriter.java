package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondGarbageCollectionWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondGarbageCollectionWriter(int round, String team) {
    try {
      file_writer = Microsecond_Garbage_Collector.getFileWriter(team, round); 
      MicrosecondGarbageCollectionWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondGarbageCollectionWriter.writerCreated == false) {
      System.out.println("Calling round_garbage_collection constructor.");
      new MicrosecondGarbageCollectionWriter(round, "default");
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    MicrosecondGarbageCollectionWriter.writerCreated = var; 
  }
}
