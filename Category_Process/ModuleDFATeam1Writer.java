package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleDFATeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleDFATeam1Writer(String team, int round) {
    try {
      file_writer = Module_DFA.getFileWriter(team, round);
      ModuleDFATeam1Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleDFATeam1Writer.writerCreated == false) {
      System.out.println("Calling round_combine constructor."); 
      new ModuleDFATeam1Writer("t1", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) { 
    ModuleDFATeam1Writer.writerCreated = var; 
  }
}
