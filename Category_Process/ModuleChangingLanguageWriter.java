package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleChangingLanguageWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleChangingLanguageWriter(String team, int round) {
    try {
      file_writer = Module_Dynamic_Language.getFileWriter(team, round);
      ModuleChangingLanguageWriter.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleChangingLanguageWriter.writerCreated == false) {
      System.out.println("Calling round_changing_language constructor."); 
      new ModuleChangingLanguageWriter("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleChangingLanguageWriter.writerCreated = var; 
  }
}
