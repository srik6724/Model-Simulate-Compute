package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleNFATeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleNFATeam2Writer(int round, String team) {
    try {
      file_writer = Module_NFA.getFileWriter(team, round); 
      ModuleNFATeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleNFATeam2Writer.writerCreated == false) {
      System.out.println("Calling round_nfa constructor."); 
      new ModuleNFATeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    ModuleNFATeam2Writer.writerCreated = var; 
  }
}
