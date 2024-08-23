package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondCombineTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  MicrosecondCombineTeam2Writer(String team, int round) {
    try {
      file_writer = Microsecond_Merge_Finalizer.getFileWriter(round, team);
      MicrosecondCombineTeam2Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondCombineTeam2Writer.writerCreated == false) {
      new MicrosecondCombineTeam2Writer("t2", round);
    }
    return file_writer;
  }
}
