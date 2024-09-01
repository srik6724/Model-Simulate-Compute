package Logging_Process;

import java.util.logging.*;

import Verb_Process.Verb;

public class LoggingStorage {
  public final static Logger logger = Logger.getLogger(Verb.class.getName());

  public final static Logger getLogger() {
    return logger;
  }

}
