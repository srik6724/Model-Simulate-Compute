package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckGarbageCollectionTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckGarbageCollectionTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Garbage_Collector.getFileWriter(team, memberNo, round); 
      CrossCheckGarbageCollectionTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckGarbageCollectionTeam1MemberWriter.writerCreated == false) {
      System.out.println("Calling round_garbage_collection constructor.");
      new CrossCheckGarbageCollectionTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckGarbageCollectionTeam1MemberWriter.writerCreated = var; 
  }
}
