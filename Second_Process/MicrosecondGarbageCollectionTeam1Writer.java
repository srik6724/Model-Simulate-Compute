package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondGarbageCollectionTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondGarbageCollectionTeam1Writer(int round, String team) {
    try {
      file_writer = Microsecond_Garbage_Collector.getFileWriter(team, round);
      MicrosecondGarbageCollectionTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondGarbageCollectionTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_garbage_collection constructor.");
      new MicrosecondGarbageCollectionTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondGarbageCollectionTeam1Writer.writerCreated = var;
  }
}
