package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleExtractDataWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleExtractDataWriter(int round, String team) {
    try {
      file_writer = Module_Statistics.getFileWriter(team, round);
      ModuleExtractDataWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleExtractDataWriter.writerCreated == false) {
      System.out.println("Calling round_extract_data constructor.");
      new ModuleExtractDataWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleExtractDataWriter.writerCreated = var;
  }
}
