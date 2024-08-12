package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondGarbageCollectionTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondGarbageCollectionTeam2Writer(int round, String team) {
    try {
      file_writer = Nanosecond_Garbage_Collector.getFileWriter(team, round);
      NanosecondGarbageCollectionTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondGarbageCollectionTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_garbage_collection constructor.");
      new NanosecondGarbageCollectionTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondGarbageCollectionTeam2Writer.writerCreated = var;
  }
}
