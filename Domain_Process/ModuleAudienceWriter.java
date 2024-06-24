package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleAudienceWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleAudienceWriter(String team, int round) {
    try {
      file_writer = Module_Engagement.getFileWriter(team, round);
      ModuleAudienceWriter.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleAudienceWriter.writerCreated == false) {
      System.out.println("Calling round_audience constructor."); 
      new ModuleAudienceWriter("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleAudienceWriter.writerCreated = var; 
  }
}
