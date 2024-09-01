package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckPathTraceTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckPathTraceTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Transducer.getFileWriter(team, memberNo, round); 
      CrossCheckPathTraceTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckPathTraceTeam1MemberWriter.writerCreated == false) {
      new CrossCheckPathTraceTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckPathTraceTeam1MemberWriter.writerCreated = var; 
  }
}
