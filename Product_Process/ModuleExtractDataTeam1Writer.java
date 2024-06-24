package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleExtractDataTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleExtractDataTeam1Writer(int round, String team) {
    try {
      file_writer = Module_Statistics.getFileWriter(team, round);
      ModuleExtractDataTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleExtractDataTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_extract_data constructor.");
      new ModuleExtractDataTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleExtractDataTeam1Writer.writerCreated = var;
  }
}
