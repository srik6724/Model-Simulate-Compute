package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleOrderingPlacementsTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleOrderingPlacementsTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Permutations.getFileWriter(team, memberNo, round); 
      ModuleOrderingPlacementsTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleOrderingPlacementsTeam1MemberWriter.writerCreated == false) {
      new ModuleLeftOverTeam1MemberSpellsWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleOrderingPlacementsTeam1MemberWriter.writerCreated = var; 
  }
}
