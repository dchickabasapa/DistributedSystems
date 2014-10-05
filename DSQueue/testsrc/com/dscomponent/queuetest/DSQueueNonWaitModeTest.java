package com.dscomponent.queuetest;

import com.dscomponent.queue.DSQueue;
import com.dscomponent.exception.queue.*;

// Required for using Generic Arrays.
@SuppressWarnings("unchecked")

public class DSQueueNonWaitModeTest extends DSQueueTest
{
  public boolean testNonWaitModeEnqueueOperation()
  {
    System.out.println("\n\tTesting NON_WAIT Mode Enqueue Operation - testNonWaitModeEnqueueOperation");
    
    try
    {
      DSQueue<Integer> queue = new DSQueue(Integer.class, 3, DSQueue.Mode.NON_WAIT);
      int[] inputEntries = {3, 9, 16, 29};
  
      for (Integer inputEntry : inputEntries)
      {
        queue.enqueue(inputEntry);
      }  
    }
    catch (OverflowException of)
    {
      // Expected State
      System.out.println("\n\ttestNonWaitModeEnqueueOperation - Passed!!");
      return true;
    }
    catch (Exception e)
    {
      // Unexcpected State
      System.out.println("\n\ttestNonWaitModeEnqueueOperation - Failed");
      return false;  
    }
   
    // Unexcpected State
    System.out.println("\n\ttestNonWaitModeEnqueueOperation - Failed");
    return false;  
  }

  public boolean testNonWaitModeDequeueOperation()
  {
    System.out.println("\n\tTesting NON_WAIT Mode Dequeue Operation - testNonWaitModeDequeueOperation");
    
    try
    {
      DSQueue<Integer> queue = new DSQueue(Integer.class, 3, DSQueue.Mode.NON_WAIT);
      int[] inputEntries = {3, 9, 16};
  
      for (Integer inputEntry : inputEntries)
      {
        queue.enqueue(inputEntry);
      }  
  
      for (int i = 0; i < inputEntries.length; i++)
      {
        queue.dequeue();
      }
      
      queue.dequeue();
    }
    catch (UnderflowException uf)
    {
      // Expected State.
      System.out.println("\n\ttestNonWaitModeDequeueOperation - Passed!!");
      return true;
    }
    catch (Exception e)
    {
      // Unexcpected State
      System.out.println("\n\ttestNonWaitModeDequeueOperation - Failed");
      return false;  
    }
   
    // Unexcpected State
    System.out.println("\n\ttestNonWaitModeDequeueOperation - Failed");
    return false;  
  }

  public boolean testNonWaitModePollOperation()
  {
    System.out.println("\n\tTesting NON_WAIT Mode Pool Operation - testNonWaitModePollOperation");
    
    try
    {
      DSQueue<Integer> queue = new DSQueue(Integer.class, 3, DSQueue.Mode.NON_WAIT);
      int[] inputEntries = {3, 9, 16};
  
      for (Integer inputEntry : inputEntries)
      {
        queue.enqueue(inputEntry);
      }  
  
      for (int i = 0; i < inputEntries.length; i++)
      {
        queue.dequeue();
      }
      
      queue.poll();
    }
    catch (UnderflowException uf)
    {
      // Expected State.
      System.out.println("\n\testNonWaitModePollOperation - Passed!!");
      return true;
    }
    catch (Exception e)
    {
      // Unexcpected State
      System.out.println("\n\testNonWaitModePollOperation - Failed");
      return false;  
    }
   
    // Unexcpected State
    System.out.println("\n\testNonWaitModePollOperation - Failed");
    return false;  
  }  
}