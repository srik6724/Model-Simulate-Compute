package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundCombineTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  RoundCombineTeam1Writer(String team, int round) {
    try {
      file_writer = Round_Merge_Finalizer.getFileWriter(round, team);
      RoundCombineTeam1Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundCombineTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_combine constrcutor");
      new RoundCombineTeam1Writer("default", round);
    }
    return file_writer;
  }
}
