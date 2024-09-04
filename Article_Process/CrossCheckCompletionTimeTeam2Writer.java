package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckCompletionTimeTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  CrossCheckCompletionTimeTeam2Writer(String team, int module) {
    try {
      file_writer = Cross_Check_Duration.getFileWriter(team,  module);
      CrossCheckCompletionTimeTeam2Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int module) {
    if(CrossCheckCompletionTimeTeam2Writer.writerCreated == false) {
      System.out.println("Calling module_completion_time constrcutor");
      new CrossCheckCompletionTimeTeam2Writer("t2", module);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckCompletionTimeTeam2Writer.writerCreated = var; 
  }
}
