package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondGarbageCollectionTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondGarbageCollectionTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Garbage_Collector.getFileWriter(team, memberNo, round); 
      NanosecondGarbageCollectionTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondGarbageCollectionTeam2MemberWriter.writerCreated == false) {
      System.out.println("Calling round_garbage_collection constructor.");
      new NanosecondGarbageCollectionTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondGarbageCollectionTeam2MemberWriter.writerCreated = var; 
  }
}
