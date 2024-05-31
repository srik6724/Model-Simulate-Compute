package wizPackage;

import java.io.FileWriter;
import java.io.IOException;

class RoundCombineWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundCombineWriter(int round) {
    try {
      file_writer = Round_Merge_Finalizer.getFileWriter(round);
      RoundCombineWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundCombineWriter.writerCreated == false) {
      System.out.println("Calling round_combine constructor."); 
      new RoundCombineWriter(round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundCombineWriter.writerCreated = var; 
  }
}
