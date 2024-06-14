package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundGarbageCollectionTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundGarbageCollectionTeam2Writer(int round, String team) {
    try {
      file_writer = Round_Garbage_Collector.getFileWriter(team, round);
      RoundGarbageCollectionTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundGarbageCollectionTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_garbage_collection constructor.");
      new RoundGarbageCollectionTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundGarbageCollectionTeam2Writer.writerCreated = var;
  }
}
