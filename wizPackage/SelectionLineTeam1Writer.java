package wizPackage;

import java.io.FileWriter;
import java.io.IOException;

class SelectionLineTeam1Writer {
    private static boolean writerCreated = false; 
    private static FileWriter file_writer; 

    SelectionLineTeam1Writer(String team, int round) {
      try {
        file_writer = Selection_Line_Path.getFileWriter(team, round); 
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    static FileWriter get_file_writer(int round) {
      if(SelectionLineTeam1Writer.writerCreated == false) {
        System.out.println("Calling selection line writer constructor."); 
        new SelectionLineTeam1Writer("t1", round); 
      }
      return file_writer; 
    }

    static void setWriterCreated(boolean var) {
      SelectionLineTeam1Writer.writerCreated = var; 
    }
}
