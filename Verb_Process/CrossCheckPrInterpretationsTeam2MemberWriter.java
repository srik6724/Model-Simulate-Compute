package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckPrInterpretationsTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckPrInterpretationsTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_pyreason_graph.getFileWriter(team, memberNo, round);
      CrossCheckPrInterpretationsTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckPrInterpretationsTeam2MemberWriter.writerCreated == false) {
      new CrossCheckPrInterpretationsTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckPrInterpretationsTeam2MemberWriter.writerCreated = var; 
  }
}
