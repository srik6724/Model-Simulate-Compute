package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundGenerationTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  RoundGenerationTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Round_Generation.getFileWriter(team, memberNo, round); 
      RoundGenerationTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(RoundGenerationTeam2MemberWriter.writerCreated == false) {
      new RoundGenerationTeam2MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    RoundGenerationTeam2MemberWriter.writerCreated = var; 
  }
}
