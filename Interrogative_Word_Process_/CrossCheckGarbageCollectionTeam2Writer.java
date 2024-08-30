package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckGarbageCollectionTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckGarbageCollectionTeam2Writer(int round, String team) {
    try {
      file_writer = Cross_Check_Garbage_Collector.getFileWriter(team, round);
      CrossCheckGarbageCollectionTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckGarbageCollectionTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_garbage_collection constructor.");
      new CrossCheckGarbageCollectionTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckGarbageCollectionTeam2Writer.writerCreated = var;
  }
}
