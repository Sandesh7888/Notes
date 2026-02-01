NoteBook 3 :
------------
* Exception Handling

  - Introduction
  - RuntimeStack mechanism
  - Default Exception Handler
  - Exception Handling
  - RuntimeStack mechanism
  - Default Exception Handler
  - Exception Hierarchy
  - Customized Exception Handling using try-catch
  - control flow in try-catch
  - method to print exception information
  - try with multiple catch blocks
  - finally block
  - difference between final, finally and finalize()
  - various possible combinations of try, catch and finally
  - control flow in try-catch-finally
  - control flow in nested try-catch-finally
  - throw keyword
  - throws keyword
  - Exception Handling Summary
  - various possible compile-time errors in Exception Handling
  - Custom Exception / User-defined Exception
  - Top 10 Exceptions
  - Exception Handling in 1.7 version

926. Introduction to Exception Handling
- An unwanted event which disturbs the normal flow of the program is called an Exception.
    * Purpose of Exception Handling:
    - Graceful termination of a program.
    - Defining an alternate way to continue the execution before it gets terminated.

97. Runtime Stack Mechanism
- When the program runs, the main thread adds each method call to the runtime stack.
- If a method finishes normally, its entry is removed from the stack.
- If a method ends because of an exception, its entry is also removed, but abnormally.
- When one method calls another, the called method is added above the caller in the stack.
- If the main method finishes (normally or with an exception), its entry is removed and the main thread ends.
- If the main thread ends normally, the program ends normally; if it ends abnormally, so does the program.
  
  ex: main() -> m1() -> m2()
  - main() calls m1(), so an entry for m1() is added above main() in the stack.
  - m1() calls m2(), so an entry for m2() is added above m1().
  - If m2() finishes normally, its entry is removed.
  - If m2() throws an exception and it's not handled, entries for m2(), m1(), and main() are all removed abnormally, 
    and the program ends abnormally.
   
  Note : if any method is completed abnormally due to exception then all the methods which are below that method
         in stack also get terminated abnormally
         

98. Default Exception Handler:

- All program execution is performed by the main thread.
- The main thread creates an entry inside the runtime stack for each method.
- If an exception occurs in a method, the main thread is responsible for creating an Exception object with the help of the JVM.
- This object is handed over to the JVM. First, the JVM checks if the method where the exception occurred has any exception handling code.
    - If not, then the JVM will terminate the method abnormally and remove the corresponding entry from the stack.
- JVM is responsible for completing the execution.
    For that, it calls the default exception handler and hands over the exception object to it.
- The default exception handler only prints the exception object details.
    Example:
    ```
    Exception in thread "main": java.lang.ArithmeticException: / by zero
            at ClassName.methodname
    ```
- After printing the exception object, the default exception handler hands over control back to the JVM.
- After that, the JVM terminates the main thread abnormally and removes the corresponding entry from the stack.
- Finally, the program is terminated abnormally.

99. Exception Hierarchy
- Throwable is the parent class of all Exception Classes
- Throwable class has two child classes
    1. Error
    2. Exception
- Error class is parent class of all the error classes
    - Error class and its child classes are irrecoverable errors
    - we can't handle error classes
    - ex : StackOverflowError , OutOfMemoryError
- Exception class is parent class of all the exception classes
    - Exception class and its child classes are recoverable exceptions
    - we can handle exception classes
    - Exception class has two child classes
        1. RuntimeException
        2. all remaining Exception classes
    - RuntimeException class and its child classes are called Unchecked Exception
        - we can handle Unchecked Exception classes
        - we may or may not handle Unchecked Exception classes
        - ex : ArithmeticException , NullPointerException , ClassCastException
    - all remaining Exception classes are called Checked Exception
        - we can handle Checked Exception classes
        - we must handle Checked Exception classes
        - ex : IOException , InterruptedException , SQLException , FileNotFoundException
      
  Note: For Exception Hierarchy refer Images/Exception_Hierarchy.jpeg

100. Exception vs Error
  
  * Exception:
  - An Exception is an unwanted event which disturbs the normal flow of the program.
  - An Exception is a recoverable condition.
  - We can handle Exceptions.
  - Exception is a child class of the Throwable class.
  - Examples: IOException, InterruptedException, SQLException, FileNotFoundException.
    Note: The cause of an Exception could be a missing file, network down, database down, etc.
  
  * Error:
  - An Error is an unwanted event which disturbs the normal flow of the program.
  - An Error is not a recoverable condition.
  - We cannot handle Errors.
  - Error is a child class of the Throwable class.
  - Examples: StackOverflowError, OutOfMemoryError.
    Note: The cause of an Error could be hardware failure, JVM failure, memory overflow, etc.



101. Difference between Checked and Unchecked Exceptions:

  * Checked Exception:
  - Exceptions which are checked by the compiler to ensure the programmer handles them for smooth execution at runtime; these are called Checked Exceptions.
    Example:
      ```java
      class Test 
      {
          public static void main(String[] args)
          {
              PrintWriter pw = new PrintWriter("abc.txt");
              pw.println("Hello");
          }
      }
      ```
      Error: Unreported exception java.io.FileNotFoundException; must be caught or declared to be thrown.
    
    - Except for the RuntimeException and Error groups, all remaining exceptions are Checked Exceptions.
    - Examples: IOException, InterruptedException, RemoteException.

  * Unchecked Exception:
  - Exceptions which are not checked by the compiler, but handled by the programmer at runtime; these are called Unchecked Exceptions.
    Example:
      ```java
      class Test 
      {
        public static void main(String[] args)
        {
            System.out.println(10/0);
        }
      }
      ```
    Output: Exception in thread "main" java.lang.ArithmeticException: / by zero at Test.main()

  - RuntimeException and its child classes + Error and its child classes are Unchecked Exceptions.
  - Examples: ArithmeticException, ClassCastException, NullPointerException.

102. Fully Checked And Partially Checked

  * Fully Checked :
  - Parent class is a checked exception and its child classes are also checked Exception; this type of classes are Fully 
    checked exception.
        ex : IOException -> FileNotFoundException, SocketException, InterruptedIOException

  * Partially Checked :
  - The parent is checked but some child classes are unchecked; this type of classes are Partially checked Exception.
        ex Throwable , Exception

103. Customized Exception Handling using try-catch
- We use try-catch to handle exceptions manually.
- Put code that might cause an exception inside the try block.
- If an exception happens, control goes to the catch block.
- If no exception happens, the catch block is skipped.
- If an exception occurs in the try block, the rest of the try block is skipped.
- If no exception occurs, all try block statements run and the catch block is ignored.
  ex:
    class Test
    {
      public static void main(String... args)
      {
        try{
          System.out.println("Flow 1");
        }catch(Exception exception){
          System.out.println("Flow 2");
        }
      }
    }

104. control-flow inside try-catch

  class TryCatchFlow {
    static void main(String[] args) {
      System.out.println("Start");
      try {
        System.out.println("In try block - before exception");
        int result = 10 / 0; // This will throw ArithmeticException
        System.out.println("In try block - after exception"); // This line will not execute
      } catch (ArithmeticException e) {
        System.out.println("In catch block");
      }
      System.out.println("End");
    }
  }

  Output:
  Start
  In try block - before exception
  In catch block
  End
  
105. Methods to print Exception Information

    * printStackTrace()
      - default exception handler always uses printStackTrace() method.
      - e.printStackTrace();
      - format 
            name of Exception : description 
                stackTrace
      - whenever we require proper Exception format on console then we use printStackTrace() method.
    
    * toString()
      - System.out.println(e);
      - System.out.println(e.toString());
      - format 
            name of Exception : description 
      - whenever we want name of Exception and description then we use toString() Method.

    * getMessage()
      -System.out.println(e.getMessage());
      -whenever we required only exception description not exception Name and and stackTrace then we can use getMessage().

106. try with multiple catch block
- Only a child Exception class can be in the first catch block, then a parent Exception class. 
- We can't give a child Exception class after a parent Exception class,
  otherwise we will get a Compile-time Error.
    CE: Compile Error: Unreachable catch block for ArithmeticException 
            It is already handled by the catch block for Exception.

    ex:

    try {
      int x = 10 / 0;
    } catch (Exception e) {
      System.out.println("Caught Exception");
    }
    catch (ArithmeticException e) {
      System.out.println("Caught ArithmeticException");
    }

107. Finally Block
- The finally block will always be executed whether an Exception occurred or not, handled or not, 
    even in abnormal termination also the finally block gets executed.
- The main purpose of the finally block is to maintain cleanup code. 
- The finally block only fails when System.exit(0); gets called. 

    Note System.exit(0) -> this zero Represents status code 
        - 0 means normal termination 
        - non zero means Abnormal termination

108. try-catch-finally Possibilities:
- try-finally-catch -> CE: catch without try
- try-catch(AE e)-catch(AE e) -> CE: Exception e has already been caught
- try-catch(AE e)-catch(NE e)-finally -> valid
- try-catch(AE e)-catch(Exception e)-finally -> valid
- try-catch(Exception e)-catch(AE e)-finally -> CE: Exception e has already been caught
- try-catch(Exception e)-catch(Exception e)-finally -> CE: Exception e has already been caught
- try-catch(Exception e)-finally-catch(AE e) -> CE: catch without try

109. nested try-catch-finally
  - In nested try-catch-finally blocks:
  - If an exception occurs in the inner try block, the inner catch block will handle it.
  - If the inner catch block does not handle it, the outer catch block will try to handle it.
  - If neither catch block handles the exception, the finally block will execute, 
    and then the program will terminate abnormally.


110. throw keyword
- To hand over our created Exception object to the JVM manually, that is the use of the throw keyword.
  or 
- We create our own exception Object and we hand it over to JVM manually; for that purpose, we use the throw keyword.
- throw new ArithmeticException("divide By Zero");
    here throw hands over the exception object to JVM manually.
- We can throw a Checked Exception also, but we have to handle that exception.
- cases : 
    - We can't throw a null object; if we throw then we will get NullPointerException.
    - We can't write any statement after throw, otherwise we will get CE : unreachable statement.
        throw new ArithmeticException("--");
        System.out.println("thrown an error");
    - We can throw only Throwable Classes, 
        otherwise we will get CE : incompatible types found : ClassName
                                                   required : Throwable

111. Important cases related to throw keyword
- If we throw a checked exception object then we must handle or declare that exception.
    ex
    ``` class Test 
      { 
        public static void main(String[] args)
        {
           throw new IOException();
        }
      }```
    CE : unreported exception IOException ; must be caught or declared to be thrown
  
- If we throw an unchecked exception object then we may or may not handle or declare that exception.
    ex
    ``` class Test 
      { 
        public static void main(String[] args)
        {
           throw new ArithmeticException();
        }
      }```

    - this class will compile fine and at runtime it will throw an ArithmeticException

-  ex
    ``` class Test 
      { 
        static ArithmeticException e;
        public static void main(String[] args)
        {
          throw e;
        }
      }```
    - this class will compile fine and at runtime it will throw a NullPointerException

112. throws keyword
- To delegate the responsibility of exception handling to the JVM, we use the throws keyword.
- The throws keyword merely convinces the compiler that we are not handling the exception manually, and are instead delegating the responsibility to the JVM.
- We use the throws keyword only with checked exceptions.
  Example:
    ```java
      class Test 
      {
        public static void main(String[] args)
        {
           Thread.sleep(1000);
        }
      }
    ```
    - This class will throw an InterruptedException. If we don't want to handle it manually, we can use the throws keyword:
    ```java
      class Test 
      {
        public static void main(String[] args) throws InterruptedException
        {
           Thread.sleep(1000);
        }
      }
    ```
- If the JVM handles an exception, it results in an abnormal termination. The throws keyword may lead to abnormal termination if the exception is actually thrown at runtime and not caught.

113. final, finally and finalize()

    . final :
    - final is an access modifier which is applicable for variables, methods and classes. 
        - if a variable is final then we can't change its value; this variable is constant.
        - if a method is final then we can't override it in child classes. 
        - if a class is final then we can't extend that class to any other class; inheritance is not possible for this class.
    
    . finally:
    - finally is a block associated with a try block.
    - This block's main use is to maintain cleanup code.
    - The finally block is always executed, whether an exception occurs or not, and whether it's handled or not.
    - The finally block is meant for resource cleanup activities.

    . finalize():
    - finalize() is a method associated with the garbage collector.
    - The garbage collector handles unused object cleanup activities.
    - The garbage collector performs automatic memory cleanup.
    - If an unreferenced object has any necessary cleanup activity, the garbage collector calls the finalize() method to perform it.
    - Once the finalize() method completes execution, the garbage collector will immediately destroy the unreferenced object.

114. Custom Exception / User defined Exception
- The exception class which is defined explicitly by the programmer to the program requirement.
    ex 
    ```
    class ToOldException extends RuntimeException 
    {
      public ToOldException(String message)
      {
         super(message);
      }
    }```

- if a custom exception class is a child of an unchecked exception then the class will be an unchecked exception.
- if a custom exception class is a child of a checked exception then the class will be a checked exception.


115. top 10 Exceptions
  * ArrayIndexOutOfBoundsException
    - occurs when trying to access an array with an invalid index.

  * ArithmeticException
    - occurs when an illegal arithmetic operation is performed, such as division by zero.

  * NullPointerException
    - occurs when trying to use an object reference that is null.

  * StackOverflowError
    - occurs when the call stack exceeds its limit, often due to deep or infinite recursion.

  * ClassCastException
    - occurs when trying to cast an object to a subclass that it is not an instance of.

  * NoClassDefFoundError
    - occurs when the Java Virtual Machine (JVM) or a ClassLoader tries to load a class, 
        but the class definition is not found.

  * IllegalArgumentException
    - occurs when a method receives an argument that is not valid.

  * NumberFormatException
    - occurs when trying to convert a string to a numeric type, but the string does not have the appropriate format.

  * IllegalStateException
    - occurs when a method is called at an inappropriate time or when the object is in an invalid state.

  * AssertionError
    - occurs when an assertion fails, typically used for debugging purposes.

  * IOException
    - occurs when an I/O operation fails or is interrupted.


116. 1.7 Enhancements

    . try with resources
      ex
      ```
      class Test 
      {
        BufferedReader br = null;
        public static void main(String[] args)
        {
           try(br = new BufferedReader(new FileReader("input.txt")))
           {
          
           }catch(IOException exception)
           {
          
           }
        }
      }```
      - if we want to use more that one resources then differentiate them with ";"  (like R1; R2)
      - in try with resource all resource variables are final , we can't assign new values.
      - with try with resource catch and finally block is not mandatory.
    
    . AutoCloseable (Interface)
    - AutoCloseable is an interface; it has only one method close().
    - When the try block finishes (either normally or with an exception), the close() method is called automatically on the 
      resource, ensuring proper cleanup.
    - Maximum resource classes implement AutoCloseable Interface by default.
        ex 
        ```
        public interface AutoCloseable {
            void close() throws Exception;
        }```



* MultiThreading

  - Introduction
  - Thread Life Cycle
  - Creating a Thread
  - Thread class methods
  - Runnable Interface
  - Synchronization
  - Inter Thread Communication
  - Daemon Thread
  - Thread Local
  - Executors Framework
  - Callable and Future
  - Fork/Join Framework
  - Phaser Class
  - CompletableFuture Class


117. Introduction of MultiThreading
  
  * Multitasking :
  - Multitasking is a process of executing multiple tasks simultaneously.
  - Multitasking is of two types :
    1. Process Based Multitasking
    2. Thread Based Multitasking

  * Process Based Multitasking :
  - In Process Based Multitasking, multiple processes are executed simultaneously.
  - Each process has its own memory space.
    ex:
      - when we open multiple applications in our system at a time, 
        like : web browser , code editor , media player etc.
      - in this case each application is a separate process.
      - each process has its own memory space.
  
  * Thread Based Multitasking :
  - In Thread Based Multitasking, multiple threads are executed simultaneously.
  - All threads share the same memory space.
    ex:
      - when we open a web browser in our system.
      - in this case web browser is a process.
      - in this web browser multiple tabs are opened at a time.
      - in this case each tab is a separate thread.
      - all tabs share the same memory space of web browser process.
  
  * Advantages of Multitasking
  - Improves the performance of the system.
  - Reduces the response time.
  - Better resource utilization.

118. Thread
- A separate flow of execution is called a Thread.
- Every Java program has at least one thread, which is the main thread.
- We can create multiple threads in a Java program to execute multiple tasks simultaneously.
- All threads share the same memory space of the process.
- Each thread has its own stack memory to store local variables and method calls.
- A thread is a lightweight process.

119. How to create a Thread
- We can create a thread in two ways:
  1. By extending Thread class
    - create a class which extends Thread class.
    - override the run() method of Thread class.
    - create an object of the class.
    - call the start() method of the object to start the thread.
      ex:
      ```class MyThread extends Thread {
          public void run() {
              System.out.println("Thread is running");
          }
      }
      public class Test {
          public static void main(String[] args) {
              MyThread t1 = new MyThread();         ->> Thread Instantiation
              t1.start();                           ->> Thread Starting  
          }
      }```
      
      Output:
      Thread is running

  2. By implementing Runnable interface
    - create a class which implements Runnable interface.
    - override the run() method of Runnable interface.
    - create an object of the class.
    - create an object of Thread class and pass the object of the class which implements Runnable interface 
      to the constructor of Thread class.
    - call the start() method of the Thread object to start the thread.
      ex:
      ```class MyRunnable implements Runnable {
          public void run() {
              System.out.println("Thread is running");
          }
      }
      public class Test {
          public static void main(String[] args) {
              MyRunnable r1 = new MyRunnable();     ->> Thread Instantiation
              Thread t1 = new Thread(r1);           ->> Thread Instantiation
              t1.start();                           ->> Thread Starting  
          }
      }```
      
      Output:
      Thread is running

120. Thread scheduler
- A thread scheduler is a part of the JVM which is responsible for scheduling the threads.
- It is responsible for deciding which thread to run and for how long.
- If multiple threads are in a ready state then the thread scheduler will decide which thread to run.
- We can't expect the order of execution of threads.
- We can't expect the number of times a thread will be executed.
  Hence: whenever a situation comes to MultiThreading, there is no guarantee for exact output.
  
121. Importance of Thread class start() method 
- start() method is used to start the thread.
- When we call the start() method of a thread then the thread is moved to the ready state.
- When we call the start() method of a thread then the run() method of the thread is called by JVM.
- If we call the run() method of a thread directly then the thread will not be started;
    it will be a normal method call.
  ex:
  ```class MyThread extends Thread {
      public void run() {
          System.out.println("Thread is running");
      }
  }
  public class Test {
      public static void main(String[] args) {
          MyThread t1 = new MyThread();
          t1.run();                           ->> Thread Not Starting
      }
  }```

122. Overloading of run() and start() method
- We can overload the run() method of Thread class.
- We can overload the start() method of Thread class.
- But we can't override the start() method of Thread class.
- If we overload the start() method of Thread class then the overloaded method will be treated as a normal method.
  ex:
  ```class MyThread extends Thread {
      public void run() {
          System.out.println("Thread is running");
      }
      public void run(int x) {
          System.out.println("Thread is running with value: " + x);
      }
      public void start(int y) {
          System.out.println("Thread is starting with value: " + y);
      }
  }
  public class Test {
      public static void main(String[] args) {
          MyThread t1 = new MyThread();
          t1.start(10);                       ->> Thread Not Starting
          t1.run(20);                         ->> Thread Not Starting
      }
  }```
  Output:
  Thread is starting with value: 10
  Thread is running with value: 20
- If we want to start the thread then we must call the start() method without any argument.
    ex:
    ```class MyThread extends Thread {
        public void run() {
            System.out.println("Thread is running");
        }
        public void run(int x) {
            System.out.println("Thread is running with value: " + x);
        }
        public void start(int y) {
            System.out.println("Thread is starting with value: " + y);
        }
    }
    public class Test {
        public static void main(String[] args) {
            MyThread t1 = new MyThread();
            t1.start();                         ->> Thread Starting
        }
    }```

    Output:
    Thread is running 

  - run() method is always called by JVM when we call the start() method of a thread without any argument.
  - If we want to call the overloaded run() method then we must call it directly.
      ex:
      ```class MyThread extends Thread {
          public void run() {
              System.out.println("Thread is running");
          }
          public void run(int x) {
              System.out.println("Thread is running with value: " + x);
          }
          public void start(int y) {
              System.out.println("Thread is starting with value: " + y);
          }
      }
      public class Test {
          public static void main(String[] args) {
              MyThread t1 = new MyThread();
              t1.run(20);                         ->> Thread Not Starting
          }
      }```
      Output:
      Thread is running with value: 20

  - If we want to call the overloaded start() method then we must call it directly.
      ex:
      ```class MyThread extends Thread {
          public void run() {
              System.out.println("Thread is running");
          }
          public void run(int x) {
              System.out.println("Thread is running with value: " + x);
          }
          public void start(int y) {
              System.out.println("Thread is starting with value: " + y);
          }
      }
      public class Test {
          public static void main(String[] args) {
              MyThread t1 = new MyThread();
              t1.start(10);                       ->> Thread Not Starting
          }
      }```
      Output:
      Thread is starting with value: 10

123. In the case of runnable interface we need to create the object of thread class
- When we create a thread by implementing Runnable interface then we need to create the object of Thread class.
- If we don't create the object of Thread class then we can't start the thread.
    ex:
    ```class MyRunnable implements Runnable {
        public void run() {
            System.out.println("Thread is running");
        }
    }
    public class Test {
        public static void main(String[] args) {
            MyRunnable r1 = new MyRunnable();
            r1.start();                         ->> CE : cannot find symbol
        }
    }```
    CE : cannot find symbol
          symbol : method start()
          location : variable r1 of type MyRunnable
- If we create the object of Thread class and pass the object of the class which implements Runnable interface
  to the constructor of Thread class then we can start the thread.
    ex:
    ```class MyRunnable implements Runnable {
        public void run() {
            System.out.println("Thread is running");
        }
    }
    public class Test {
        public static void main(String[] args) {
            MyRunnable r1 = new MyRunnable();
            Thread t1 = new Thread(r1);
            t1.start();                         ->> Thread Starting
        }
    }```
    Output:
    Thread is running

124. Thread class constructor
- Thread class has multiple constructors:
  1. Thread() : creates a new thread with default name.
  2. Thread(Runnable r) : creates a new thread with default name and the target Runnable object.
  3. Thread(String name) : creates a new thread with the specified name.
  4. Thread(Runnable r, String name) : creates a new thread with the specified name and the target Runnable object.
  5. Thread(ThreadGroup g, Runnable r, String name) : creates a new thread in the specified thread group 
    with the specified name and the target Runnable object.
  6. Thread(ThreadGroup g, String name) : creates a new thread in the specified thread group 
    with the specified name.
  7. Thread(ThreadGroup g, Runnable r) : creates a new thread in the specified thread group 
    with the target Runnable object.
  8. Thread(ThreadGroup g, Runnable r, String name, long stackSize) : creates a new thread in the specified thread group 
    with the specified name, target Runnable object and stack size.
  
125. getter and setter methods of Thread class
- getName() : returns the name of the thread.
- setName(String name) : sets the name of the thread.
  ex:
  ```class MyThread extends Thread {
      public void run() {
          System.out.println("Thread is running");
      }
  }
  public class Test {
      public static void main(String[] args) {
          MyThread t1 = new MyThread();
          System.out.println("Thread name: " + t1.getName());
          t1.setName("MyThread");
          System.out.println("Thread name: " + t1.getName());
          t1.start();
      }
  }```
  Output:
  Thread name: Thread-0
  Thread name: MyThread
  Thread is running

126. other important methods of Thread class

- getId() : returns the id of the thread.
- getPriority() : returns the priority of the thread.
- setPriority(int priority) : sets the priority of the thread.
- getState() : returns the state of the thread.
- getThreadGroup() : returns the thread group of the thread.
- isAlive() : returns true if the thread is alive, false otherwise.
- isDaemon() : returns true if the thread is a daemon thread, false otherwise.
- currentThread() : returns the current thread.
- yield() : causes the currently executing thread to pause and allow other threads to execute.
- sleep(long millis) : causes the currently executing thread to sleep for the specified number of milliseconds.
- join() : waits for the thread to die.
- join(long millis) : waits for the thread to die for the specified number of milliseconds.
- join(long millis, int nanos) : waits for the thread to die for the specified number
  of milliseconds and nanoseconds.

127. Thread priority
- Each thread has a priority.
- Thread priority is an integer value between 1 and 10.
- Default priority of a thread is 5.
- We can set the priority of a thread using setPriority(int priority) method.
- We can get the priority of a thread using getPriority() method.
- Thread priority is used by the thread scheduler to decide which thread to run.
- A higher priority thread is more important than a lower priority thread.
- The thread scheduler will try to run a higher priority thread first.
  Thread.MIN_PRIORITY = 1
  Thread.NORM_PRIORITY = 5
  Thread.MAX_PRIORITY = 10

128. Thread Life Cycle
- New : when a thread is created using new keyword then the thread is in new state.
- Runnable : when we call the start() method of a thread then the thread is in runnable state.
- Running : when the thread scheduler picks the thread from runnable state and starts executing it then
  the thread is in running state.
- Blocked : when a thread is waiting for a resource to be available then the thread is in blocked state.
- Waiting : when a thread is waiting for another thread to complete its task then the thread is in waiting state.
- Timed Waiting : when a thread is waiting for a specified amount of time then the thread is in timed waiting state.
- Terminated : when a thread completes its task or is terminated by another thread then 
    the thread is in terminated state.

/*
Thread Life Cycle Diagram

[New] 
  | 
  v (start())
[Runnable] <--------------------+
  |                            |
  v (scheduler picks)          | (notify()/notifyAll())
[Running]                      |
  |   ^                        |
  |   |                        |
  |   +---(wait())-------------+
  |        (join(), sleep(), etc. - transitions to Waiting/Timed Waiting)
  |   |
  v   |
[Blocked] <---+                |
  |           |                |
  v           |                |
[Waiting] <---+                |
  |                            |
  v (timeout)                  |
[Timed Waiting] ---------------+
  |
  v (run() ends)
[Terminated]

*/

  Note : For Thread Life Cycle Diagram refer Images/Thread_Life_Cycle.jpeg

129. IllegalThreadStateException
- IllegalThreadStateException is a runtime exception.
- If we are trying to start a thread which is already started then we will get IllegalThreadStateException.
  ex:
  ```class MyThread extends Thread {
      public void run() {
          System.out.println("Thread is running");
      }
  }
  public class Test {
      public static void main(String[] args) {
          MyThread t1 = new MyThread();
          t1.start();
          t1.start();                         ->> Exception in thread "main" java.lang.IllegalThreadStateException
      }
  }```
  Output:
  Thread is running
  Exception in thread "main" java.lang.IllegalThreadStateException
          at java.base/java.lang.Thread.start(Thread.java:793)
          at Test.main(Test.java:8)
  

130. We can prevent a thread execution by using the following methods:
  
  * yield()
  - yield() method is used to pause the current executing thread and give a chance to 
      other waiting threads which have the same priority.
  - yield() method is a static + native method of Thread class.
      syntax : public static native void yield();
  - If there is no other waiting thread or waiting threads have low priority then the current thread will continue 
    its own execution.
  - If multiple threads are waiting with the same priority then the thread scheduler will decide which thread to run.
  - The thread which is yielded will be in a runnable state depending on the thread scheduler.
  
    ex:
    ```class MyThread extends Thread {
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(getName() + " - " + i);
                if (i == 2) {
                    System.out.println(getName() + " is yielding...");
                    Thread.yield();
                }
            }
        }
    }
    public class Test {
        public static void main(String[] args) {
            MyThread t1 = new MyThread();
            t1.start();

            for(int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
            }
        }
    }```
    Output:
      main - 0
      Thread-0 - 0
      main - 1
      Thread-0 - 1
      main - 2
      main - 3
      Thread-0 - 2
      main - 4
      main - 5
      main - 6
      main - 7
      main - 8
      main - 9
      Thread-0 is yielding...
      Thread-0 - 3
      Thread-0 - 4
      Thread-0 - 5
      Thread-0 - 6
      Thread-0 - 7
      Thread-0 - 8
      Thread-0 - 9

      this output may vary as per thread scheduling by JVM

  * join() 
  - If a thread wants to wait for another thread to complete its task then we can use the join() method.
  - join() method is a non-static + native method of Thread class.
      syntax : public final native void join() throws InterruptedException;
               public final native void join(long millis) throws InterruptedException;
               public final native void join(long millis, int nanos) throws InterruptedException;

  - If we call the join() method of a thread then the current thread will wait until that thread completes its task.
  - ex: there are two threads t1 and t2
        - if we call t1.join() in t2 then t2 will wait until t1 completes its task.
        - if we call t2.join() in t1 then t1 will wait until t2 completes its task.
  
  note: every join() method throws InterruptedException which is a checked exception; 
        hence we must handle this exception by try-catch or throws keyword.

    ex:
    ```class MyThread extends Thread {
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(getName() + " - " + i);
                try {
                    Thread.sleep(100); // Sleep for 100 milliseconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public class Test {
        public static void main(String[] args) {
            MyThread t1 = new MyThread();
            t1.start();

            try {
                t1.join(); // Main thread will wait for t1 to finish
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for(int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
            }
        }
    }```
    Output:
      Thread-0 - 0
      Thread-0 - 1
      Thread-0 - 2
      Thread-0 - 3
      Thread-0 - 4
      Thread-0 - 5
      Thread-0 - 6
      Thread-0 - 7
      Thread-0 - 8
      Thread-0 - 9
      main - 0
      main - 1
      main - 2
      main - 3
      main - 4
      main - 5
      main - 6
      main - 7
      main - 8
      main - 9

      this output will not vary as main thread is waiting for t1 to complete its task

  Note: if main thread calls t1.join() then it goes in waiting state until t1 completes its task; 
      after completing its task t1 goes to terminated state and main thread goes to runnable state.

  * sleep()
  - If a thread doesn't want to perform any operation for a particular amount of time then we can use the sleep() method.
  - sleep() method is a static + native method of Thread class.
      syntax : public static native void sleep(long millis) throws InterruptedException;
               public static native void sleep(long millis, int nanos) throws InterruptedException;
  - If we call the sleep() method of a thread then the current thread will sleep for the specified amount of time.
  - If a thread is sleeping then it is in timed waiting state.
  - After completing the sleep time the thread will go to runnable state.
  - Every sleep() method throws InterruptedException which is a checked exception; 
    hence we must handle this exception by try-catch or throws keyword.

    ex:
    ```class MyThread extends Thread {
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(getName() + " - " + i);
                try {
                    Thread.sleep(100); // Sleep for 100 milliseconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public class Test {
        public static void main(String[] args) {
            MyThread t1 = new MyThread();
            t1.start(); 
            for(int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
                try {
                    Thread.sleep(50); // Sleep for 50 milliseconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }```    
    Output: 
      Thread-0 - 0
      main - 0
      Thread-0 - 1
      main - 1
      Thread-0 - 2
      main - 2
      Thread-0 - 3
      main - 3
      Thread-0 - 4
      main - 4
      Thread-0 - 5
      main - 5
      Thread-0 - 6
      main - 6
      Thread-0 - 7
      main - 7
      Thread-0 - 8
      main - 8
      Thread-0 - 9
      main - 9

      this output may vary as per thread scheduling by JVM
    
    - Thread.sleep(0); -> this statement can be used to pause the current executing thread and give a chance to other waiting threads of the same priority.
    
    - Life cycle of sleep() method:
      1. When we call the sleep() method of a thread, the thread moves to the timed waiting state.
      2. After completing the sleep time, the thread moves back to the runnable state.
      3. When the thread scheduler picks the thread from the runnable state and starts executing it, the thread is in the running state.
      4. When the thread completes its task, the thread moves to the terminated state.

131. Synchronization
- synchronized is a modifier applicable to methods and blocks, but not to classes and variables.
- If multiple threads try to operate on the same Java object concurrently, there may be a chance of data inconsistency.
- To avoid data inconsistency, we can use the synchronized modifier.
- If a method is synchronized, then only one thread can execute that method at a time.
- If a thread is executing a synchronized method, then other threads must wait until the thread completes its task to gain access.
- If a method is not synchronized, then multiple threads can execute that method concurrently.

  * Main advantage of synchronization: data consistency.
  * Main disadvantage of synchronization: performance degradation.

    ex:
    ```class Counter {
        private int count = 0;

        public synchronized void increment() {          ->> synchronized method
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    class MyThread extends Thread {
        private Counter counter;

        public MyThread(Counter counter) {
            this.counter = counter;
        }

        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        }
    }

    public class Test {
        public static void main(String[] args) {
            Counter counter = new Counter();
            MyThread t1 = new MyThread(counter);
            MyThread t2 = new MyThread(counter);
            t1.start();
            t2.start();
            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Final count: " + counter.getCount());
        }
    }```
    Output:
    Final count: 2000

    - if we remove synchronized modifier from increment() method then we may get data inconsistency
      hence final count may be less than 2000

      Output:
      Final count: 1987
      or
      Final count: 1995
      or
      Final count: 2000
      etc

      this output may vary as per thread scheduling by JVM

132. Class-Level Lock / Synchronization
- If a thread wants to execute a synchronized method, it must first acquire the lock of the object.
- Once a thread has the lock on the object, only then can it execute the synchronized method or block of that object.
- If a method is static and synchronized, then it is called class-level lock/synchronization.
- For static synchronized methods, only one thread can execute them across all instances of the class at a time.

133. synchronized block
- if we want to synchronize a part of the method then we can use synchronized block
- synchronized block is a block which is defined using synchronized keyword
- synchronized block is used to synchronize a part of the method
- synchronized block is used to improve the performance of the program
  ex:
  ```class Counter {
      private int count = 0;

      public void increment() {
          synchronized(this) {                     ->> synchronized block // this represents current object
              count++;
          }
      }

      public int getCount() {
          return count;
      }
  }

  class MyThread extends Thread {
      private Counter counter;

      public MyThread(Counter counter) {
          this.counter = counter;
      }

      public void run() {
          for (int i = 0; i < 1000; i++) {
              counter.increment();
          }
      }
  }
  public class Test {
      public static void main(String[] args) {
          Counter counter = new Counter();
          MyThread t1 = new MyThread(counter);
          MyThread t2 = new MyThread(counter);
          t1.start();
          t2.start();
          try {
              t1.join();
              t2.join();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          System.out.println("Final count: " + counter.getCount());
      }
  }```
  Output:
  Final count: 2000

  note: 
      
      - synchronized(this) {                     ->> synchronized block // this represents current object
              count++;
          }
      - synchronized(b)                          ->> synchronized block // b represents any object
      {
          count++;
      }
      - synchronized(Test.class)                          ->> synchronized block // Test.class represents class level lock
      {
          count++;
      }

134. Inter-Thread Communication
- If a thread wants to communicate with another thread, we can use inter-thread communication.
- Inter-thread communication is done using the wait(), notify(), and notifyAll() methods of the Object class.
- The wait() method is used to pause the current executing thread and give other threads a chance to execute.
- The notify() method is used to wake up a single thread that is in the waiting state.
- The notifyAll() method is used to wake up all threads which are in the waiting state.
- wait(), notify(), and notifyAll() methods are final and non-static methods of the Object class.
    syntax : public final void wait() throws InterruptedException;
             public final void wait(long millis) throws InterruptedException;
             public final void wait(long millis, int nanos) throws InterruptedException;
             public final void notify();
             public final void notifyAll();
- every wait() method throws InterruptedException which is a checked exception
  hence we must handle this execption by try-catch or throws keyword
- wait(), notify() and notifyAll() methods must be called from synchronized context only

  ex:
  ```class SharedResource {
      private int data;
      private boolean available = false; // Flag to indicate if data is available
      public synchronized int consume() {
          while (!available) {
              try {
                  wait(); // Wait until data is available
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
          available = false;
          notify(); // Notify producer that data has been consumed
          return data;
      }
      public synchronized void produce(int value) {
          while (available) {
              try {
                  wait(); // Wait until data is consumed
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
          data = value;
          available = true;
          notify(); // Notify consumer that data is available
      }
  }
  class Producer extends Thread {
      private SharedResource resource;
      public Producer(SharedResource resource) {
          this.resource = resource;
      }
      public void run() {
          for (int i = 0; i < 10; i++) {
              resource.produce(i);
              System.out.println("Produced: " + i);
              try {
                  Thread.sleep(100); // Simulate time taken to produce
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
      }
  }
  class Consumer extends Thread {
      private SharedResource resource;
      public Consumer(SharedResource resource) {  
          this.resource = resource;
      }
      public void run() {
          for (int i = 0; i < 10; i++) {
              int value = resource.consume();
              System.out.println("Consumed: " + value);
              try { 
                  Thread.sleep(150); // Simulate time taken to consume
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
      }
  }
  public class Test {
      public static void main(String[] args) {
          SharedResource resource = new SharedResource();
          Producer producer = new Producer(resource);
          Consumer consumer = new Consumer(resource);
          producer.start();
          consumer.start();
          try {
              producer.join();
              consumer.join();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
  }```
  Output:
  Consumed: 0
  Produced: 0
  Produced: 1
  Consumed: 1
  Produced: 2
  Consumed: 2
  Produced: 3
  Consumed: 3
  Produced: 4
  Produced: 5
  Consumed: 4
  Consumed: 5
  Produced: 6
  Consumed: 6
  Produced: 7
  Produced: 8
  Consumed: 7
  Consumed: 8
  Produced: 9
  Consumed: 9

135. difference between notify() and notifyAll()

  * notify()
  - notify() method is used to wake up a single thread which is in waiting state
  - if multiple threads are waiting then thread scheduler will decide which thread to wake up
  - if no thread is waiting then notify() method will do nothing
  - notify() method must be called from synchronized context only

  * notifyAll()
  - notifyAll() method is used to wake up all the threads which are in waiting state
  - if no thread is waiting then notifyAll() method will do nothing
  - notifyAll() method must be called from synchronized context only

136. Daemon Thread
- A daemon thread is a thread that runs in the background and provides services to other threads.
- A daemon thread is typically a low-priority thread.
- Daemon threads are terminated automatically by the JVM when all user threads (non-daemon threads) have completed.
- We can create a daemon thread by using the setDaemon(true) method of the Thread class.
- We can check whether a thread is a daemon or not by using the isDaemon() method.
- The setDaemon(true) method must be called before starting the thread, otherwise, it will throw an IllegalThreadStateException.
- The garbage collector is a classic example of a daemon thread.
  ex:
  ```class MyThread extends Thread {
      public void run() {
          for (int i = 0; i < 10; i++) {
              System.out.println(getName() + " - " + i);
              try {
                  Thread.sleep(100); // Sleep for 100 milliseconds
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
      }
  }
  public class Test {
      public static void main(String[] args) {
          MyThread t1 = new MyThread();
          t1.setDaemon(true);                  ->> setting daemon thread
          System.out.println(t1.isDaemon());   ->> checking daemon thread
          t1.start(); 
          for(int i = 0; i < 5; i++) {
              System.out.println(Thread.currentThread().getName() + " - " + i);
              try {
                  Thread.sleep(50); // Sleep for 50 milliseconds
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
      }
  }```
  Output:
  true
  main - 0
  Thread-0 - 0
  main - 1
  Thread-0 - 1
  main - 2
  Thread-0 - 2
  main - 3
  Thread-0 - 3
  main - 4
  Thread-0 - 4

137. Default Nature of Threads
- By default, the main thread is a user thread.
- By default, the garbage collector is a daemon thread.
- Daemon nature is inherited from parent to child threads; if the parent is a daemon, the child is also a daemon by default.

  ex:
  ```class MyThread extends Thread {
      public void run() {
          System.out.println(getName() + " is daemon: " + isDaemon());
      }
  }
  public class Test {
      public static void main(String[] args) {
          MyThread t1 = new MyThread();
          t1.setDaemon(true);                  ->> setting daemon thread
          t1.start();
          MyThread t2 = new MyThread();
          t2.start();
      }
  }```
  Output:
  Thread-0 is daemon: true
  Thread-1 is daemon: false

  ***Note: It is imposible to change the nature of main thread because it is started by JVM
        hence main thread is always user thread


138. Deadlock
- deadlock is a situation where two or more threads are blocked forever waiting for each other
- deadlock occurs when two or more threads are waiting for each other to release the lock
- deadlock can be avoided by using tryLock() method of ReentrantLock class
- deadlock can be avoided by using synchronized block instead of synchronized method
- deadlock can be avoided by using timeout in wait() method
  ex:
  ```class Resource {
      public synchronized void method1(Resource r) {  
          System.out.println(Thread.currentThread().getName() + " is in method1");
          try {
              Thread.sleep(100);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          r.method2(this);
      }
      public synchronized void method2(Resource r) {
          System.out.println(Thread.currentThread().getName() + " is in method2");
          try {
              Thread.sleep(100);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          r.method1(this);
      }
  }
  class MyThread1 extends Thread {
      private Resource r1;
      private Resource r2;
      public MyThread1(Resource r1, Resource r2) {
          this.r1 = r1;
          this.r2 = r2;
      }
      public void run() {
          r1.method1(r2);
      }
  }
  class MyThread2 extends Thread {
      private Resource r1;
      private Resource r2;
      public MyThread2(Resource r1, Resource r2) {
          this.r1 = r1;
          this.r2 = r2;
      }
      public void run() {
          r2.method2(r1);
      }
  }
  public class Test {
      public static void main(String[] args) {
          Resource r1 = new Resource();
          Resource r2 = new Resource();
          MyThread1 t1 = new MyThread1(r1, r2);
          MyThread2 t2 = new MyThread2(r1, r2);
          t1.start();
          t2.start();
      }
  }```
  Output:
  Thread-0 is in method1
  Thread-1 is in method2
  (program is hanging here due to deadlock)
  Note: to resolve deadlock we need to use thread dump analysis tool like jstack,
        VisualVM, etc to find the deadlock and resolve it
  Exception in thread "main" java.lang.IllegalThreadStateException
           at java.base/java.lang.Thread.start(Thread.java:793)

139. Deadlock vs Starvation
- deadlock is a situation where two or more threads are blocked forever waiting for each other
- starvation is a situation where a thread is unable to gain regular access to shared resources and is
  unable to make progress
- deadlock occurs when two or more threads are waiting for each other to release the lock
- starvation occurs when a thread is waiting for a resource for a long time


140. how to stop a thread
- we can stop a thread by using stop() method of Thread class
- stop() method is deprecated because it is unsafe and can lead to data inconsistency
- we can stop a thread by using interrupt() method of Thread class
- interrupt() method is used to interrupt a thread which is in waiting, sleeping or blocked state
- if a thread is in running state then interrupt() method will not stop the thread
- if a thread is in waiting, sleeping or blocked state then interrupt() method will throw InterruptedException
- we can check whether a thread is interrupted or not by using isInterrupted() method of Thread class

141. how to suspend and resume a thread
- we can suspend a thread by using suspend() method of Thread class
- suspend() method is deprecated because it is unsafe and can lead to deadlock
- we can resume a suspended thread by using resume() method of Thread class
- resume() method is deprecated because it is unsafe and can lead to deadlock
- we can suspend and resume a thread by using wait() and notify() methods of Object class

142. Thread Group
- Based on functionality we can group multiple threads into a single group is called Thread Group
- ThreadGroup class is used to group multiple threads into a single group
- ThreadGroup class is a part of java.lang package
- we can create a thread group by using ThreadGroup class constructor
    syntax : public ThreadGroup(String name);
             public ThreadGroup(ThreadGroup parent, String name);
- we can get the name of the thread group by using getName() method of ThreadGroup class
- we can get the parent thread group by using getParent() method of ThreadGroup class
- we can get the active count of threads in a thread group by using activeCount() method of ThreadGroup class
- we can get the active count of thread groups in a thread group by using activeGroupCount() method of ThreadGroup class

  * main advantage of thread group is we can manage multiple threads as a single unit and we can 
    perform operations on multiple threads as a single unit
  * main disadvantage of thread group is it is not flexible and it is not recommended to use

  ex:
  ```class MyThread extends Thread {
      public MyThread(ThreadGroup tg, String name) {
          super(tg, name);  
      }
      public void run() {
          System.out.println(getName() + " is running");
      }
  }
  public class Test {
      public static void main(String[] args) {
          ThreadGroup tg1 = new ThreadGroup("Group1");
          ThreadGroup tg2 = new ThreadGroup(tg1, "Group2");

          MyThread t1 = new MyThread(tg1, "Thread-1");
          MyThread t2 = new MyThread(tg1, "Thread-2");
          MyThread t3 = new MyThread(tg2, "Thread-3");

          t1.start();
          t2.start();
          t3.start();

          System.out.println("Thread Group Name: " + tg1.getName());
          System.out.println("Parent Thread Group Name: " + tg2.getParent().getName());
          System.out.println("Active Thread Count in Group1: " + tg1.activeCount());
          System.out.println("Active Thread Group Count in Group1: " + tg1.activeGroupCount());
      }
  }```
  Output:
  Thread-1 is running
  Thread-2 is running
  Thread-3 is running
  Thread Group Name: Group1
  Parent Thread Group Name: Group1
  Active Thread Count in Group1: 2
  Active Thread Group Count in Group1: 1  

143. java.util.concurrent package
- java.util.concurrent package is introduced in Java 5
- java.util.concurrent package provides high level concurrency utilities
- java.util.concurrent package provides classes and interfaces for managing threads and synchronizing access to shared resources
  
  * Lock interface and its implementations
    - Lock interface is a part of java.util.concurrent.locks package
    - Lock interface provides a way to lock and unlock a resource
    - Lock interface provides more flexibility than synchronized keyword
    - Lock interface provides tryLock() method to avoid deadlock
    - Lock interface provides Condition interface to manage multiple wait sets
    - ReentrantLock class is an implementation of Lock interface

  * lock interface methods
    - void lock() : acquires the lock
    - void lockInterruptibly() throws InterruptedException : acquires the lock unless the current thread
      is interrupted
    - boolean tryLock() : tries to acquire the lock without waiting
    - boolean tryLock(long time, TimeUnit unit) throws InterruptedException : tries to acquire the lock
      within the given time
    - void unlock() : releases the lock
    - Condition newCondition() : returns a new Condition instance that is bound to this Lock instance 

  ex:
  ```import java.util.concurrent.locks.Lock;
  import java.util.concurrent.locks.ReentrantLock;
  class Counter {
      private int count = 0;
      private Lock lock = new ReentrantLock();
      public void increment() {
          lock.lock(); // Acquire the lock
          try {
              count++;
          } finally {
              lock.unlock(); // Always release the lock in finally block
          }
      }
      public int getCount() {
          return count;
      }
  }
  class MyThread extends Thread {
      private Counter counter;
      public MyThread(Counter counter) {
          this.counter = counter;
      }
      public void run() {
          for (int i = 0; i < 1000; i++) {
              counter.increment();
          }
      }
  }
  public class Test {
      public static void main(String[] args) {
          Counter counter = new Counter();
          MyThread t1 = new MyThread(counter);
          MyThread t2 = new MyThread(counter);
          t1.start();
          t2.start();
          try {
              t1.join();
              t2.join();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          System.out.println("Final count: " + counter.getCount());
      }
  }```
  Output:
  Final count: 2000

  note: if we remove lock and unlock methods then we may get data inconsistency
        hence final count may be less than 2000
  
144. ReentrantLock
- ReentrantLock class is an implementation of Lock interface
- ReentrantLock class is a part of java.util.concurrent.locks package
- ReentrantLock class provides more flexibility than synchronized keyword
- ReentrantLock class provides tryLock() method to avoid deadlock
- ReentrantLock class provides Condition interface to manage multiple wait sets
- ReentrantLock class provides fairness policy to ensure that the longest waiting thread is given access to
  the lock
- we can create a ReentrantLock object by using ReentrantLock class constructor
    syntax : public ReentrantLock();
             public ReentrantLock(boolean fair);
- if we pass true to the constructor then it is a fair lock otherwise it is a non fair lock
- by defoult ReentrantLock is a non fair lock
  ex:
  ```import java.util.concurrent.locks.Lock;
  import java.util.concurrent.locks.ReentrantLock;
  class Counter {
      private int count = 0;
      private Lock lock = new ReentrantLock(true); // Fair lock
      public void increment() {
          lock.lock(); // Acquire the lock
          try {
              count++;
          } finally {
              lock.unlock(); // Always release the lock in finally block
          }
      }
      public int getCount() {
          return count;
      }
  }
  class MyThread extends Thread {
      private Counter counter;
      public MyThread(Counter counter) {
          this.counter = counter;
      }
      public void run() {
          for (int i = 0; i < 1000; i++) {
              counter.increment();
          }
      }
  }
  public class Test {
      public static void main(String[] args) {
          Counter counter = new Counter();
          MyThread t1 = new MyThread(counter);
          MyThread t2 = new MyThread(counter);
          t1.start();
          t2.start();
          try {
              t1.join();
              t2.join();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          System.out.println("Final count: " + counter.getCount());
      }
  }```
  Output:
  Final count: 2000

  note: if we remove lock and unlock methods then we may get data inconsistency
        hence final count may be less than 2000

  * important methods of ReentrantLock class
    - void lock() : acquires the lock
    - void lockInterruptibly() throws InterruptedException : acquires the lock unless the current thread
      is interrupted
    - boolean tryLock() : tries to acquire the lock without waiting
    - boolean tryLock(long time, TimeUnit unit) throws InterruptedException : tries to acquire the lock
      within the given time
    - void unlock() : releases the lock
    - Condition newCondition() : returns a new Condition instance that is bound to this Lock instance 
    - int getHoldCount() : returns the number of holds on this lock by the current thread
    - boolean isHeldByCurrentThread() : returns true if the current thread holds this lock
    - boolean isLocked() : returns true if this lock is held by any thread
    - final boolean isFair() : returns true if this lock has fairness set true

145. ThreadPool
* ThreadPool
- ThreadPool is a pool of threads which are created in advance and are ready to execute tasks
- ThreadPool is used to manage multiple threads as a single unit
- ThreadPool is used to improve the performance of the application
- ThreadPool is a part of java.util.concurrent package
- we can create a ThreadPool by using Executors class

* Executors
- Executors class is a part of java.util.concurrent package
- Executors class provides factory methods to create different types of ThreadPools
    syntax : public static ExecutorService newFixedThreadPool(int nThreads);
             public static ExecutorService newCachedThreadPool();
             public static ExecutorService newSingleThreadExecutor();
             public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize);

* ExecutorService
- ExecutorService interface is a part of java.util.concurrent package
- ExecutorService interface provides methods to manage the ThreadPool
    syntax : public Future<?> submit(Runnable task);
             public <T> Future<T> submit(Callable<T> task);
             public void shutdown();
             public List<Runnable> shutdownNow();
             public boolean isShutdown();
             public boolean isTerminated();
             public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException;

* Future
- Future interface is a part of java.util.concurrent package
- Future interface provides methods to manage the result of the asynchronous computation
    syntax : public boolean cancel(boolean mayInterruptIfRunning);
             public boolean isCancelled();
             public boolean isDone();
             public V get() throws InterruptedException, ExecutionException;
             public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;

  ex:
  ```import java.util.concurrent.ExecutorService;
  import java.util.concurrent.Executors;
  class MyTask implements Runnable {
      private String name;
      public MyTask(String name) {
          this.name = name;
      }
      public void run() {
          System.out.println(name + " is running");
          try {
              Thread.sleep(100); // Simulate time taken to execute task
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          System.out.println(name + " is completed");
      }
  }
  public class Test {
      public static void main(String[] args) {
          ExecutorService executor = Executors.newFixedThreadPool(3); // Create a ThreadPool with 3 threads
          for (int i = 1; i <= 10; i++) {
              MyTask task = new MyTask("Task-" + i);
              executor.submit(task); // Submit the task to the ThreadPool
          }
          executor.shutdown(); // Shutdown the ThreadPool
          try {
              if (!executor.awaitTermination(60, java.util.concurrent.TimeUnit.SECONDS)) {
                  executor.shutdownNow(); // Force shutdown if tasks are not finished
              }
          } catch (InterruptedException e) {
              executor.shutdownNow();
          }
      }
  }```
  Output:
  Task-1 is running
  Task-2 is running
  Task-3 is running
  Task-1 is completed
  Task-4 is running
  Task-2 is completed
  Task-5 is running
  Task-3 is completed
  Task-6 is running
  Task-4 is completed
  Task-7 is running
  Task-5 is completed
  Task-8 is running
  Task-6 is completed 

146. Callable and Future

* Callable
- Callable interface is a part of java.util.concurrent package
- in the case of runnable interface the run() method doesn't return any value and
  it can't throw checked exception
- in the case of callable interface the call() method returns a value and it can throw checked
  exception
- Callable interface is similar to Runnable interface but it can return a result and can throw a checked
  exception
- we can create a Callable object by implementing the Callable interface
    syntax : public interface Callable<V> {
                 V call() throws Exception;
             }  

* Future
- Future interface is a part of java.util.concurrent package
- Future object can be used to check the status of the Callable task
- Future object can be used to retrieve the result of the Callable task
- Future interface provides methods to manage the result of the asynchronous computation
    syntax : public boolean cancel(boolean mayInterruptIfRunning);
              public boolean isCancelled();
              public boolean isDone();
              public V get() throws InterruptedException, ExecutionException;
              public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;


  ex:  ```import java.util.concurrent.Callable;
  import java.util.concurrent.ExecutionException;
  import java.util.concurrent.ExecutorService;
  import java.util.concurrent.Executors;
  import java.util.concurrent.Future;
  class MyTask implements Callable<Integer> {
      private int number;
      public MyTask(int number) {
          this.number = number;
      }
      public Integer call() throws Exception {
          int sum = 0;
          for (int i = 1; i <= number; i++) {
              sum += i;
          }
          return sum;
      }
  }
  public class Test {
      public static void main(String[] args) {
          ExecutorService executor = Executors.newFixedThreadPool(3); // Create a ThreadPool with 3 threads
          Future<Integer> future1 = executor.submit(new MyTask(10)); // Submit the task to the ThreadPool
          Future<Integer> future2 = executor.submit(new MyTask(20)); // Submit the task to the ThreadPool
          Future<Integer> future3 = executor.submit(new MyTask(30)); // Submit the task to the ThreadPool
          try {
              System.out.println("Sum of first 10 numbers: " + future1.get());
              System.out.println("Sum of first 20 numbers: " + future2.get());
              System.out.println("Sum of first 30 numbers: " + future3.get());
          } catch (InterruptedException | ExecutionException e) {
              e.printStackTrace();
          }finally {
          executor.shutdown(); // Shutdown the ThreadPool
          }
      }
  }```
  Output:
  Sum of first 10 numbers: 55
  Sum of first 20 numbers: 210
  Sum of first 30 numbers: 465

147. Difference between Runnable and Callable

  * Runnable
  - Runnable interface is a part of java.lang package
  - Runnable interface is used to represent a task that can be executed by a thread
  - Runnable interface has a single method run() which doesn't return any value and
    it can't throw checked exception
  - we can create a Runnable object by implementing the Runnable interface
    syntax : public interface Runnable {
                 void run();
             }

  * Callable
  - Callable interface is a part of java.util.concurrent package
  - Callable interface is used to represent a task that can be executed by a thread
  - Callable interface has a single method call() which returns a value and it can throw checked
    exception
  - we can create a Callable object by implementing the Callable interface
    syntax : public interface Callable<V> {
                 V call() throws Exception;
             }


148. ThreadLocal
- ThreadLocal class is a part of java.lang package
- ThreadLocal class provides thread local variables
- each thread accessing a ThreadLocal variable has its own, independently initialized copy of the variable
- ThreadLocal class is used to create variables that can only be read and written by the same thread
- ThreadLocal class is used to avoid synchronization
- we can create a ThreadLocal variable by using ThreadLocal class constructor
    syntax : public ThreadLocal();
- we can set the value of the ThreadLocal variable by using set() method of ThreadLocal class
- we can get the value of the ThreadLocal variable by using get() method of ThreadLocal class
- we can remove the value of the ThreadLocal variable by using remove() method of ThreadLocal class
    syntax : public void set(T value);
             public T get();
             public void remove();
  ex:
  ```class MyThread extends Thread {
      private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);
      public void run() { 
          int value = threadLocal.get();
          value += 1;
          threadLocal.set(value);
          System.out.println(getName() + " - " + threadLocal.get());
      }
  }
  public class Test {
      public static void main(String[] args) {
          MyThread t1 = new MyThread();
          MyThread t2 = new MyThread();
          t1.start();
          t2.start();
      }
  }```
  Output:
  Thread-0 - 1
  Thread-1 - 1

149. Thread Safety
  - Thread safety means that shared data structures or resources are accessed by multiple threads in a 
    way that ensures correct results, even when accessed concurrently.
  - Achieving thread safety can be done using synchronization, locks, concurrent collections, or immutability.
  - Examples of thread-safe classes: Vector, Hashtable, Collections.synchronizedList(), ConcurrentHashMap, AtomicInteger.

150. Volatile Keyword
  - The volatile keyword is used for variables that may be modified by multiple threads.
        (Multiple threads can modify the same variable)
  - It ensures that changes to a variable are always visible to other threads.
  - Volatile does not guarantee atomicity, only visibility.
  - Example:
    ```java
    class Shared {
        volatile boolean flag = false;
    }
    ```

151. Atomic Variables
  - Atomic variables (like AtomicInteger, AtomicBoolean) provide lock-free, thread-safe operations on single variables.
  - They are part of java.util.concurrent.atomic package.
  - Useful for counters, flags, and reference updates without explicit synchronization.
  - Example:
    ```java
    import java.util.concurrent.atomic.AtomicInteger;
    AtomicInteger counter = new AtomicInteger(0);
    counter.incrementAndGet();
    ```

152. Concurrent Collections
  - Java provides thread-safe collections in java.util.concurrent package, such as ConcurrentHashMap, CopyOnWriteArrayList, and BlockingQueue.
  - These collections are designed for concurrent access and provide better performance than synchronized wrappers.

153. BlockingQueue
  - BlockingQueue is an interface for thread-safe queues that support operations that wait for the queue to become non-empty or non-full.
  - Common implementations: ArrayBlockingQueue, LinkedBlockingQueue, PriorityBlockingQueue.
  - Used for producer-consumer scenarios.

154. Thread Interruption
  - Thread interruption is a mechanism to signal a thread to stop its current activity.
  - Use Thread.interrupt(), Thread.isInterrupted(), and InterruptedException to handle interruptions.
  - Best practice: regularly check the interrupted status in long-running or blocking operations.

155. ThreadFactory
  - ThreadFactory is an interface for creating new threads on demand.
  - Used with ExecutorService to customize thread creation (naming, priority, daemon status).
  - Example:
    ```java
    ExecutorService executor = Executors.newFixedThreadPool(3, runnable -> {
        Thread t = new Thread(runnable);
        t.setName("CustomThread");
        return t;
    });
    ```

156. Fork/Join Framework
  - The Fork/Join framework (java.util.concurrent) is designed for parallelism and divide-and-conquer algorithms.
  - Uses ForkJoinPool and ForkJoinTask (RecursiveTask, RecursiveAction).
  - Efficient for tasks that can be broken into smaller subtasks and processed in parallel.

157. CompletableFuture
  - CompletableFuture (Java 8+) is used for asynchronous programming and combining multiple futures.
  - Supports non-blocking, callback-based programming with methods like thenApply, thenAccept, thenCombine, exceptionally.
  - Example:
    ```java
    CompletableFuture.supplyAsync(() -> "Hello")
        .thenApply(s -> s + " World")
        .thenAccept(System.out::println);
    ```

158. Best Practices for Multithreading
  - Minimize shared mutable state.
  - Prefer higher-level concurrency utilities (Executors, concurrent collections).
  - Use synchronization and locks carefully to avoid deadlocks and performance issues.
  - Always release locks in finally blocks.
  - Use thread-safe patterns (immutable objects, thread confinement, stateless objects).



