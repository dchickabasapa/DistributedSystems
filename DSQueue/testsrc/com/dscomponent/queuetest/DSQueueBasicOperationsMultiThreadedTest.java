package com.dscomponent.queuetest;

import com.dscomponent.queue.DSQueue;
import com.dscomponent.exception.generic.DSRuntimeException;

public class DSQueueBasicOperationsMultiThreadedTest
{
  


}

class DSQueueMultiThreadedTestHelper
{

  DSQueue<Integer> queue;
  int[] inputEntries;
  int currentInputIndex;
  
  public DSQueueMultiThreadedTestHelper(DSQueue<Integer> queue, int[] inputEntries)
  {
    this.queue = queue;
    this.inputEntries = inputEntries;
    this.currentInputIndex = 0;
  }
  
  public void enqueueAll()
  {
    for (; currentInputIndex < inputEntries.length; currentInputIndex++)
    {
      queue.enqueue(inputEntries[currentInputIndex]);
      System.out.println("\n\tEnqueued : " + inputEntries[currentInputIndex]);
    }
  }
  
  public void enqueueOne()
  {
    if (currentInputIndex < inputEntries.length)
    {
      queue.enqueue(inputEntries[currentInputIndex]);
      System.out.println("\n\tEnqueued : " + inputEntries[currentInputIndex++]);
    }
  }
  
  public void dequeueToCount(int dequeueCount)
  {
    try
    {
      while(dequeueCount > 0)
      {
        dequeueCount--;
        System.out.println("Dequeued : " + queue.dequeue());
        Thread.sleep(5000);
      }
    }
    catch(InterruptedException ie)
    {
      // Unexpected State
      throw new DSRuntimeException("Interruped Exception during Dequeue Method Sleep");
    }
  }
  
  public void dequeueOne()
  {
    System.out.println("Dequeued : " + queue.dequeue());
  }

  public void pollOne()
  {
    System.out.println("Polled : " + queue.poll());
  }
}