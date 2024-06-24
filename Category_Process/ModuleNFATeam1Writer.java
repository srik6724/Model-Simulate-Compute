package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleNFATeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleNFATeam1Writer(int round, String team) {
    try {
      file_writer = Module_NFA.getFileWriter(team, round); 
      ModuleNFATeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleNFATeam1Writer.writerCreated == false) {
      System.out.println("Calling round_nfa constructor."); 
      new ModuleNFATeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    ModuleNFATeam1Writer.writerCreated = var; 
  }
}
