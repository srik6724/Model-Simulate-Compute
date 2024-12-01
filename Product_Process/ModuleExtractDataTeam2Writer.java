package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleExtractDataTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleExtractDataTeam2Writer(int round, String team) {
    try {
      file_writer = Module_Statistics.getFileWriter(team, round);
      ModuleExtractDataTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleExtractDataTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_extract_data constructor.");
      new ModuleExtractDataTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleExtractDataTeam2Writer.writerCreated = var;
  }
}
