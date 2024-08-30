package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckCompletionTimeWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  CrossCheckCompletionTimeWriter(String team, int module) {
    try {
      file_writer = Cross_Check_Duration.getFileWriter(team,  module);
      CrossCheckCompletionTimeWriter.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int module) {
    if(CrossCheckCompletionTimeWriter.writerCreated == false) {
      System.out.println("Calling module_completion_time constrcutor");
      new CrossCheckCompletionTimeWriter("default", module); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckCompletionTimeWriter.writerCreated = var; 
  }
}
