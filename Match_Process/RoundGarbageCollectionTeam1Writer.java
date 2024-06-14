package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundGarbageCollectionTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundGarbageCollectionTeam1Writer(int round, String team) {
    try {
      file_writer = Round_Garbage_Collector.getFileWriter(team, round);
      RoundGarbageCollectionTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundGarbageCollectionTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_garbage_collection constructor.");
      new RoundGarbageCollectionTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundGarbageCollectionTeam1Writer.writerCreated = var;
  }
}
