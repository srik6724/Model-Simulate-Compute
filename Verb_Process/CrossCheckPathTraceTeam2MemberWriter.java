package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckPathTraceTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckPathTraceTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Transducer.getFileWriter(team, memberNo, round); 
      CrossCheckPathTraceTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckPathTraceTeam2MemberWriter.writerCreated == false) {
      new CrossCheckPathTraceTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckPathTraceTeam2MemberWriter.writerCreated = var; 
  }
}
