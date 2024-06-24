package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleNFAWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleNFAWriter(int round, String team) {
    try {
      file_writer = Module_NFA.getFileWriter(team, round); 
      ModuleNFAWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleNFAWriter.writerCreated == false) {
      System.out.println("Calling round_nfa constructor."); 
      new ModuleNFAWriter(round, "default"); 
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    ModuleNFAWriter.writerCreated = var; 
  }
}
