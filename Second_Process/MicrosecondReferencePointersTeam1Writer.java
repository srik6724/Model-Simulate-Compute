package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondReferencePointersTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondReferencePointersTeam1Writer(String team, int round) {
    try {
      file_writer = Microsecond_Simulation.getFileWriter(team, round); 
      MicrosecondReferencePointersTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondReferencePointersTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_reference_pointers constructor"); 
      new MicrosecondReferencePointersTeam1Writer("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    MicrosecondReferencePointersTeam1Writer.writerCreated = var; 
  }
}
