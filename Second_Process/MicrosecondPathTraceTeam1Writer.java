package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondPathTraceTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  MicrosecondPathTraceTeam1Writer(String team, int round) {
    try {
      file_writer = Microsecond_Induce.getFileWriter(team, round); 
      MicrosecondPathTraceTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondPathTraceTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_path_trace constructor"); 
      new MicrosecondPathTraceTeam1Writer("t1", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondPathTraceTeam1Writer.writerCreated = var; 
  }
}
