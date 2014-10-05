package com.dscomponent.queuetest;

import com.dscomponent.queue.DSQueue;
import com.dscomponent.exception.generic.DSRuntimeException;


public class DSQueueMultiThreadedTestHelper
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
    try
    {
      for (; currentInputIndex < inputEntries.length; currentInputIndex++)
      {
        queue.enqueue(inputEntries[currentInputIndex]);
        System.out.println("\n\tEnqueued : " + inputEntries[currentInputIndex]);
        Thread.sleep(300);
      }
    }
    catch(InterruptedException ie)
    {
      // Unexpected State
      throw new DSRuntimeException("Interruped Exception during Enqueue Method Sleep");
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
        System.out.println("\n\tDequeued : " + queue.dequeue() + " dequeueCount : " + dequeueCount);
        Thread.sleep(500);
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

  public void pollToCount(int pollCount)
  {
    try
    {
      while(pollCount > 0)
      {
        pollCount--;
        System.out.println("\n\tPolled : " + queue.poll() + " Poll Count : " + pollCount);
        Thread.sleep(400);
      }
    }
    catch (InterruptedException ie)
    {
      // Unexpected State
      throw new DSRuntimeException("Interruped Exception during Dequeue Method Sleep");
    }
  }
  
  public void pollOne()
  {
    System.out.println("Polled : " + queue.poll());
  }
}