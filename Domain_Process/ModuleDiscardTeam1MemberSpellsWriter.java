package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleDiscardTeam1MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleDiscardTeam1MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Discarder.getFileWriter(team, memberNo, round); 
      ModuleDiscardTeam1MemberSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleDiscardTeam1MemberSpellsWriter.writerCreated == false) {
      new ModuleDiscardTeam1MemberSpellsWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleDiscardTeam1MemberSpellsWriter.writerCreated = var; 
  }
}
