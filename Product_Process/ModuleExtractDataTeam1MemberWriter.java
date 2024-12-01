package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleExtractDataTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleExtractDataTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Statistics.getFileWriter(team, memberNo, round); 
      ModuleExtractDataTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleExtractDataTeam1MemberWriter.writerCreated == false) {
      new ModuleDiscardTeam1MemberSpellsWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleExtractDataTeam1MemberWriter.writerCreated = var; 
  }
}