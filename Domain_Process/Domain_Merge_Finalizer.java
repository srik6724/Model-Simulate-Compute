package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;
/*
 *          # Match_Merge_Finalizer #
 * (Combine all Round_Merge_Finalizer structures)
 * ````````````````````````````````````````````````
 *          round_default_compute
 *                  |
 *         round_default_selection_cast
 *                  |
 *          round_excess_default
 *                  |
 *          round_remaining_default
 * 
 *          # Round_Merge_Finalizer #
 * `````````````````````````````````````````````````
 */        

interface Domain_Merge_Finalizer {
  static FileWriter getFileWriter() throws IOException {
    return new FileWriter("domain_merge_finalizer_compute.txt");
  }
}
