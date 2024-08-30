package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckGarbageCollectionTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckGarbageCollectionTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Garbage_Collector.getFileWriter(team, memberNo, round); 
      CrossCheckGarbageCollectionTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckGarbageCollectionTeam2MemberWriter.writerCreated == false) {
      System.out.println("Calling round_garbage_collection constructor.");
      new CrossCheckGarbageCollectionTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckGarbageCollectionTeam2MemberWriter.writerCreated = var; 
  }
}
