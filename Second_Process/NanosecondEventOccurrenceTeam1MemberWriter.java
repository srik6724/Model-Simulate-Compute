package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondEventOccurrenceTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondEventOccurrenceTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Timestamp.getFileWriter(team, memberNo, round); 
      NanosecondEventOccurrenceTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondEventOccurrenceTeam1MemberWriter.writerCreated == false) {
      new NanosecondEventOccurrenceTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondEventOccurrenceTeam1MemberWriter.writerCreated = var; 
  }
}
