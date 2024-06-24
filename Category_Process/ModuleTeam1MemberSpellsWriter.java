package Category_Process;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class ModuleTeam1MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];  

  ModuleTeam1MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Recorder.getFileWriter(team, memberNo, round); 
      ModuleTeam1MemberSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleTeam1MemberSpellsWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new ModuleTeam1MemberSpellsWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleTeam1MemberSpellsWriter.writerCreated = var; 
  }
}
