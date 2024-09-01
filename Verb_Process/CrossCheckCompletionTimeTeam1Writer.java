package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckCompletionTimeTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  CrossCheckCompletionTimeTeam1Writer(String team, int module) {
    try {
      file_writer = Cross_Check_Duration.getFileWriter(team,  module);
      CrossCheckCompletionTimeTeam1Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int module) {
    if(CrossCheckCompletionTimeTeam1Writer.writerCreated == false) {
      System.out.println("Calling module_completion_time constrcutor");
      new CrossCheckCompletionTimeTeam1Writer("t1", module);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckCompletionTimeTeam1Writer.writerCreated = var; 
  }
}
