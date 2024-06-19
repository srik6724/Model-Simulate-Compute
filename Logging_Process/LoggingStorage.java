package Logging_Process;

import java.util.logging.*;

import Product_Process.Product;

public class LoggingStorage {
  public final static Logger logger = Logger.getLogger(Product.class.getName());

  public final static Logger getLogger() {
    return logger;
  }

}
