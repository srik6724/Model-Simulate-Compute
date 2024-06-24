package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleAudienceTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleAudienceTeam2Writer(String team, int round) {
    try {
      file_writer = Module_Engagement.getFileWriter(team, round);
      ModuleAudienceTeam2Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleAudienceTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_audience constructor."); 
      new ModuleAudienceTeam2Writer("t2", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleAudienceTeam2Writer.writerCreated = var; 
  }
}
