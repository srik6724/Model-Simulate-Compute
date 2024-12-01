package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleGenerationTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleGenerationTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Generation.getFileWriter(team, memberNo, round); 
      ModuleGenerationTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleGenerationTeam1MemberWriter.writerCreated == false) {
      new ModuleGenerationTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleGenerationTeam1MemberWriter.writerCreated = var; 
  }
}
