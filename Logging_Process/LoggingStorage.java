package Logging_Process;

import java.util.logging.*;

import Interrogative_Word_Process_.Interrogative_Word;

public class LoggingStorage {
  public final static Logger logger = Logger.getLogger(Interrogative_Word.class.getName());

  public final static Logger getLogger() {
    return logger;
  }

}
