package com.dscomponent.queue;

import com.dscomponent.exception.generic.InitializationException;
import com.dscomponent.exception.queue.*;
import java.lang.reflect.Array;

// Required for using Generic Arrays.
@SuppressWarnings("unchecked")

public class DSQueue<E>
{
  private int inputIndex;
  private int outputIndex;
  private E[] data;
  private int capacity;
  private  int currentCount;
  private Mode queueMode;
  
  public static enum Mode { WAIT, NON_WAIT};
  
  
  public DSQueue(Class<E> c, int capacity, Mode queueMode)
  {
    if (!(capacity > 0))
    {
      throw new InitializationException("Capacity for DSQueue needs to be more that Zero");
    }
    
    data = (E[]) Array.newInstance(c, capacity);
    inputIndex = 0;
    outputIndex = 0;
    currentCount = 0;
    this.capacity = capacity;
    this.queueMode = queueMode;
  }
  
  public synchronized void enqueue(E dataItem)
  {
    try
    {
      while (currentCount == capacity)
      {
        if (this.queueMode == Mode.NON_WAIT)
        {
          throw new OverflowException();
        }
        else
        {
          wait();
        }
      }
    }
    catch(InterruptedException ie)
    {
      throw new DSQueueRuntimeException(
          "Interrupted Exception encoutered while on wait() for queue to become un-full");
    }

    data[inputIndex] = dataItem;
    inputIndex = (inputIndex + 1) % capacity;
    currentCount++;
    notifyAll();
  }
  
  public synchronized E dequeue()
  {
    try
    {
      while (currentCount == 0)
      {
        if (this.queueMode == Mode.NON_WAIT)
        {
          throw new UnderflowException();
        }
        else
        {
          wait();
        }
      }
    }
    catch(InterruptedException ie)
    {
      throw new DSQueueRuntimeException(
        "Interrupted Exception encoutered while on wait() for queue to have atleast one element");
    }
    
    E outputItem = data[outputIndex];
    outputIndex = (outputIndex + 1) % capacity;
    currentCount--;
    notifyAll();
    return outputItem;
  }
  
  public synchronized boolean isEmpty()
  {
    return (currentCount == 0);
  }
  
  public synchronized E poll()
  {
    try
    {
      while (currentCount == 0)
      {
        if (this.queueMode == Mode.NON_WAIT)
        {
          throw new UnderflowException();
        }
        else
        {
          wait();
        }
      }
    }
    catch (InterruptedException ie)
    {
      throw new DSQueueRuntimeException(
        "Interrupted Exception encoutered while on wait() for queue to have atleast one element");
    }
    
    E outputItemRef = data[outputIndex];
    notifyAll();
    return outputItemRef;
  }
}