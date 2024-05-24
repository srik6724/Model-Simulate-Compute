package wizPackage;

import java.io.FileWriter;
import java.io.IOException;

class RoundSelectionLineTeam1Writer {
    private static boolean writerCreated = false; 
    private static FileWriter file_writer; 

    RoundSelectionLineTeam1Writer(String team, int round) {
      try {
        file_writer = Round_Selection_Line_Path.getFileWriter(team, round); 
        RoundSelectionLineTeam1Writer.writerCreated = true;
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    static FileWriter get_file_writer(int round) {
      if(RoundSelectionLineTeam1Writer.writerCreated == false) {
        System.out.println("Calling selection_line constructor."); 
        new RoundSelectionLineTeam1Writer("t1", round); 
      }
      return file_writer; 
    }

    static void setWriterCreated(boolean var) {
      RoundSelectionLineTeam1Writer.writerCreated = var; 
    }
}
