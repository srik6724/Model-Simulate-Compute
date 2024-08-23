package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondCompletionTimeWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  MicrosecondCompletionTimeWriter(String team, int module) {
    try {
      file_writer = Microsecond_Duration.getFileWriter(team,  module);
      MicrosecondCompletionTimeWriter.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int module) {
    if(MicrosecondCompletionTimeWriter.writerCreated == false) {
      System.out.println("Calling module_completion_time constrcutor");
      new MicrosecondCompletionTimeWriter("default", module); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondCompletionTimeWriter.writerCreated = var; 
  }
}
