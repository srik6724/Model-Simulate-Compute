package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleCombineWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleCombineWriter(String team, int round) {
    try {
      file_writer = Module_Merge_Finalizer.getFileWriter(round, team);
      ModuleCombineWriter.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleCombineWriter.writerCreated == false) {
      System.out.println("Calling round_combine constructor."); 
      new ModuleCombineWriter("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleCombineWriter.writerCreated = var; 
  }
}
