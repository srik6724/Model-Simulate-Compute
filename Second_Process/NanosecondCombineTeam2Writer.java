package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondCombineTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  NanosecondCombineTeam2Writer(String team, int round) {
    try {
      file_writer = Nanosecond_Merge_Finalizer.getFileWriter(round, team);
      NanosecondCombineTeam2Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondCombineTeam2Writer.writerCreated == false) {
      new NanosecondCombineTeam2Writer("t2", round);
    }
    return file_writer;
  }
}
