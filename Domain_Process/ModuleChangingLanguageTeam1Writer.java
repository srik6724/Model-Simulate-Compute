package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleChangingLanguageTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleChangingLanguageTeam1Writer(String team, int round) {
    try {
      file_writer = Module_Dynamic_Grammar.getFileWriter(team, round);
      ModuleChangingLanguageTeam1Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleChangingLanguageTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_changing_language constructor."); 
      new ModuleChangingLanguageTeam1Writer("t1", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleChangingLanguageTeam1Writer.writerCreated = var; 
  }
}
