package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleCombineTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  ModuleCombineTeam2Writer(String team, int round) {
    try {
      file_writer = Module_Merge_Finalizer.getFileWriter(round, team);
      ModuleCombineTeam2Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleCombineTeam2Writer.writerCreated == false) {
      new ModuleCombineWriter("t2", round);
    }
    return file_writer;
  }
}
