package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondGenerationTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondGenerationTeam1Writer(int round, String team) {
    try {
      file_writer = Microsecond_Generation.getFileWriter(team, round);
      MicrosecondGenerationTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondGenerationTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_generation constructor.");
      new MicrosecondGenerationTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondGenerationTeam1Writer.writerCreated = var;
  }

}
