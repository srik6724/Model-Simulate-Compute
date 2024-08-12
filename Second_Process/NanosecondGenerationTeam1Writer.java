package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondGenerationTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondGenerationTeam1Writer(int round, String team) {
    try {
      file_writer = Nanosecond_Generation.getFileWriter(team, round);
      NanosecondGenerationTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondGenerationTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_generation constructor.");
      new NanosecondGenerationTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondGenerationTeam1Writer.writerCreated = var;
  }

}
