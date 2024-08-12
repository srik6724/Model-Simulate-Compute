package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondCombineTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  NanosecondCombineTeam1Writer(String team, int round) {
    try {
      file_writer = Nanosecond_Merge_Finalizer.getFileWriter(round, team);
      NanosecondCombineTeam1Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondCombineTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_combine constrcutor");
      new NanosecondCombineTeam1Writer("default", round);
    }
    return file_writer;
  }
}
