package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleLexicalAnalyzerTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  ModuleLexicalAnalyzerTeam1Writer(int round, String team) {
    try {
      file_writer = Module_Parser.getFileWriter(team, round);
      ModuleLexicalAnalyzerTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleLexicalAnalyzerTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor."); 
      new ModuleLexicalAnalyzerTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleLexicalAnalyzerTeam1Writer.writerCreated = var; 
  }
}
