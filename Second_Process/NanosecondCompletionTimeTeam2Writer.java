package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondCompletionTimeTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  NanosecondCompletionTimeTeam2Writer(String team, int module) {
    try {
      file_writer = Nanosecond_Duration.getFileWriter(team,  module);
      NanosecondCompletionTimeTeam2Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int module) {
    if(NanosecondCompletionTimeTeam2Writer.writerCreated == false) {
      System.out.println("Calling module_completion_time constrcutor");
      new NanosecondCompletionTimeTeam2Writer("t2", module);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondCompletionTimeTeam2Writer.writerCreated = var; 
  }
}
