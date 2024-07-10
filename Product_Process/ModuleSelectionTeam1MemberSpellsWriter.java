package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleSelectionTeam1MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleSelectionTeam1MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Selection.getFileWriter(team, memberNo, round); 
      ModuleSelectionTeam1MemberSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleSelectionTeam1MemberSpellsWriter.writerCreated == false) {
      new ModuleSelectionTeam1MemberSpellsWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleSelectionTeam1MemberSpellsWriter.writerCreated = var; 
  }
}
