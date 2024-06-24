package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleCheckPointTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  ModuleCheckPointTeam1Writer(String team, int round) {
    try {
      file_writer = Module_State.getFileWriter(team, round);
      ModuleCheckPointTeam1Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleCheckPointTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_check_point constrcutor");
      new ModuleCheckPointTeam1Writer("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleCheckPointTeam1Writer.writerCreated = var; 
  }
}
