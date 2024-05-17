package wizPackage;

import java.io.FileWriter;
import java.io.IOException;

class SelectionLineWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  SelectionLineWriter(String team, int round) {
    try {
      file_writer = Selection_Line_Path.getFileWriter(team, round); 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(SelectionLineWriter.writerCreated == false) {
      System.out.println("Calling selection_line_writer constructor.");
      new SelectionLineWriter("default", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    SelectionLineWriter.writerCreated = var; 
  }
}
