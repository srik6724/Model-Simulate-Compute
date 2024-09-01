package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckCombineTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  CrossCheckCombineTeam1Writer(String team, int round) {
    try {
      file_writer = Cross_Check_Merge_Finalizer.getFileWriter(round, team);
      CrossCheckCombineTeam1Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckCombineTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_combine constrcutor");
      new CrossCheckCombineTeam1Writer("default", round);
    }
    return file_writer;
  }
}
