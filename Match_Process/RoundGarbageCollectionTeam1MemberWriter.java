package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundGarbageCollectionTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundGarbageCollectionTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Garbage_Collector.getFileWriter(team, memberNo, round); 
      RoundGarbageCollectionTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundGarbageCollectionTeam1MemberWriter.writerCreated == false) {
      System.out.println("Calling round_garbage_collection constructor.");
      new RoundGarbageCollectionTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundGarbageCollectionTeam1MemberWriter.writerCreated = var; 
  }
}
