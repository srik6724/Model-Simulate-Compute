package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondSelectionTeam1Writer {
    private static boolean writerCreated = false; 
    private static FileWriter file_writer; 

    MicrosecondSelectionTeam1Writer(String team, int round) {
      try {
        file_writer = Microsecond_Selection.getFileWriter(team, round); 
        MicrosecondSelectionTeam1Writer.writerCreated = true;
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    static FileWriter get_file_writer(int round) {
      if(MicrosecondSelectionTeam1Writer.writerCreated == false) {
        System.out.println("Calling selection_line constructor."); 
        new MicrosecondSelectionTeam1Writer("t1", round); 
      }
      return file_writer; 
    }

    static void setWriterCreated(boolean var) {
      MicrosecondSelectionTeam1Writer.writerCreated = var; 
    }
}
