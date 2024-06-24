package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleDiscardTeam2MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleDiscardTeam2MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Discarder.getFileWriter(team, memberNo, round); 
      ModuleDiscardTeam2MemberSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleDiscardTeam2MemberSpellsWriter.writerCreated == false) {
      new ModuleDiscardTeam2MemberSpellsWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleDiscardTeam2MemberSpellsWriter.writerCreated = var; 
  }
}
