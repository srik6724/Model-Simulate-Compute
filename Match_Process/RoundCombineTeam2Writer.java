package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundCombineTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  RoundCombineTeam2Writer(String team, int round) {
    try {
      file_writer = Round_Merge_Finalizer.getFileWriter(round, team);
      RoundCombineTeam2Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundCombineTeam2Writer.writerCreated == false) {
      new RoundCombineWriter("t2", round);
    }
    return file_writer;
  }
}
