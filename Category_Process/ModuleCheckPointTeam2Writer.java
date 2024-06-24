package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleCheckPointTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  ModuleCheckPointTeam2Writer(String team, int round) {
    try {
      file_writer = Module_State.getFileWriter(team, round);
      ModuleCheckPointTeam2Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleCheckPointTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_check_point constrcutor");
      new ModuleCheckPointTeam1Writer("t2", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleCheckPointTeam2Writer.writerCreated = var; 
  }

}
