package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleStaticLanguageTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleStaticLanguageTeam1Writer(String team, int round) {
    try {
      file_writer = Module_Strategy.getFileWriter(team, round); 
      ModuleStaticLanguageTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleStaticLanguageTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new ModuleStaticLanguageTeam1Writer("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    ModuleStaticLanguageTeam1Writer.writerCreated = var; 
  }
}
