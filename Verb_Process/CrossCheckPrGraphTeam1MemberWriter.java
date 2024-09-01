package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckPrGraphTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckPrGraphTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_pyreason_graph.getFileWriter(team, memberNo, round);
      CrossCheckPrGraphTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckPrGraphTeam1MemberWriter.writerCreated == false) {
      new CrossCheckPrGraphTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckPrGraphTeam1MemberWriter.writerCreated = var; 
  }
}
