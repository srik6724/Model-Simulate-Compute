package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondGarbageCollectionTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondGarbageCollectionTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Garbage_Collector.getFileWriter(team, memberNo, round); 
      NanosecondGarbageCollectionTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondGarbageCollectionTeam1MemberWriter.writerCreated == false) {
      System.out.println("Calling round_garbage_collection constructor.");
      new NanosecondGarbageCollectionTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondGarbageCollectionTeam1MemberWriter.writerCreated = var; 
  }
}
