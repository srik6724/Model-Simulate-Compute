package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class VerbCombineWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;
  
  VerbCombineWriter() {
    try {
      file_writer = Verb_Merge_Finalizer.getFileWriter(); 
      VerbCombineWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(VerbCombineWriter.writerCreated == true) {
      System.out.println("Calling domain_combine constructor."); 
      new VerbCombineWriter(); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    VerbCombineWriter.writerCreated = var;
  }
}
