package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundGarbageCollectionTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundGarbageCollectionTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Garbage_Collector.getFileWriter(team, memberNo, round); 
      RoundGarbageCollectionTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundGarbageCollectionTeam2MemberWriter.writerCreated == false) {
      System.out.println("Calling round_garbage_collection constructor.");
      new RoundGarbageCollectionTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundGarbageCollectionTeam2MemberWriter.writerCreated = var; 
  }
}
