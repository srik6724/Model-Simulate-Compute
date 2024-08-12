package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondCompletionTimeWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  NanosecondCompletionTimeWriter(String team, int module) {
    try {
      file_writer = Nanosecond_Duration.getFileWriter(team,  module);
      NanosecondCompletionTimeWriter.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int module) {
    if(NanosecondCompletionTimeWriter.writerCreated == false) {
      System.out.println("Calling module_completion_time constrcutor");
      new NanosecondCompletionTimeWriter("default", module); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondCompletionTimeWriter.writerCreated = var; 
  }
}
