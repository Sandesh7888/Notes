1. Variable

- A variable is named memory location that holds a values of a program.
- Why? To store data that can be used and manipulated throughout the program.
- Advantages: Reusability, data manipulation, memory management.
- Example: `int age = 25;`

  . Instance Variables (Non-static Fields):
    - if a value of a variable is varied from object to object that variable is called an instance variable
    - They are created when an object is created and destroyed when the object is destroyed.
    - JVM will provide default value for Instance Variable.
    - Memory Location: Heap (as part of the object).

  . Class Variables (Static Fields):
    - if value of a variable is not varied from object to object and its common for all objects this type of variable is called 
        static variable.
    - Declared with the `static` modifier within a class, but outside any method, constructor or block.
    - There will be only one copy of a class variable for that class, and it is common to all objects of that class.
    - They are created when the program starts and destroyed when the program stops.
    - Memory Location: "Method Area"

  . Local Variables:
    - sometimes to meet a temporary requirement of execution we can declare a variable inside methods, constructors, or blocks
    - Sometimes, to meet a temporary requirement of execution, we can declare a variable inside methods, constructors, or blocks; such types of variables are called local variables.
    - They are created when the method, constructor or block is entered and destroyed once it exits.
    - JVM won't provide a default value for local variables; the compiler will not throw an error, but before use, we have to initialize
        them, otherwise we will get COMPILER ERROR: 'variable x might not have been initialized'
    - Memory Location: Stack memory.

2. Method
- A Method is a block of code that performs a specific task.
- It's used to define the behavior of a class or Object.
- Advantages: Reduces code duplication
- Example: 
  ```
  public int add(int a, int b) {
      return a + b;
  }
  ```
  . Static Method:
    - If a method belongs to the specific class rather than a specific object, this type of method is called a Static method.
    - We can call this method by using ClassName, Object, and Object reference.
    - It can be invoked without creating an object.
  . Instance Method / Non-Static Method:
    - The method belongs to the specific object of a class; such types of methods are instance methods.
    - These methods can be called by using an object.
    - Can access non-static data of a class but not static data.   

3. This Keyword
- `this` refers to the current instance of the class.
- To differentiate between instance variables and method parameters when they share the same name.
- The `this` keyword can be used to call one constructor from another constructor within the same class.
- Example:
  ```
  public class Car {
    private String model;
    private int year;
    private double price;

    // 3-parameter constructor (primary)
    public Car(String model, int year, double price) {
        this.model = model;
        this.year = year;
        this.price = price;
    }

    // 2-parameter constructor → chains to 3-param constructor
    public Car(String model, int year) {
        this(model, year, 0.0);  // Calls primary constructor (price=0.0)
    }

    // 1-parameter constructor → chains to 2-param constructor
    public Car(String model) {
        this(model, 2023);  // Chains to Car(model, year) → then to primary
    }

    // Default constructor → chains to 1-param constructor
    public Car() {
        this("Unknown Model");  // Chains to Car(model)
    }

    @Override
    public String toString() {
        return "Model: " + model + ", Year: " + year + ", Price: $" + price;
    }

    public static void main(String[] args) {
        Car car1 = new Car("Tesla Model S", 2023, 89990.0);
        Car car2 = new Car("Toyota Camry", 2024);  // Uses 2-param constructor
        Car car3 = new Car("Honda Civic");         // Uses 1-param constructor
        Car car4 = new Car();                      // Uses default constructor

        System.out.println(car1);
        System.out.println(car2); // Price=0.0 (default from chaining)
        System.out.println(car3); // Year=2023, Price=0.0
        System.out.println(car4); // Model="Unknown Model", Year=2023, Price=0.0
    }
  }
  ```

4. Super Keyword
- The `super` keyword is used to refer to the superclass of a subclass.
- To differentiate between ParentClass members and SubClass members if they share the same name.
- Example:
  ```java
  class Parent {
      void display() {
          System.out.println("Parent");
      }
  }
  class Child extends Parent {
      void display() {
          super.display(); // calls Parent's display()
      }
  }
  ```

5. This vs Super
- this: Refers to the current class instance.
- super: Refers to the parent class instance.


6. OOPs Concept
- OOPs is Object-Oriented Programming.
- It's a fundamental approach to develop software design and development.

  - Abstraction: 
    - Hiding the internal implementation and providing only the specification is called Abstraction.
    ex: Bank ATM, which offers a set of services without showing the internal implementation.

    There are two Types of Abstraction:
        . Fully Abstraction / Interface :
            - Any service requirement specification needs an implementation, which can be provided by an interface.
            - An interface is a combination of public + static + final variables and only abstract methods.
            - An interface provides 100% Abstraction.
            Note : If you know the specification and don't know the implementation, then we should go with an Interface.

        . Partially Abstraction / Abstract Class :
            - A class which is declared with the abstract keyword and it contains partial implementation; this type of
                class is called an Abstract class.
            - An abstract class can contain concrete methods + abstract methods.
            - An abstract class provides partial abstraction.
            Note: If we know the specification and implementation but not completely, then we should go with an abstract class.
  
  - Encapsulation: 
    - Wrapping a data member and member function into a single unit is called Encapsulation.
    ex POJO
        - In POJO, every variable is private, and as per requirement, we can declare getter/setter methods. 
    - It provides data hiding and security.
    
  - Inheritance: 
    - Creating a new class from an existing class.
    - The subclass inherits properties from a superclass and adds or modifies the functionality; this process is 
      called inheritance.
    
    . There are 5 types of Inheritance:
      - Single-level inheritance: One class having one subclass.
      - Multilevel inheritance: One class having one parent and one subclass.
      - Hierarchical Inheritance: One class having more than one subclass.
      - Multiple inheritance: One class having more than one parent class.
      - Hybrid Inheritance: Combination of more than one inheritance type.

  - Polymorphism: Flexibility and dynamic behavior.
    - One action can be performed in multiple ways; this process is called Polymorphism.
      or 
    - if a child class is not satisfied with the parent class method implementation, then the child is allowed to redefine that method 
      as per requirement; this process is called method overriding.
    - in method overriding, parameters and method name must be same.
    - return type covariant is allowed.
       ex: super method might throw Exception but we can throw RuntimeException in sub method.

7. Abstract Class vs Interface

- Interface:
  - if we know the specification and dont knows about implementation then we should go with interface
  - in interface every method is abstract whether we declare or not 
  - In Interface variables are public static final 
  - From Java 8, now can have default and static methods.
  - interface provide 100% Abstraction

- Abstract Class:
  - if we know the specification and implementation but not completely then we should go with Abstract class
  - Abstract class is Combination of abstract methods and concreate methods 
  - in abstract class there is no restictions to variable declaration
  - Abstract class provides Partially Abstraction

8. Overloading vs Overriding

- Overloading (Compile-time Polymorphism):
  - within a same class we can define more than one method with different parameter is process is called 
      method Overloading.
  - we can overload the private final and static methods
  - in method overloading return type declaration no restictions
  - in overloading throws keyword declarationhas no restictions
  - in overloading method resolution is always based on Object reference

    - if a child class is not satisfied with the parent class method implementation, then the child is allowed to redefine that method 
      as per requirement; this process is called method overriding.
    - we can't override private, final, and static methods.
    - in method overriding, the return type must be same or covariant is allowed.
    - in overriding, if the child class method throws any exception, then the parent class method should throw same exception or its parent.
    - in overriding, method resolution is always based on the Runtime Object.

9. POJO
- Plain Old Java Object. A simple Java class with private fields, public getters and setters, and no business logic.
- Why? To hold data.
- Example:
  ```
  public class Student {
      private String name;
      public String getName() { return name; }
      public void setName(String name) { this.name = name; }
  }
  ```

10. Constructor
- main pupose of a constructor is to initialize the object
- constructor is A special method which getting called Automatically when an object is created.

- Example: ```public Student() { ... }```

11. Datatypes
- Type of a Variable is called dataType.
- Datatypes are defining which type of values can variable can hold .


12. Access Modifiers
- Access Modifiers are defining a Scope of classes, methods, and variables.
- Types: 
  - `private`: Only within the class.
  - `default`: Within the package.
  - `protected`: Within package and subclasses.
  - `public`: Everywhere.


13. Wrapper Class
- Wrapper classes are object reference of Each primitive Datatypes.
- also it provides a utility methods to perform operations on primitive Datatypes
- Example: `Integer` for `int`.

14. JDK vs JRE vs JVM

- JDK (Java Development Kit): JRE + tools to develop Java applications (compiler, debugger, etc.).
  - JDK Provides development + runtime environment.
  - it provides a JRE + javac (compiler) + jdb (debugger) And other utilities.

- JVM (Java Virtual Machine): Runs Java bytecode
  - A virtual machine that runs Java bytecode.
  - Converts compiled bytecode into machine-specific instructions.
  - loads class file and executes Bytecode
  - manages memory and Garbage collector

- JRE (Java Runtime Environment): JVM + libraries to run Java applications.
  - Provides everything you need to run Java applications, but not to develop them.
  - it contains JVM , Core libraries and Java class Loaders


15. Exception
- Abnormal termination of a program is called Exception
- An event that disrupts the normal flow of the program.
  . purpose of Exception Handling 
    - graceful termination of a program 
    - defining an alternate way to continue the execution before it gets terminated
  . We can Handle a execption in two ways 
    - try-catch block
        in try-catch we manually handling a exceptions 
    - throws Keyword:
        in throws we are delegating the responsibility of exception handling to the JVM.

16. Exception Hierarchy
- for Exception Hierarchy refer Exception_Hierarchy.jpeg

17. Feature Of Java
- Object-Oriented	 : Follows OOP concepts like inheritance, polymorphism, abstraction, encapsulation.
- Platform Independent	: "Write Once, Run Anywhere" — Java bytecode runs on any JVM
- Secure : Provides a secure runtime environment (bytecode verification, security manager).
- Multithreaded : Built-in support for concurrent execution using threads.
- High Performance	: JIT (Just-In-Time) compiler improves runtime performance.

18. Array
- array is an indexed collection of a fixed number of homogeneous data elements.
- array can hold a fixed number of values of the same type.
- Advantages: the main advantage of an array is that we can represent n number of values by using a single variable, which 
   improves code readability.
- Disadvantages: arrays are fixed in size; once we create an array, there is no chance of increasing or decreasing its size 
   based on our requirement.
- Example: `int[] arr = {1,2,3};`

19. String in Java
- A sequence of characters. In Java, `String` is a class.
- Why? To handle text.
- Example: `String s = "Hello";`

20. String Methods
- Methods to manipulate strings: `length()`, `charAt()`, `substring()`, `equals()`, etc.

21. String class Is immutable
- Once created, cannot be changed.
- Why? Security, thread safety, and caching.
- Example: `String s = "hello"; s.concat(" world");` // returns new string

22. While loop vs Do while loop
- While: Checks condition before execution.
- Do While: Executes at least once, then checks condition.

23. Error vs Exception
- Error: Serious problem that a program should not catch (e.g., `OutOfMemoryError`).
- Exception: Conditions that a program might catch (e.g., `IOException`).

24. Conditional Statements
- `if`, `else if`, `else`, `switch` - for decision making.

25. Collection
- Framework to store and manipulate groups of objects.
- Why? To provide ready-made data structures.

26. Methods Of Collection
- Common methods: `add()`, `remove()`, `size()`, `isEmpty()`, etc.

27. List
- Ordered collection (sequence). Allows duplicates.

28. ArrayList
- Resizable array. Fast random access. Not synchronized.

29. Linked List
- Doubly-linked list. Fast insertion/deletion.

30. Vector
- Synchronized version of ArrayList.

31. Set
- Collection with no duplicates.

32. HashSet
- Unordered set using hash table. No duplicates.

33. TreeSet
- Sorted set (natural order). Red-black tree.

34. LinkedHashSet
- Maintains insertion order.

35. SortedSet
- Set that maintains elements in sorted order.

36. Map
- Stores key-value pairs.

37. HashMap
- Key-value pairs, no order, allows one null key.

38. Hashtable
- Synchronized, legacy, doesn't allow null.

39. TreeMap
- Sorted by keys.

40. Iterator
- Used to traverse a collection.

41. Iterator vs Iterable
- `Iterable` interface returns `Iterator`. `Iterator` has `next()`, `hasNext()`, `remove()`.

42. Enumeration
- Legacy iterator (only for legacy classes like Vector).

43. Comparable
- Interface with `compareTo()` method for natural ordering.

44. Comparator
- Interface with `compare()` for custom ordering.

45. Comparable vs Comparator
- `Comparable`: natural order (inside the class).
- `Comparator`: multiple custom orders (external class).

46. ConcurrentHashMap
- Thread-safe, divides map into segments.

47. IdentityHashMap
- Uses reference equality (`==`) instead of `equals()`.

48. HashMap vs ConcurrentHashMap
- `HashMap` is not thread-safe, `ConcurrentHashMap` is thread-safe.

49. Array vs ArrayList
- Array: fixed size.
- ArrayList: dynamic size.

50. ArrayList vs LinkedList
- ArrayList: fast random access, slow insertion/deletion in middle.
- LinkedList: slow random access, fast insertion/deletion.

51. ArrayList vs Vector
- ArrayList: not synchronized.
- Vector: synchronized.

52. List vs Set
- List: ordered, duplicates allowed.
- Set: no duplicates.

53. HashMap vs HashSet
- HashMap: stores key-value pairs.
- HashSet: internally uses HashMap, stores only keys.

54. HashMap vs Hashtable
- HashMap: not synchronized, allows null.
- Hashtable: synchronized, no null.

55. Collection vs Collections
- Collection: root interface.
- Collections: utility class with static methods.

56. HashSet vs TreeSet
- HashSet: unordered, faster.
- TreeSet: sorted.

57. Enumeration vs Iterator
- Enumeration: legacy, read-only.
- Iterator: can remove elements.

58. List vs Map
- List: ordered by index.
- Map: key-value pairs.

59. Collection vs Map
- Collection: group of objects.
- Map: key-value pairs.

60. Fail Fast vs Fail Safe
- Fail Fast: Throws `ConcurrentModificationException` if modified during iteration (e.g., ArrayList).
- Fail Safe: Doesn't throw (e.g., ConcurrentHashMap).

61. Legacy class
- Old classes like Vector, Hashtable.

62. Optional class
- Container to avoid null checks.

63. Garbage Collection
- Automatic memory management.

64. File
- Represents a file or directory.

65. Multi-Threading
- Running multiple threads concurrently.

66. Process vs Thread
- Process: independent program.
- Thread: lightweight sub-process.

67. Thread class vs Runnable Interface
- Thread class: extend and override `run()`.
- Runnable: implement `run()`, better for multiple inheritance.

68. Priority of thread
- From 1 (low) to 10 (high). Default is 5.

69. Thread Life Cycle
- New, Runnable, Running, Blocked, Dead.

70. Wait vs Sleep
- `wait()`: releases lock, called on object.
- `sleep()`: doesn't release lock, called on thread.

71. Final
- Keyword: final variable (constant), final method (cannot override), final class (cannot extend).

72. Synchronization
- To control access of multiple threads to shared resources.

73. Lambda
- Anonymous function for functional interfaces.

74. Static Block
- Code block that runs when class is loaded.

75. Non-Static Block
- Runs before constructor for each object.

76. Object Class
- Root class for all Java classes.

77. Throw vs Throws
- `throw`: to explicitly throw an exception.
- `throws`: in method signature to declare exceptions.

78. Stream API
- For functional-style operations on collections.

79. Stream API Method
- `filter()`, `map()`, `reduce()`, `collect()`, etc.

80. Functional Interface
- Interface with one abstract method (e.g., Runnable, Comparator).

81. Serialization
- Converting object to byte stream.

82. Transient
- Keyword: variable not serialized.

83. Volatile
- Variable stored in main memory, visible to all threads.

84. Exception Scenario
- Example: dividing by zero.

85. Method Reference
- Shorthand for lambda: `System.out::println`.

86. Design Pattern
- Reusable solution to common problems (e.g., Singleton, Factory).

87. What is Normalization
- Organizing database to reduce redundancy.

88. ACID Properties
- Atomicity, Consistency, Isolation, Durability - for database transactions.

89. Unique Key And Primary Key
- Primary Key: unique and not null.
- Unique Key: unique but can have null.

90. Types Of Language
- Compiled (C++), Interpreted (Python), Both (Java).

91. Delete VS Truncate
- `DELETE`: removes rows, can be rolled back.
- `TRUNCATE`: removes all rows, faster, cannot be rolled back.

92. Cross Join/Cartesian
- Returns product of two tables.

93. Join
- Combine rows from two or more tables.

94. Inner Join
- Returns matching rows.

95. Left Join
- All rows from left, matching from right.

96. Right Join
- All rows from right, matching from left.

97. Full Join
- All rows when there is a match in left or right.

98. Self Join
- Join a table to itself.

99. Set Operation
- UNION, INTERSECT, EXCEPT.

100. Procedure
- Group of SQL statements.

101. Function
- Returns a value.

102. Trigger
- Automatic action on database events.

103. What is hibernate framework?
- ORM (Object-Relational Mapping) tool for Java.

104. Write Down And explain hibernate.cfg.xml?
- Configuration file for Hibernate: database connection, mapping, etc.

105. What is SessionFactory?
- Thread-safe, immutable cache of compiled mappings. Creates `Session`.

106. What is Transaction?
- Unit of work with ACID properties.

107. What is Session?
- Single-threaded, short-lived object for CRUD operations.

108. Commonly used hibernate annotations?
- `@Entity`, `@Table`, `@Id`, `@Column`, `@OneToMany`, etc.

109. get() vs load()
- `get()`: returns null if not found.
- `load()`: returns proxy, throws exception if not found.

110. What is MappedBy
- Specifies the owning side of a bidirectional relationship.

111. Hibernate LifeCycle
- Transient, Persistent, Detached, Removed.

112. HQL Vs SQL
- HQL: object-oriented query language.
- SQL: database query language.

113. What is cache in hibernate?
- Stores data to reduce database hits.

114. First Level vs Second Level cache
- First Level: Session-level cache (enabled by default).
- Second Level: SessionFactory-level cache (needs configuration).

115. What is cascade?
- Propagates operations (save, delete) to associated entities.

116. Spring
- Framework for enterprise Java.

117. Dependency Injection
- Inversion of Control: providing dependencies from outside.

118. Spring Application Structure
- Typically: controllers, services, repositories, models.

119. Spring Modules
- Core, AOP, DAO, ORM, Web, MVC, etc.

120. IOC
- Inversion of Control: container manages objects.

121. Bean Life Cycle
- Instantiation, population, initialization, destruction.

122. Way to implement LifeCycle
- `InitializingBean`, `DisposableBean` interfaces or `init-method`, `destroy-method` in XML.

123. Autowiring in Spring
- Automatically injecting dependencies.

124. Advantages & Disadvantages of Autowiring
- Advantages: less configuration.
- Disadvantages: ambiguity, less explicit.

125. Qualifier
- Used with `@Autowired` to specify which bean to inject.

126. StandAlone Collection
- Collections defined in Spring configuration.

127. SterioType
- `@Component`, `@Service`, `@Repository`, `@Controller` - for auto-detection.

128. Component
- Generic stereotype for any Spring-managed component.

129. Scope
- Bean scope: singleton, prototype, request, session, etc.

130. SpEL-@Value
- Spring Expression Language: `@Value("#{systemProperties['user.name']}")`.

131. Spring JDBC
- Simplifies JDBC operations.

132. RowMapper
- Interface to map rows to objects.

133. Spring ORM-Advantages,Work
- Integration with ORM frameworks (Hibernate). Advantages: transaction management, exception handling.

134. Why Spring MVC
- For web applications, follows MVC pattern.

135. Working of Spring MVC
- DispatcherServlet handles request, finds controller, returns view.

136. RequestParam
- Binds request parameter to method parameter.

137. RequestMapping
- Maps request to controller method.

138. Controller
- Handles requests, returns view name.

139. RestController
- `@Controller` + `@ResponseBody` for REST APIs.

140. Service
- Business logic layer.

141. Repository
- Data access layer.

142. What is SpringBoot?
- Convention-over-configuration for Spring, simplifies setup.

143. Spring VS SpringBoot
- Spring: more configuration.
- SpringBoot: auto-configuration, embedded servers.

144. Auto-Configuration
- Automatically configures Spring based on dependencies.

145. JPA
- Java Persistence API: ORM standard.

146. JPA Vs Hibernate
- JPA: specification.
- Hibernate: implementation of JPA.

147. Custom Method
- In repository, define custom queries.

148. Native Query/@Query
- `@Query` to write custom SQL or JPQL.

149. API
- Application Programming Interface.

150. Rest & Method
- REST: Representational State Transfer. Methods: GET, POST, PUT, DELETE.

151. REST API And Status Code
- Status codes: 200 (OK), 201 (Created), 400 (Bad Request), 404 (Not Found), 500 (Internal Server Error).