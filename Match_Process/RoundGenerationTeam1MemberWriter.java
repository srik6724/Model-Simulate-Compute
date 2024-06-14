package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundGenerationTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundGenerationTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Generation.getFileWriter(team, memberNo, round); 
      RoundGenerationTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundGenerationTeam1MemberWriter.writerCreated == false) {
      new RoundGenerationTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundGenerationTeam1MemberWriter.writerCreated = var; 
  }
}
