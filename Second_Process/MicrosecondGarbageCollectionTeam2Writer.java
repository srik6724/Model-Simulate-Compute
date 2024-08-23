package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondGarbageCollectionTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondGarbageCollectionTeam2Writer(int round, String team) {
    try {
      file_writer = Microsecond_Garbage_Collector.getFileWriter(team, round);
      MicrosecondGarbageCollectionTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondGarbageCollectionTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_garbage_collection constructor.");
      new MicrosecondGarbageCollectionTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondGarbageCollectionTeam2Writer.writerCreated = var;
  }
}
