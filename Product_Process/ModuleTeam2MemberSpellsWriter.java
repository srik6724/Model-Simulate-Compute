package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleTeam2MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];

  ModuleTeam2MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Recorder.getFileWriter(team, memberNo, round); 
      ModuleTeam2MemberSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleTeam2MemberSpellsWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor."); 
      new ModuleTeam2MemberSpellsWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleTeam2MemberSpellsWriter.writerCreated = var; 
  }
}
