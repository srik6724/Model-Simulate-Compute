package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleStaticLanguageTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleStaticLanguageTeam2Writer(String team, int round) {
    try {
      file_writer = Microsecond_Fixed_Language.getFileWriter(team, round); 
      ModuleStaticLanguageTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleStaticLanguageTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new ModuleStaticLanguageTeam2Writer("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    ModuleStaticLanguageTeam2Writer.writerCreated = var; 
  }
}
