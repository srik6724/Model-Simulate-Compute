package wizPackage;

import java.io.FileWriter;
import java.io.IOException;

class SelectionLineTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  SelectionLineTeam2Writer(String team, int round) {
    try {
      file_writer = Selection_Line_Path.getFileWriter(team, round);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(SelectionLineTeam2Writer.writerCreated == false) {
      System.out.println("Calling selection line writer constructor."); 
      new SelectionLineTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    SelectionLineTeam2Writer.writerCreated = var; 
  }
}
