package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleByModuleWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleByModuleWriter() {
    try {
      file_writer = Domain_Recorder.getFileWriter(); 
      ModuleByModuleWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(ModuleByModuleWriter.writerCreated == false) {
      System.out.println("Calling match_writer constructor."); 
      new ModuleByModuleWriter(); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean val) {
    ModuleByModuleWriter.writerCreated = val; 
  }

}
