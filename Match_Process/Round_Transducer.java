package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Round_Transducer {
  static FileWriter getFileWriter(String team) throws IOException {
    return new FileWriter("round_transducer_" + team + "_compute.txt");
  }

  static FileWriter getFileWriter(String team, int memberNo, int round) throws IOException {
    return new FileWriter("round_" + round + "_" + team + "_member_" + memberNo + "_compute.txt");
  }
}
