package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleLexicalAnalyzerTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  ModuleLexicalAnalyzerTeam2Writer(int round, String team) {
    try {
      file_writer = Module_Parser.getFileWriter(team, round);
      ModuleLexicalAnalyzerTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleLexicalAnalyzerTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor."); 
      new ModuleLexicalAnalyzerTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleLexicalAnalyzerTeam2Writer.writerCreated = var; 
  }
}
