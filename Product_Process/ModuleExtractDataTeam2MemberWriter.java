package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleExtractDataTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleExtractDataTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Statistics.getFileWriter(team, memberNo, round); 
      ModuleExtractDataTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleExtractDataTeam2MemberWriter.writerCreated == false) {
      new ModuleExtractDataTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleExtractDataTeam2MemberWriter.writerCreated = var; 
  }
}
