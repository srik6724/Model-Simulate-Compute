package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleGenerationTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleGenerationTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Generation.getFileWriter(team, memberNo, round); 
      ModuleGenerationTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleGenerationTeam2MemberWriter.writerCreated == false) {
      new ModuleGenerationTeam2MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleGenerationTeam2MemberWriter.writerCreated = var; 
  }
}
