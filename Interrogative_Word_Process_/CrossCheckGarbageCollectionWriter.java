package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckGarbageCollectionWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckGarbageCollectionWriter(int round, String team) {
    try {
      file_writer = Cross_Check_Garbage_Collector.getFileWriter(team, round); 
      CrossCheckGarbageCollectionWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckGarbageCollectionWriter.writerCreated == false) {
      System.out.println("Calling round_garbage_collection constructor.");
      new CrossCheckGarbageCollectionWriter(round, "default");
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    CrossCheckGarbageCollectionWriter.writerCreated = var; 
  }
}
