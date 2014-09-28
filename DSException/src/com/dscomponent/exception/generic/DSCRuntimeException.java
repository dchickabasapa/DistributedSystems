package com.dscomponent.exception.generic;

public class DSCRuntimeException extends DSCException
{
  public DSCRuntimeException()
  {
    super();
  }
  
  public DSCRuntimeException(String message)
  {
    super(message);
  }
  
  public DSCRuntimeException(Throwable cause)
  {
    super(cause);
  }
  
  public String toString()
  {
    return super.toString();
  }
}