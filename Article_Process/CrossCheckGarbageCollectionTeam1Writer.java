package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckGarbageCollectionTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckGarbageCollectionTeam1Writer(int round, String team) {
    try {
      file_writer = Cross_Check_Garbage_Collector.getFileWriter(team, round);
      CrossCheckGarbageCollectionTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckGarbageCollectionTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_garbage_collection constructor.");
      new CrossCheckGarbageCollectionTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckGarbageCollectionTeam1Writer.writerCreated = var;
  }
}
