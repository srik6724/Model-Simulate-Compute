package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleSelectionTeam1Writer {
    private static boolean writerCreated = false; 
    private static FileWriter file_writer; 

    ModuleSelectionTeam1Writer(String team, int round) {
      try {
        file_writer = Module_Selection.getFileWriter(team, round); 
        ModuleSelectionTeam1Writer.writerCreated = true;
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    static FileWriter get_file_writer(int round) {
      if(ModuleSelectionTeam1Writer.writerCreated == false) {
        System.out.println("Calling selection_line constructor."); 
        new ModuleSelectionTeam1Writer("t1", round); 
      }
      return file_writer; 
    }

    static void setWriterCreated(boolean var) {
      ModuleSelectionTeam1Writer.writerCreated = var; 
    }
}
