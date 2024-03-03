package Logging;

import java.util.logging.*;

import wizPackage.Match;

public class LoggingStorage {
  public final static Logger logger = Logger.getLogger(Match.class.getName());

  public final static Logger getLogger() {
    return logger;
  }

}
