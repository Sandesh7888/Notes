1. Difference between NoClassDefFoundError & ClassNotFoundException

    | NoClassDefFoundError                                         | ClassNotFoundException                                  |
    |--------------------------------------------------------------|---------------------------------------------------------|
    | - It is an unchecked exception                               | - It is a checked exception                             |
    | - Occurs when, for hard-coded class names, at runtime the    | - Occurs when, for dynamically provided class names, at |
    | corresponding .class file is not available.                  | runtime the corresponding .class file is not available. |
    | Results in RuntimeException: NoClassDefFoundError            | Results in checked Exception: ClassNotFoundException    |

2. Difference between Checked & Unchecked Exception
    | Checked Exception                                           | Unchecked Exception                                     |
    |-------------------------------------------------------------|---------------------------------------------------------|
    | - It is checked at compile time                             | - It is not checked at compile time                     |
    | - Must be either caught or declared in the method signature | - No such requirement                                   |
    | - Examples: IOException, SQLException                       | - Examples: NullPointerException, ArithmeticException   |

3. Difference between fail-fast and fail-safe iterators
    | Fail-Fast Iterator                                          | Fail-Safe Iterator                                      |
    |-------------------------------------------------------------|---------------------------------------------------------|
    | - Operates directly on the original collection               | - Operates on a clone of the original collection        |
    | - Throws ConcurrentModificationException if the collection  | - Does not throw ConcurrentModificationException            |
    | is modified during iteration                                 |                                                         |
    | - Examples: Iterators of ArrayList, HashMap                  | - Examples: Iterators of CopyOnWriteArrayList, ConcurrentHashMap |

4. Difference between String, StringBuffer & StringBuilder
    | String                                                      | StringBuffer                                            | StringBuilder                                           |
    |-------------------------------------------------------------|---------------------------------------------------------|---------------------------------------------------------|
    | - Immutable (cannot be changed after creation)              | - Mutable (can be changed)                             | - Mutable (can be changed)                             |
    | - Thread-safe (synchronized)                               | - Thread-safe (synchronized)                            | - Not thread-safe (not synchronized)                         |
    | - Slower for concatenation operations                      | - Slower than StringBuilder but faster than String for concatenation | - Fastest for concatenation operations                  |

5. Difference between ArrayList & LinkedList
    | ArrayList                                                   | LinkedList                                              |
    |-------------------------------------------------------------|---------------------------------------------------------|
    | - Backed by a dynamic array                                 | - Backed by a doubly linked list                        |
    | - Provides fast random access (O(1) time complexity)        | - Provides slower random access (O(n) time complexity)     |
    | - Slower insertion and deletion operations (O(n) time complexity) | - Faster insertion and deletion operations (O(1) time complexity) |

6. Difference between HashMap & Hashtable
    | HashMap                                                     | Hashtable                                               |
    |-------------------------------------------------------------|---------------------------------------------------------|
    | - Not synchronized (not thread-safe)                        | - Synchronized (thread-safe)                            |
    | - Allows one null key and multiple null values              | - Does not allow null keys or null values               |
    | - Generally faster due to lack of synchronization overhead  | - Generally slower due to synchronization overhead      |

7. Difference between Comparable & Comparator
    | Comparable                                                  | Comparator                                              |
    |-------------------------------------------------------------|---------------------------------------------------------|
    | - Defines natural ordering of objects                       | - Defines custom ordering of objects                    |
    | - Implemented by the class whose objects need to be compared | - Implemented in a separate class                      |
    | - Method: compareTo()                                      | - Method: compare()                                      |

8. Difference between Abstract class & Interface
    | Abstract Class                                              | Interface                                               |
    |-------------------------------------------------------------|---------------------------------------------------------|
    | - Can have both abstract and concrete methods               | - Can only have abstract methods (until Java 8, which introduced default and static methods) |
    | - Can have instance variables                                 | - Cannot have instance variables (can have constants)    |
    | - Supports single inheritance                               | - Supports multiple inheritance                          |

9. Difference between final, finally & finalize
    | final                                                       | finally                                                 | finalize                                                |
    |-------------------------------------------------------------|---------------------------------------------------------|---------------------------------------------------------|
    | - A keyword used to declare constants, prevent method      | - A block used to execute code after try-catch, regardless of whether an exception occurred | - A method called by the garbage collector before an object is destroyed |
    | overriding, and inheritance                                 |                                                         |                                                         |
    | - Used with variables, methods, and classes                 | - Used with try-catch blocks                           | - Used to perform cleanup operations                     |

10. Difference between static & non-static
    | static                                                      | non-static                                              |
    |-------------------------------------------------------------|---------------------------------------------------------|
    | - Belongs to the class rather than any instance            | - Belongs to an instance of the class                  |
    | - Can be accessed without creating an instance of the class | - Requires an instance of the class to be accessed          |
    | - Shared among all instances of the class                   | - Unique to each instance of the class                  |

11. Difference between JDK, JRE & JVM
    | JDK                                                         | JRE                                                     | JVM                                                     |
    |-------------------------------------------------------------|---------------------------------------------------------|---------------------------------------------------------|
    | - Java Development Kit, used for developing Java applications | - Java Runtime Environment, used for running Java applications | - Java Virtual Machine, responsible for executing Java bytecode |
    | - Includes JRE and development tools (compiler, debugger)   | - Includes JVM and core libraries                        | - Platform-dependent component                          |
    | - Required for Java development                             | - Required for Java execution                            | - Required for Java execution                            |

12. Difference between == & equals()
    | ==                                                          | equals()                                                |
    |-------------------------------------------------------------|---------------------------------------------------------|
    | - Compares object references (memory addresses)             | - Compares object content (logical equality)          |
    | - Returns true if both references point to the same object  | | - Returns true if the content of both objects is the same  |
    | - Can be used with primitive data types as well | - Must be overridden in custom classes for meaningful comparison |

13. Difference between throw & throws
    | throw                                                       | throws                                                  |
    |-------------------------------------------------------------|---------------------------------------------------------|
    | - Used to explicitly throw an exception                    | - Used in method signature to declare exceptions that a method can throw |
    | - Can be used within a method                              | - Used only in method declarations                   |
    | - Can throw a single exception at a time                   | - Can declare multiple exceptions separated by commas |

14. Difference between Array & ArrayList
    | Array                                                       | ArrayList                                               |
    |-------------------------------------------------------------|---------------------------------------------------------|
    | - Fixed size (size must be defined at the time of creation) | - Dynamic size (can grow and shrink as needed) |
    | - Can hold primitive data types and objects                   | - Can only hold objects (not primitive data types)      |
    | - Provides faster access to elements (O(1) time complexity) | - Provides slower access to elements (O(n) time complexity) |

15. Difference between HashMap & TreeMap
    | HashMap                                                     | TreeMap                                                 |
    |-------------------------------------------------------------|---------------------------------------------------------|
    | - Unordered (does not maintain any order of elements)       | - Ordered (maintains elements in sorted order based on keys) |
    | - Allows one null key and multiple null values              | - Does not allow null keys (allows null values)         |
    | - Generally faster for basic operations (O(1) time complexity) | - Generally slower for basic operations (O(log n) time complexity) |

16. Difference between List, Set & Map
    | List                                                        | Set                                                     | Map                                                     |
    |-------------------------------------------------------------|---------------------------------------------------------|---------------------------------------------------------|
    | - Ordered collection of elements (allows duplicates)        | - Unordered collection of unique elements (no duplicates) | - Collection of key-value pairs (keys are unique, values can be duplicated) |
    | - Examples: ArrayList, LinkedList                           | - Examples: HashSet, TreeSet                          | - Examples: HashMap, TreeMap                            |

17. Difference between Iterator & ListIterator
    | Iterator                                                    | ListIterator                                            |
    |-------------------------------------------------------------|---------------------------------------------------------|
    | - Can be used to traverse any collection (List, Set, etc.) | - Can only be used to traverse List collections          |
    | - Supports forward traversal only                           | - Supports both forward and backward traversal          |
    | - Does not support modification of the collection during iteration | - Supports modification of the collection during iteration (add, remove, set) |

18. Difference between synchronized & concurrent collections
    | Synchronized Collections                                   | Concurrent Collections                                 |
    |-------------------------------------------------------------|---------------------------------------------------------|
    | - Use synchronization to ensure thread safety               | - Use advanced techniques (like lock-free algorithms) to ensure thread safety |
    | - Can lead to contention and performance bottlenecks      | - Generally provide better performance in multi-threaded environments |
    | - Examples: Collections.synchronizedList, Collections.synchronizedMap | - Examples: CopyOnWriteArrayList, ConcurrentHashMap    |

19. Difference between shallow copy & deep copy
    | Shallow Copy                                                | Deep Copy                                               |
    |-------------------------------------------------------------|---------------------------------------------------------|
    | - Creates a new object but copies references to nested objects | - Creates a new object and recursively copies all nested objects |
    | - Changes to nested objects in the copied object affect the original object | - Changes to nested objects in the copied object do not affect the original object |
    | - Faster and uses less memory                               | - Slower and uses more memory                           |

20. Difference between serialization & deserialization
    | Serialization                                               | Deserialization                                         |
    |-------------------------------------------------------------|---------------------------------------------------------|
    | - Process of converting an object into a byte stream        | - Process of converting a byte stream back into an object |
    | - Used for saving objects to files or sending them over a network | - Used for reading objects from files or receiving them over a network |
    | - Requires the class to implement Serializable interface | - Requires the class to implement Serializable interface |

21. Difference between transient & volatile
    | transient                                                   | volatile                                                |
    |-------------------------------------------------------------|---------------------------------------------------------|
    | - A keyword used to indicate that a field should not be serialized | - A keyword used to indicate that a field may be modified by multiple threads |
    | - Used in the context of serialization                     | - Used in the context of multi-threading                 |
    | - Prevents sensitive data from being serialized | - Ensures visibility of changes to variables across threads |

22. Difference between wait() & sleep()
    | wait()                                                      | sleep()                                                 |
    |-------------------------------------------------------------|---------------------------------------------------------|
    | - Releases the lock on the object and allows other threads to acquire it | - Does not release the lock on the object |
    | - Must be called within a synchronized block or method      | - Can be called from any context                        |
    | - Puts the thread in a waiting state until notified or interrupted | - Puts the thread to sleep for a specified duration     |
