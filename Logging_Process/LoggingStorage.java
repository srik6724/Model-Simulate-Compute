package Logging_Process;

import java.util.logging.*;

import Domain_Process.Domain;

public class LoggingStorage {
  public final static Logger logger = Logger.getLogger(Domain.class.getName());

  public final static Logger getLogger() {
    return logger;
  }

}
