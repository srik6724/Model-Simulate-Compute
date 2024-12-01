package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleStaticLanguageWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleStaticLanguageWriter(String team, int round) {
    try {
      file_writer = Module_Strategy.getFileWriter(team, round); 
      ModuleStaticLanguageWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleStaticLanguageWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new ModuleStaticLanguageWriter("default", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    ModuleStaticLanguageWriter.writerCreated = var; 
  }
}
