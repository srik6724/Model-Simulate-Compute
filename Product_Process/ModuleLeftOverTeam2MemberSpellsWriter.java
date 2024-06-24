package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleLeftOverTeam2MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleLeftOverTeam2MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Remaining.getFileWriter(team, memberNo, round); 
      ModuleLeftOverTeam2MemberSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleLeftOverTeam2MemberSpellsWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor."); 
      new ModuleLeftOverTeam2MemberSpellsWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleLeftOverTeam2MemberSpellsWriter.writerCreated = var; 
  }
}
