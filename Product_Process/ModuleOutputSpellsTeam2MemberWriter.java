package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleOutputSpellsTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleOutputSpellsTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Transducer.getFileWriter(team, memberNo, round); 
      ModuleOutputSpellsTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleOutputSpellsTeam2MemberWriter.writerCreated == false) {
      new ModuleOutputSpellsTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleOutputSpellsTeam2MemberWriter.writerCreated = var; 
  }
}
