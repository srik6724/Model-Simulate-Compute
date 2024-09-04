package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckGenerationTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckGenerationTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Generation.getFileWriter(team, memberNo, round); 
      CrossCheckGenerationTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckGenerationTeam2MemberWriter.writerCreated == false) {
      new CrossCheckGenerationTeam2MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckGenerationTeam2MemberWriter.writerCreated = var; 
  }
}
