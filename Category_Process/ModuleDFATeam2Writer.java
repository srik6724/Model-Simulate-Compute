package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleDFATeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleDFATeam2Writer(String team, int round) {
    try {
      file_writer = Module_DFA.getFileWriter(team, round);
      ModuleDFATeam2Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleDFATeam2Writer.writerCreated == false) {
      System.out.println("Calling round_dfa constructor."); 
      new ModuleDFATeam1Writer("t2", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) { 
    ModuleDFATeam2Writer.writerCreated = var; 
  }
}
