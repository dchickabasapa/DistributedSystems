package com.dscomponent.exception.generic;

public class DSCException extends Exception
{
  public DSCException()
  {
    super();
  }
  
  public DSCException(Throwable cause)
  {
    super(cause);
  }
  
  public DSCException(String message)
  {
    super(message);
  }
  
  public String toString()
  {
    return super.toString();
  } 

}