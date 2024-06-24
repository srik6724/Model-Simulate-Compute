package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleLexicalAnalyzerWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  ModuleLexicalAnalyzerWriter(int round, String team) {
    try {
      file_writer = Module_Parser.getFileWriter(team, round);
      ModuleLexicalAnalyzerWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleLexicalAnalyzerWriter.writerCreated == false) {
      System.out.println("Calling round_lexical_analyzer constructor."); 
      new ModuleLexicalAnalyzerTeam1Writer(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleLexicalAnalyzerWriter.writerCreated = var; 
  }
}
