package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondCombineTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  MicrosecondCombineTeam1Writer(String team, int round) {
    try {
      file_writer = Microsecond_Merge_Finalizer.getFileWriter(round, team);
      MicrosecondCombineTeam1Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondCombineTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_combine constrcutor");
      new MicrosecondCombineTeam1Writer("default", round);
    }
    return file_writer;
  }
}
