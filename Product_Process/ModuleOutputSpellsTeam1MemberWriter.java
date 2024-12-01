package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleOutputSpellsTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleOutputSpellsTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Transducer.getFileWriter(team, memberNo, round); 
      ModuleOutputSpellsTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleOutputSpellsTeam1MemberWriter.writerCreated == false) {
      new ModuleOutputSpellsTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleOutputSpellsTeam1MemberWriter.writerCreated = var; 
  }
}
