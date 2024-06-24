package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleCheckPointWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  ModuleCheckPointWriter(String team, int round) {
    try {
      file_writer = Module_State.getFileWriter(team, round);
      ModuleCheckPointWriter.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleCheckPointWriter.writerCreated == false) {
      System.out.println("Calling round_check_point constrcutor");
      new ModuleCheckPointTeam1Writer("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleCheckPointWriter.writerCreated = var;
  }
}
