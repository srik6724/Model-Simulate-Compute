package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondGarbageCollectionTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondGarbageCollectionTeam1Writer(int round, String team) {
    try {
      file_writer = Nanosecond_Garbage_Collector.getFileWriter(team, round);
      NanosecondGarbageCollectionTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondGarbageCollectionTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_garbage_collection constructor.");
      new NanosecondGarbageCollectionTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondGarbageCollectionTeam1Writer.writerCreated = var;
  }
}
