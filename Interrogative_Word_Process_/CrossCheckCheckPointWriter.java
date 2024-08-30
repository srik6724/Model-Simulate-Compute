package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckCheckPointWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  
  CrossCheckCheckPointWriter(String team, int round) {
    try {
      file_writer = Cross_Check_State.getFileWriter(team, round);
      CrossCheckCheckPointWriter.writerCreated = true;  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckCheckPointWriter.writerCreated == false) {
      System.out.println("Calling round_check_point constrcutor");
      new CrossCheckCheckPointTeam1Writer("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckCheckPointWriter.writerCreated = var;
  }
}
