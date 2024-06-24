package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleLeftOverTeam1MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleLeftOverTeam1MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Remaining.getFileWriter(team, memberNo, round); 
      ModuleLeftOverTeam1MemberSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleLeftOverTeam1MemberSpellsWriter.writerCreated == false) {
      new ModuleLeftOverTeam1MemberSpellsWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleLeftOverTeam1MemberSpellsWriter.writerCreated = var; 
  }
}
