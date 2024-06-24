package Logging_Process;

import java.util.logging.*;


import Category_Process.Category_;

public class LoggingStorage {
  public final static Logger logger = Logger.getLogger(Category_.class.getName());

  public final static Logger getLogger() {
    return logger;
  }

}
