package com.dscomponent.exception.generic;

public class DSRuntimeException extends RuntimeException
{
  public DSRuntimeException()
  {
    super();
  }
  
  public DSRuntimeException(String message)
  {
    super(message);
  }
  
  public DSRuntimeException(Throwable cause)
  {
    super(cause);
  }
  
  public String toString()
  {
    return super.toString();
  }
}