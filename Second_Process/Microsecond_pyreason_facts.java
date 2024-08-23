package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Microsecond_pyreason_facts {
  static FileWriter getFileWriter(String team, int round) throws IOException {
    return new FileWriter("microsecond_" + round + "_pyreason_facts_" + team + ".compute.txt"); 
  }

  static FileWriter getFileWriter(String team, int memberNo, int round) throws IOException {
    return new FileWriter("microsecond_" + round + "_pyreason_facts_" + team + "_member_" + memberNo + ".compute.txt"); 
  }
}
