package com.dscomponent.exception.generic;

public class DSException extends Exception
{
  public DSException()
  {
    super();
  }
  
  public DSException(Throwable cause)
  {
    super(cause);
  }
  
  public DSException(String message)
  {
    super(message);
  }
  
  public String toString()
  {
    return super.toString();
  } 

}