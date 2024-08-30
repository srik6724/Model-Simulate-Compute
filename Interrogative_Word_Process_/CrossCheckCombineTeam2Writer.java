package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckCombineTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  CrossCheckCombineTeam2Writer(String team, int round) {
    try {
      file_writer = Cross_Check_Merge_Finalizer.getFileWriter(round, team);
      CrossCheckCombineTeam2Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckCombineTeam2Writer.writerCreated == false) {
      new CrossCheckCombineWriter("t2", round);
    }
    return file_writer;
  }
}
