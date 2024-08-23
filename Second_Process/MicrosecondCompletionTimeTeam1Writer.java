package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondCompletionTimeTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  MicrosecondCompletionTimeTeam1Writer(String team, int module) {
    try {
      file_writer = Microsecond_Duration.getFileWriter(team,  module);
      MicrosecondCompletionTimeTeam1Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int module) {
    if(MicrosecondCompletionTimeTeam1Writer.writerCreated == false) {
      System.out.println("Calling module_completion_time constrcutor");
      new MicrosecondCompletionTimeTeam1Writer("t1", module);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondCompletionTimeTeam1Writer.writerCreated = var; 
  }
}
