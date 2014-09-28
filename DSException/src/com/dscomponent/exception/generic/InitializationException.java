package com.dscomponent.exception.generic;

public class InitializationException extends DSCException
{
  private String message = null;
  
  public InitializationException()
  {
    super();
  }
  
  public InitializationException(String message)
  {
    super();
    this.message = "Initialization Exception: " + message;
  }
  
  public InitializationException(Throwable cause)
  {
    super(cause);
  }
 
  public String toString()
  {
    return message;
  }
}