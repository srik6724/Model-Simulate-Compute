package Logging_Process;

import java.util.logging.*;

import Article_Process.Article;

public class LoggingStorage {
  public final static Logger logger = Logger.getLogger(Article.class.getName());

  public final static Logger getLogger() {
    return logger;
  }

}
