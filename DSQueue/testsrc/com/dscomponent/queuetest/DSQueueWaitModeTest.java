package com.dscomponent.queuetest;

import com.dscomponent.queue.DSQueue;
import com.dscomponent.exception.generic.DSRuntimeException;

public class DSQueueWaitModeTest
{
  
  public boolean testWaitModeQueueOperation()
  {
    
    System.out.println("\n\tTesting Queue In WAIT Mode - testWaitModeQueueOperation");
    try
    {
      DSQueue<Integer> queue = new DSQueue<Integer>(Integer.class, 6, DSQueue.Mode.WAIT);
    
      int[] enqueuerInputEntries1 = {2, 8, 16, 28};
      DSQueueMultiThreadedTestHelper enqueuerHelper1 = new DSQueueMultiThreadedTestHelper(queue, enqueuerInputEntries1);
    
      int[] enqueuerInputEntries2 = {5, 11, 19, 27};
      DSQueueMultiThreadedTestHelper enqueuerHelper2 = new DSQueueMultiThreadedTestHelper(queue, enqueuerInputEntries2);
    
      DSQueueMultiThreadedTestHelper dequeuerHelper = new DSQueueMultiThreadedTestHelper(queue, null);
   
      DSQueueMultiThreadedTestHelper pollerHelper = new DSQueueMultiThreadedTestHelper(queue, null);
    
    
      Thread t1 = new Thread(new EnqueuerThread(enqueuerHelper1));
      Thread t2 = new Thread(new EnqueuerThread(enqueuerHelper2));
      Thread t3 = new Thread(new DequeuerThread(dequeuerHelper));
      Thread t4 = new Thread(new PollerThread(pollerHelper));
    
      t1.start();
      t2.start();
      t3.start();
      t4.start();
    
      t1.join();
      t2.join();
      t3.join();
      t4.join();
    }
    catch(Exception e)
    {
      // Unexpected State 
      System.out.println("\n\ttestWaitModeQueueOperation - Failed");
      return false;
    }
    
    System.out.println("\n\ttestWaitModeQueueOperation - Passed!!");
    return true;
  }

}

class EnqueuerThread implements Runnable
{

  private DSQueueMultiThreadedTestHelper helper;

  EnqueuerThread(DSQueueMultiThreadedTestHelper helper)
  {
    this.helper = helper;
  }
  
  public void run()
  {
    helper.enqueueAll();
  }
}

class DequeuerThread implements Runnable
{

  private DSQueueMultiThreadedTestHelper helper;

  DequeuerThread(DSQueueMultiThreadedTestHelper helper)
  {
    this.helper = helper;
  }
  
  public void run()
  {
    helper.dequeueToCount(8);
  }
}

class PollerThread implements Runnable
{

  private DSQueueMultiThreadedTestHelper helper;

  PollerThread(DSQueueMultiThreadedTestHelper helper)
  {
    this.helper = helper;
  }
  
  public void run()
  {
    helper.pollToCount(4);
  }
}