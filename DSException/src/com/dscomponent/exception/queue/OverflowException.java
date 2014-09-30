package com.dscomponent.exception.queue;

import com.dscomponent.exception.generic.DSRuntimeException;

public class OverflowException extends DSRuntimeException
{
  
  private String message = "Overflow Exception in DSQueue";
  
  public OverflowException()
  {
    super();
  }
  
  public OverflowException(Throwable cause)
  {
    super(cause);
  }
  
  public OverflowException(String message)
  {
    if (message != null && message.length() > 0)
    {
      this.message = "OverflowException:" + message;
    }
  }
  
  public String toString()
  {
    return this.message;
  }
}