package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondGarbageCollectionTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondGarbageCollectionTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Garbage_Collector.getFileWriter(team, memberNo, round); 
      MicrosecondGarbageCollectionTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondGarbageCollectionTeam2MemberWriter.writerCreated == false) {
      System.out.println("Calling round_garbage_collection constructor.");
      new MicrosecondGarbageCollectionTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondGarbageCollectionTeam2MemberWriter.writerCreated = var; 
  }
}
