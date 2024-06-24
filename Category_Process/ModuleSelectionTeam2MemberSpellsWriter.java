package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleSelectionTeam2MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  
  ModuleSelectionTeam2MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Selection.getFileWriter(team, memberNo, round); 
      ModuleSelectionTeam2MemberSpellsWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleSelectionTeam2MemberSpellsWriter.writerCreated == false) {
      new ModuleSelectionTeam2MemberSpellsWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleSelectionTeam2MemberSpellsWriter.writerCreated = true; 
  }
}
