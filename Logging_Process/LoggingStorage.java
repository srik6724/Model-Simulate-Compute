package Logging_Process;

import java.util.logging.*;

import Second_Process.Second;

public class LoggingStorage {
  public final static Logger logger = Logger.getLogger(Second.class.getName());

  public final static Logger getLogger() {
    return logger;
  }

}
