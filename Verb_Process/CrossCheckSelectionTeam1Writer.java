package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckSelectionTeam1Writer {
    private static boolean writerCreated = false; 
    private static FileWriter file_writer; 

    CrossCheckSelectionTeam1Writer(String team, int round) {
      try {
        file_writer = Cross_Check_Selection.getFileWriter(team, round); 
        CrossCheckSelectionTeam1Writer.writerCreated = true;
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    static FileWriter get_file_writer(int round) {
      if(CrossCheckSelectionTeam1Writer.writerCreated == false) {
        System.out.println("Calling selection_line constructor."); 
        new CrossCheckSelectionTeam1Writer("t1", round); 
      }
      return file_writer; 
    }

    static void setWriterCreated(boolean var) {
      CrossCheckSelectionTeam1Writer.writerCreated = var; 
    }
}
