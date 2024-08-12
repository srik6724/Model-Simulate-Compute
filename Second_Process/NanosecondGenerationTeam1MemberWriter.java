package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondGenerationTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondGenerationTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Generation.getFileWriter(team, memberNo, round); 
      NanosecondGenerationTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondGenerationTeam1MemberWriter.writerCreated == false) {
      new NanosecondGenerationTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondGenerationTeam1MemberWriter.writerCreated = var; 
  }
}
