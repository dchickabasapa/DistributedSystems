package com.dscomponent.exception.queue;

import com.dscomponent.exception.generic.DSRuntimeException;

public class DSQueueRuntimeException extends DSRuntimeException
{
  private String message = "DSQueueRuntimeException"; 
  
  public DSQueueRuntimeException()
  {
    super();
  }
  
  public DSQueueRuntimeException(Throwable cause)
  {
    super(cause);
  }
  
  public DSQueueRuntimeException(String message)
  {
    if (message != null && message.length() > 0)
    {
      this.message = "DSQueueRuntimeException:" + message;
    }
  }
  
  public String toString()
  {
    return this.message;
  }
  
}