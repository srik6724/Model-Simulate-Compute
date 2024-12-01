package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleCombineTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  ModuleCombineTeam1Writer(String team, int round) {
    try {
      file_writer = Module_Merge_Finalizer.getFileWriter(round, team);
      ModuleCombineTeam1Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleCombineTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_combine constrcutor");
      new ModuleCombineTeam1Writer("default", round);
    }
    return file_writer;
  }
}
