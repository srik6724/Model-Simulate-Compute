package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckCheckPointTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  CrossCheckCheckPointTeam1Writer(String team, int round) {
    try {
      file_writer = Cross_Check_State.getFileWriter(team, round);
      CrossCheckCheckPointTeam1Writer.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckCheckPointTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_check_point constrcutor");
      new CrossCheckCheckPointTeam1Writer("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckCheckPointTeam1Writer.writerCreated = var; 
  }
}
