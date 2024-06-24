package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleTacticalApproachTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleTacticalApproachTeam2Writer(String team, int round) {
    try {
      file_writer = Module_Strategy.getFileWriter(team, round); 
      ModuleTacticalApproachTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleTacticalApproachTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new ModuleTacticalApproachTeam2Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    ModuleTacticalApproachTeam2Writer.writerCreated = var; 
  }
}
