package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleSatisfierTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleSatisfierTeam2Writer(String team, int round) {
    try {
      file_writer = Module_Solution.getFileWriter(team, round); 
      ModuleSatisfierTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleSatisfierTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_satisfier constructor"); 
      new ModuleSatisfierTeam1Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    ModuleSatisfierTeam2Writer.writerCreated = var; 
  }
}
