package Logging_Process;

import java.util.logging.*;

import Match_Process.Match;

public class LoggingStorage {
  public final static Logger logger = Logger.getLogger(Match.class.getName());

  public final static Logger getLogger() {
    return logger;
  }

}
