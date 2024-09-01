package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckPrInterpretationsTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckPrInterpretationsTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_pyreason_graph.getFileWriter(team, memberNo, round);
      CrossCheckPrInterpretationsTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckPrInterpretationsTeam1MemberWriter.writerCreated == false) {
      new CrossCheckPrInterpretationsTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckPrInterpretationsTeam1MemberWriter.writerCreated = var; 
  }
}
