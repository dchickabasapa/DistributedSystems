package com.dscomponent.exception.queue;

import com.dscomponent.exception.generic.DSRuntimeException;

public class UnderflowException extends DSRuntimeException
{
  
  private String message = "Underflow Exception in DSQueue";
  
  public UnderflowException()
  {
    super();
  }
  
  public UnderflowException(Throwable cause)
  {
    super(cause);
  }
  
  public UnderflowException(String message)
  {
    if (message != null && message.length() > 0)
    {
      this.message = "UnderflowException:" + message;
    }
  }
  
  public String toString()
  {
    return this.message;
  }
}