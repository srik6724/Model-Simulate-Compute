package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondEventOccurrenceTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  NanosecondEventOccurrenceTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Timestamp.getFileWriter(team, memberNo, round); 
      NanosecondEventOccurrenceTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondEventOccurrenceTeam2MemberWriter.writerCreated == false) {
      new NanosecondEventOccurrenceTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondEventOccurrenceTeam2MemberWriter.writerCreated = var; 
  }
}
