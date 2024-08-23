package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondGenerationTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondGenerationTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Generation.getFileWriter(team, memberNo, round); 
      MicrosecondGenerationTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondGenerationTeam1MemberWriter.writerCreated == false) {
      new MicrosecondGenerationTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondGenerationTeam1MemberWriter.writerCreated = var; 
  }
}
