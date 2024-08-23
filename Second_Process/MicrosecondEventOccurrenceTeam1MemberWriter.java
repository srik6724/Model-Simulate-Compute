package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondEventOccurrenceTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  MicrosecondEventOccurrenceTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Microsecond_Timestamp.getFileWriter(team, memberNo, round); 
      MicrosecondEventOccurrenceTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(MicrosecondEventOccurrenceTeam1MemberWriter.writerCreated == false) {
      new MicrosecondEventOccurrenceTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    MicrosecondEventOccurrenceTeam1MemberWriter.writerCreated = var; 
  }
}
