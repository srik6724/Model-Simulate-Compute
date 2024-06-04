package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundSelectionTeam1Writer {
    private static boolean writerCreated = false; 
    private static FileWriter file_writer; 

    RoundSelectionTeam1Writer(String team, int round) {
      try {
        file_writer = Round_Selection.getFileWriter(team, round); 
        RoundSelectionTeam1Writer.writerCreated = true;
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    static FileWriter get_file_writer(int round) {
      if(RoundSelectionTeam1Writer.writerCreated == false) {
        System.out.println("Calling selection_line constructor."); 
        new RoundSelectionTeam1Writer("t1", round); 
      }
      return file_writer; 
    }

    static void setWriterCreated(boolean var) {
      RoundSelectionTeam1Writer.writerCreated = var; 
    }
}
