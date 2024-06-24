package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Module_Singleton {
  FileWriter getModuleRecorderInstance(); 
}