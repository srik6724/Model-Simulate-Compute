package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleAudienceTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleAudienceTeam1Writer(String team, int round) {
    try {
      file_writer = Module_Engagement.getFileWriter(team, round);
      ModuleAudienceTeam1Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleAudienceTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_audience constructor."); 
      new ModuleAudienceTeam1Writer("t1", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleAudienceTeam1Writer.writerCreated = var; 
  }
}
