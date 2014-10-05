package com.dscomponent.queuetest;

import com.dscomponent.queue.DSQueue;

public class DSQueueTester
{
  public void runTests()
  {
    System.out.println("\n\n\tStarting Tests");
    
    boolean testsPassed = false;
    
    testsPassed = testBasicOperations();
    
    if (testsPassed)
    {
      testsPassed = testNonWaitMode();
    }
    
    if (testsPassed)
    {
      testsPassed = testWaitMode();
    }
    
    if (testsPassed)
    {
      System.out.println("\n\n\tTests Passed!!\n\n ");
    }
    else
    {
      System.out.println("\n\n\tTests Failed\n\n");  
    }
  }
  
  public boolean testWaitMode()
  {
    DSQueueWaitModeTest waitModeTest = new DSQueueWaitModeTest();
    boolean testsPassed = false;
    
    testsPassed = waitModeTest.testWaitModeQueueOperation();
    
    return testsPassed;
  }
  
  public boolean testNonWaitMode()
  { 
    DSQueueNonWaitModeTest nonWaitModeTest = new DSQueueNonWaitModeTest();
    boolean testsPassed = false;
    
    testsPassed = nonWaitModeTest.testNonWaitModeEnqueueOperation();
    
    if (testsPassed)
    {
      testsPassed = nonWaitModeTest.testNonWaitModeDequeueOperation();
    }
    
    if (testsPassed)
    {
      testsPassed = nonWaitModeTest.testNonWaitModePollOperation();
    }
    
    return testsPassed;
  }
  
  public boolean testBasicOperations()
  {
    DSQueueBasicOperationsTest basicOperationsTest = new DSQueueBasicOperationsTest();
    boolean testPassed = false; 
    testPassed = basicOperationsTest.testInitialization();
    
    if (testPassed)
    {
      testPassed = basicOperationsTest.testInitializationException();
    }
    
    if (testPassed)
    {
      testPassed = basicOperationsTest.testEnqueueOperation();
    }
    
    if (testPassed)
    {
      testPassed = basicOperationsTest.testDequeueOperation();
    }

    if (testPassed)
    {
      testPassed = basicOperationsTest.testPollOperation();
    }
   
    if (testPassed)
    {
      testPassed = basicOperationsTest.testIsEmptyOperation();
    }
    
    return testPassed;
  }
  
  public static void main(String[] args)
  {
    DSQueueTester tester = new DSQueueTester();
    tester.runTests();
  }
}