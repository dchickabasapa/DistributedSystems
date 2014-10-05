package com.dscomponent.queuetest;

import com.dscomponent.queue.DSQueue;
import com.dscomponent.exception.generic.InitializationException;
import com.dscomponent.exception.queue.*;

// Required for using Generic Arrays.
@SuppressWarnings("unchecked")

public class DSQueueBasicOperationsTest
{
  public boolean testInitialization()
  {
    System.out.println("\n\n\tTesting Initialization - testInitialization");
    try
    {
      DSQueue<Integer> queue = new DSQueue<Integer>(Integer.class, 2, DSQueue.Mode.NON_WAIT);
    }
    catch(Exception e)
    {
      // Unexpected State
      System.out.println("\n\ttestInitialization - Failed");
      return false;
    }
    
    // Expected State
    System.out.println("\n\ttestInitialization - Passed!!");
    return true;
  }
  
  public boolean testInitializationException()
  {
    System.out.println("\n\tTesting Initialization with InitializationException - testInitializationException");
    try
    {
      DSQueue<Integer> queue = new DSQueue<Integer>(Integer.class, 0, DSQueue.Mode.NON_WAIT);
    }
    catch (InitializationException ie)
    {
      // Expected State
      System.out.println("\n\ttestInitializationException - Passed!!");
      return true;
    }
    catch(Exception e)
    {
      // Unexpected State
      System.out.println("\n\ttestInitializationException - Failed");
      return false;
    }
    
    // Unexpected State
    System.out.println("\n\ttestInitializationException - Failed");
    return false;
  }
  
  public boolean testEnqueueOperation()
  {
    System.out.println("\n\tTesting Enqueu Operation - testEnqueueOperation");
    try
    {
      DSQueue<Integer> queue = new DSQueue(Integer.class, 3, DSQueue.Mode.NON_WAIT);
      int[] inputEntries = {3, 9, 16};
  
      for (Integer inputEntry : inputEntries)
      {
        queue.enqueue(inputEntry);
      }
    }
    catch (Exception e)
    {
      // Unexpected State
      System.out.println("\n\ttestEnqueueOperation - Failed");
      return false;
    }
    
    // Expected State
    System.out.println("\n\ttestEnqueueOperation - Passed!!");
    return true;
  }
  
  public boolean testDequeueOperation()
  {
    System.out.println("\n\tTesting Dequeue Operation - testDequeueOperation");
    try
    {
      DSQueue<Integer> queue = new DSQueue(Integer.class, 3, DSQueue.Mode.NON_WAIT);
      int[] inputEntries = {3, 9, 16};
  
      for (Integer inputEntry : inputEntries)
      {
        queue.enqueue(inputEntry);
      }
      
      for (Integer inputEntry : inputEntries)
      {
        if (inputEntry != queue.dequeue())
        {
          // Unexpected State
          System.out.println("\n\ttestDequeueOperation - Failed");
          return false;
        }
      }
    }
    catch (Exception e)
    {
      // Unexpected State
      System.out.println("\n\ttestDequeueOperation - Failed");
      return false;
    }
    
    // Expected State
    System.out.println("\n\ttestDequeueOperation - Passed!!");
    return true;
  }
  
  public boolean testPollOperation()
  {
    System.out.println("\n\tTesting Poll Operation - testPollOperation");
    try
    {
      DSQueue<Integer> queue = new DSQueue(Integer.class, 3, DSQueue.Mode.NON_WAIT);
      int[] inputEntries = {3, 9, 16};
  
      for (Integer inputEntry : inputEntries)
      {
        queue.enqueue(inputEntry);
      }
     
      if (queue.poll() != inputEntries[0])
      {
        // Unexpected State
        System.out.println("\n\ttestPollOperation - Failed");
        return false;
      }
      
      if (queue.poll() != inputEntries[0])
      {
        // Unexpected State
        System.out.println("\n\ttestPollOperation - Failed");
        return false;
      }
      
      queue.dequeue();

      if (queue.poll() != inputEntries[1])
      {
        // Unexpected State
        System.out.println("\n\ttestPollOperation - Failed");
        return false;
      }
      
      if (queue.poll() != inputEntries[1])
      {
        // Unexpected State
        System.out.println("\n\ttestPollOperation - Failed");
        return false;
      }      
    }
    catch (Exception e)
    {
      // Unexpected State
      System.out.println("\n\ttestPollOperation - Failed");
      return false;
    }
    
    // Expected State
    System.out.println("\n\ttestPollOperation - Passed!!");
    return true;
  }
  
  public boolean testIsEmptyOperation()
  {
    System.out.println("\n\tTesting isEmptry Operation - testIsEmptyOperation");
    try
    {
      DSQueue<Integer> queue = new DSQueue(Integer.class, 3, DSQueue.Mode.NON_WAIT);
      
      if (!queue.isEmpty())
      {
        // Unexpected State
        System.out.println("\n\ttestIsEmptyOperation - Failed");
        return false;
      }
 
      queue.enqueue(0);
      
      if (queue.isEmpty())
      {
        // Unexpected State
        System.out.println("\n\ttestIsEmptyOperation - Failed");
        return false;
      }
    }
    catch (Exception e)
    {
      // Unexpected State
      System.out.println("\n\ttestIsEmptyOperation - Failed");
      return false;
    }
    
    // Expected State
    System.out.println("\n\ttestIsEmptyOperation - Passed!!");
    return true;

  
  }  
}
