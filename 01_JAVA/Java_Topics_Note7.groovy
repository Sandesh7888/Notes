
-----------------
Java 1.8 Features
-----------------

1. Functional Interface
  - An interface contains only one abstract method such interfaces are called functional interfaces.
  - Core elements of Functional Programming (Functional Interface, Lambda Expression, Method Reference and Stream API)
    ex: 
    ```
        @FunctionalInterface
        interface MyInterface {
            void display();
        }
        
        class Test implements MyInterface {
            public void display() {
                System.out.println("Hello, World!");
            }
        }
        
        public class Main {
            public static void main(String[] args) {
                MyInterface obj = new Test();
                obj.display(); // Output: Hello, World!
            }
        }
    ```

2. Types Of Functional Interfaces
    I. - Predefined Functional Interfaces in java.util.function package
        i) Predicate<T> : Represents a boolean-valued function of one argument.
        ii) Function<T, R> : Represents a function that accepts one argument and produces a result.
        iii) Consumer<T> : Represents an operation that accepts a single input argument and returns no result.
        iv) Supplier<T> : Represents a supplier of results.
        v) BiFunction<T, U, R> : Represents a function that accepts two arguments and produces a result.
        vi) BiPredicate<T, U> : Represents a predicate (boolean-valued function) of two arguments.

    II. User Defined Functional Interfaces
        - we can create your own functional interfaces by defining an interface with a single abstract method and By using @FunctionalInterface.
        ex:
        ```
            @FunctionalInterface
            interface MyFunctionalInterface {
                int add(int a, int b);
            }
            
            public class Main { 
                public static void main(String[] args) {
                    MyFunctionalInterface addition = (a, b) -> a + b;
                    System.out.println("Sum: " + addition.add(5, 3)); // Output: Sum: 8
                }
            }
        ```

3. Lambda Expressions
    - Lambda is it is a block of code doesn't have any modifier, return type and method name.
    - It is used to provide the implementation of functional interface.
    - we can represents the lambda expression by using the arrow operator (->).

    Syntax:
        (argument-list) -> {body-of-lambda}

    ex:
    ```
        @FunctionalInterface
        interface MyInterface {
            void display();
        }
        public class Main {
            public static void main(String[] args) {
                MyInterface obj = () -> System.out.println("Hello, World!");
                obj.display(); // Output: Hello, World!
            }
        }
    ```

    ex:
    ```
        @FunctionalInterface
        interface MyFunctionalInterface {
            int add(int a, int b);
        }
        
        public class Main { 
            public static void main(String[] args) {
                MyFunctionalInterface addition = (a, b) -> a + b;
                System.out.println("Sum: " + addition.add(5, 3)); // Output: Sum: 8
            }
        }
    ```

4. Valid syntax of Lambda Expressions
    - No parameter: () -> System.out.println("Hello, World!");
    - Single parameter: x -> x * x;
    - Multiple parameters: (x, y) -> x + y;
    - Multiple statements: (x, y) -> { int sum = x + y; return sum; };
    - With return keyword: (x, y) -> { return x + y; };
    - Without return keyword: (x, y) -> x + y; // Implicit return
    - Type inference: (int x, int y) -> x + y; // Explicit types
    - Using functional interface: MyInterface obj = () -> System.out.println("Hello, World!");
    - Using lambda with collections: list.forEach(item -> System.out.println(item));
    - Using lambda with streams: list.stream().filter(x -> x > 5).collect(Collectors.toList());

5. Functional Interface 
    - The Interface contains only one abstract method is called functional interface.
    - @FunctionalInterface -> Strictly defines the functional interface.

    * Working with Functional Interface

    i) Predicate
    - it is used for evaluating a condition or check the condition and returns boolean value.
    - it is a Functional Interface part of java.util.function package.
    - This interface having only one abstract method test().
    - Predicate<T> : T is the type of input to the predicate.
    - boolean test(T t) : This method evaluates the predicate on the given argument.

    ex:
    ```
        import java.util.function.Predicate;

        public class Main {
            public static void main(String[] args) {
                Predicate<Integer> isEven = (n) -> n % 2 == 0;

                System.out.println(isEven.test(4)); // Output: true
                System.out.println(isEven.test(5)); // Output: false

                Predicate<String> checkPassword = (s) -> {
                                                            if(s.equalsIgnoreCase("VivekDummyPass")) {
                                                                return true;
                                                            } else {
                                                                return false;
                                                            }
                                                        };
                System.out.println(checkPassword.test("VivekDummyPass")); // Output: true
                System.out.println(checkPassword.test("WrongPass")); // Output: false
            }
        }
    ```

    ii) Function
    - Function Interface is used to execute the business logic by taking input(T) of any type and will return output(R) of any type.
    - It is a functional interface part of java.util.function package.
    - This interface has only one abstract method apply().
    - Function<T, R> : T is the type of the input to the function and R is the type of the result of the function.
    - R apply(T t) : This method applies this function to the given argument.

    ex:
    ```
        import java.util.function.Function;

        public class Main {
            public static void main(String[] args) {
                Function<Integer, Integer> square = (n) -> n * n;

                System.out.println(square.apply(5)); // Output: 25
                System.out.println(square.apply(10)); // Output: 100


                Function<String, Integer> stringLength = (s) -> s.length();

                System.out.println(stringLength.apply("Hello")); // Output: 5
                System.out.println(stringLength.apply("Functional Interface")); // Output: 20


                Function<Integer, String> intToString = (Integer i) -> { return "Number: " + i; };
                System.out.println(intToString.apply(10)); // Output: Number: 10
            }
        }
    ```

    iii) Consumer
    - Consumer Interface is used to perform the business logic taking input(T) of any type and will not return any output
        (because the method return type is 'void').
    - It is a functional interface part of java.util.function package.
    - This interface has only one abstract method accept().
    - Consumer<T> : T is the type of the input to the operation.
    - void accept(T t) : This method performs this operation on the given argument.

    ex:
    ```
        import java.util.function.Consumer;

        public class Main {
            public static void main(String[] args) {
                Consumer<String> printMessage = (message) -> System.out.println("Message: " + message);

                printMessage.accept("Hello, World!"); // Output: Message: Hello, World!
                printMessage.accept("Functional Interface in Java 8"); // Output: Message: Functional Interface in Java 8
            }
        }
    ```

    iv) Supplier
    - Supplier Interface is used to return some value without taking any input.
    - It is a functional interface part of java.util.function package.
    - This interface has only one abstract method get().
    - Supplier<T> : T is the type of results supplied by this supplier.
    - T get() : This method gets a result.

    ex:
    ```
        import java.util.function.Supplier;
        import java.util.Random;

        public class Main {
            public static void main(String[] args) {
                Supplier<Double> randomValueSupplier = () -> Math.random();

                System.out.println("Random Value: " + randomValueSupplier.get());
                System.out.println("Random Value: " + randomValueSupplier.get());


                Supplier<Integer> randomIntSupplier = () -> new Random().nextInt(100); // Random integer between 0 and 99

                System.out.println("Random Integer: " + randomIntSupplier.get());
                System.out.println("Random Integer: " + randomIntSupplier.get());


                Supplier<String> stringSupplier = () -> "Hello, Supplier!";
                System.out.println(stringSupplier.get()); // Output: Hello, Supplier!

            }
        }
    ```

*** Note: all the above interfaces are useful when we are working with Lambda Expression. ***

6. Enhancements of Interface in Java 8 
- as of now in Interface contains only abstract methods and static final variables.
- But from Java 8 onwards, we can define a concrete method (a method with a method body) also in the interface.
- we can define the method with the method body by using two new keywords
    i) default : 
    ii) static
    ***Note: default and static keyword is mandatory to define the method with the method body.
    ex:
    ```
        interface MyInterface {
            // Abstract method
            void abstractMethod();

            // Default method
            default void defaultMethod() {
                System.out.println("This is a default method.");
            }

            // Static method
            static void staticMethod() {
                System.out.println("This is a static method.");
            }
        }

        class MyClass implements MyInterface {
            @Override
            public void abstractMethod() {
                System.out.println("Implementation of abstract method.");
            }
        }

        public class Main {
            public static void main(String[] args) {
                MyClass obj = new MyClass();
                obj.abstractMethod(); // Output: Implementation of abstract method.
                obj.defaultMethod();  // Output: This is a default method.
                
                MyInterface.staticMethod(); // Output: This is a static method.
            }
        }
    ```

7. Stream API
  - A Stream represents a sequence of elements from an Array or Collection, on top of which we can perform aggregate operations.
  - A Stream is a (T) Typed Interface which can operate on heterogeneous data and homogeneous data.
  - Stream is a part of the java.util.stream package.
  
    * Collections 
    - Collections are used to store a group of objects as a single unit.
    - Every collection object uses some internal data structure for organizing the elements in memory.
  
    * Stream
    - A Stream is used to store a group of objects as a single unit.
    - The elements of stream objects don't have an internal data structure for organizing the elements in memory.

  * Characteristics of Stream
    i) Element Sequence 
        - A Stream provides a set of elements of a particular type in a sequential manner.
        - The stream gets elements from the source on demand and never stores the elements.

    ii) Source
        - A Stream gets its elements from a source such as a collection, array, or I/O channel.


    iii) Operations
        - A Stream supports two types of operations:
            1. Intermediate Operations
                - These operations are lazy in nature.
                - These operations return the stream itself.
                - These operations are used to transform a stream into another stream.
                - These operations are used to filter, map, or sort the elements of a stream.
                - Examples: filter(), map(), sorted(), distinct(), limit(), skip()
            2. Terminal Operations
                - These operations are eager in nature.
                - These operations return a non-stream result, such as a primitive value, a collection, or no value at all (void).
                - These operations are used to produce a result or a side-effect.
                - Examples: forEach(), collect(), reduce(), count(), anyMatch(), allMatch(), noneMatch(), findFirst(), findAny()

    iv) Automatic Iteration
        - A Stream provides automatic iteration over the elements of a source.
        - We don't need to write explicit code for iterating the elements of a source.

  * Different ways for creating streams
    i) Creating an empty Stream
        - We can create an empty stream by using the static method `empty()` of the Stream interface.
        ex:
        ```
            import java.util.stream.Stream;

            public class Main {
                public static void main(String[] args) {
                    Stream<String> emptyStream = Stream.empty();
                    System.out.println("Empty Stream created successfully.");
                }
            }
        ```
    
    ii) Creating a Stream from a Collection
        - We can create a stream from a collection by using the `stream()` method of the Collection interface.
        ex:
        ```
            import java.util.Arrays;
            import java.util.List;
            import java.util.stream.Stream;
            public class Main {
                public static void main(String[] args) {
                    List<String> list = Arrays.asList("A", "B", "C", "D");
                    Stream<String> stream = list.stream();
                    stream.forEach(System.out::println);
                }
            }
        ```
    
    iii) Creating a Stream from an Array
        - We can create a stream from an array by using the static method `of()` of the Stream interface.
        ex:
        ```
            import java.util.stream.Stream;
            public class Main {
                public static void main(String[] args) {
                    String[] array = {"A", "B", "C", "D"};
                    Stream<String> stream = Stream.of(array);
                    stream.forEach(System.out::println);
                }
            }
        ```

    iv) Creating a Stream from Values
        - We can create a stream from a set of values by using the static method `of()` of the Stream interface.
        ex:
        ```
            import java.util.stream.Stream;
            public class Main {
                public static void main(String[] args) {
                    Stream<String> stream = Stream.of("A", "B", "C", "D");
                    stream.forEach(System.out::println);
                }
            }
        ```

8. Functional Interfaces 
   
   * Predicate : filtering the data or condition checking and returns a boolean value.
        filter(Predicate<T> predicate)
   * Function : it is used to execute business logic by taking input and will return output.
        map(Function<T, R> function)
   * Consumer : it is used to perform business logic taking input and will not return any output.
        forEach(Consumer<T> action)
   * Supplier : it is used to return some value without taking any input.
        get()


9. Internal working of Stream
   - we can apply n number of intermediate operations on a stream object and these operations will be executed only 
        when we invoke the terminal operation on the stream object.
   - Stream uses "pipelining" to connect operations together, and "lazy evaluation" to only process data when needed
   - Stream operations are always "LAZY" in nature.

   ex: 
    ```
          import java.util.Arrays;
          import java.util.List;
          import java.util.stream.Stream;
    
          public class Main {
                public static void main(String[] args) {
                 List<String> list = Arrays.asList("apple", "banana", "cherry", "date");
    
                 Stream<String> stream = list.stream()
                                              .filter(s -> {
                                                    System.out.println("Filtering: " + s);
                                                    return s.startsWith("a");
                                              })
                                              .map(s -> {
                                                    System.out.println("Mapping: " + s);
                                                    return s.toUpperCase();
                                              });
    
                 System.out.println("Stream created, but no operations executed yet.");
    
                 // Terminal operation
                 stream.forEach(s -> System.out.println("Final Output: " + s));
                }
          }
    ```
    Output:
          Stream created, but no operations executed yet.
          Filtering: apple
          Mapping: apple
          Final Output: APPLE
          Filtering: banana
          Filtering: cherry
          Filtering: date

10. Stream Operation using filter()
  - filter() method is from stream interface and type is Stream<T> object and which takes Predicate<T> functional interface as an parameter.
  - in order to call filter method we need an stream object.
  - filter() method is basically used for filtering the data over collection 

  syntax:
      Stream<T> filter(Predicate<T> predicate)

    ex: Traditional way
        ```
            import java.util.Arrays;
            import java.util.List;

            public class Main {
                public static void main(String[] args) {
                    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
                    System.out.println("Even Numbers:");
                    Iterator<Integer> iterator = numbers.iterator();
                    while (iterator.hasNext()) {
                        Integer number = iterator.next();
                        if (number % 2 == 0) {
                            System.out.println(number);
                        }
                    }
                }
            }
        ```

    ex: Using Stream and filter() method
        ```
            import java.util.Arrays;
            import java.util.List;
            import java.util.stream.Stream;
    
            public class Main {
                public static void main(String[] args) {
                    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    
                    // Create a stream from the list and filter even numbers
                    Stream<Integer> evenNumbersStream = numbers.stream()
                                                                .filter(n -> n % 2 == 0);
    
                    // Print the filtered even numbers
                    evenNumbersStream.forEach(System.out::println);
                }
            }
        ```
    Output:
        2
        4
        6
        8
        10
    

11. Stream Operation using map()
  - map() method is from stream interface and type is Stream<T> object and which takes Function<T, R> functional interface as an parameter.
  - in order to call map method we need an stream object.
  - map() method is basically used for transforming the data over collection 
    syntax:
        Stream<R> map(Function<T, R> function)

    ex: Traditional way
        ```
            import java.util.Arrays;
            import java.util.List;
            import java.util.ArrayList;

            public class Main {
                public static void main(String[] args) {
                    List<String> names = Arrays.asList("abc", "bcd", "dce", "abd");
                    List<String> upperCaseNames = new ArrayList<>();

                    for (String name : names) {
                        upperCaseNames.add(name.toUpperCase());
                    }

                    System.out.println("Uppercase Names:");
                    for (String name : upperCaseNames) {
                        System.out.println(name);
                    }
                }
            }
        ```

    ex: Using Stream and map() method
        ```
            import java.util.Arrays;
            import java.util.List;
            import java.util.stream.Stream;

            public class Main {
                public static void main(String[] args) {
                    List<String> names = Arrays.asList("abc", "bcd", "dce", "abd");

                    // Create a stream from the list and convert names to uppercase
                    Stream<String> upperCaseNamesStream = names.stream()
                                                               .map(name -> name.toUpperCase());

                    // Print the uppercase names
                    upperCaseNamesStream.forEach(System.out::println);
                }
            }
        ```

12. limit()
  - the purpose of limit() method is used to get fixed number of elements from the stream object.
  - limit() method is from stream interface and type is Stream<T> object and which takes long type value as an parameter.
  - limit() stream operation will comes under intermediate operation because return type is Stream<T> object.
  - in order to call limit method we need an stream object.
  - limit() method is basically used for limiting the number of elements over collection 
  
  note: if we apply negative value to limit() method then it will throw IllegalArgumentException at Runtime.

    syntax:
        Stream<T> limit(long maxSize)

    ex: Traditional way
        ```
            import java.util.Arrays;
            import java.util.List;
            import java.util.ArrayList;

            public class Main {
                public static void main(String[] args) {
                    List<String> names = Arrays.asList("abc", "bcd", "dce", "abd", "xyz", "pqr");
                    List<String> limitedNames = new ArrayList<>();

                    int limit = 3;
                    for (int i = 0; i < names.size() && i < limit; i++) {
                        limitedNames.add(names.get(i));
                    }

                    System.out.println("Limited Names:");
                    for (String name : limitedNames) {
                        System.out.println(name);
                    }
                }
            }
        ```

    ex: Using Stream and limit() method
        ```
            import java.util.Arrays;
            import java.util.List;
            import java.util.stream.Stream;

            public class Main {
                public static void main(String[] args) {
                    List<String> names = Arrays.asList("abc", "bcd", "dce", "abd", "xyz", "pqr");

                    // Create a stream from the list and limit to first 3 names
                    Stream<String> limitedNamesStream = names.stream()
                                                             .limit(3);

                    // Print the limited names
                    limitedNamesStream.forEach(System.out::println);
                }
            }
        ```
    Output:
        abc
        bcd
        dce

13. generate()
  - the purpose of generate() method is used to create infinite stream object by using Supplier<T> functional interface.
  - generate() method is from stream interface and type is Stream<T> object and which takes Supplier<T> functional interface as an parameter.
  - generate() stream operation will comes under intermediate operation because return type is Stream<T> object.
  - in order to call generate method we need an stream object.
  - generate() method is basically used for generating infinite number of elements over collection 
  
    syntax:
        static <T> Stream<T> generate(Supplier<T> s)

    ex: Using Stream and generate() method
        ```
            import java.util.stream.Stream;

            public class Main {
                public static void main(String[] args) {
                    // Create an infinite stream of random numbers
                    Stream<Double> randomNumbersStream = Stream.generate(() -> Math.random());

                    // Print the first 5 random numbers
                    randomNumbersStream.limit(5).forEach(System.out::println);
                }
            }
        ```
    Output:
        0.123456789
        0.987654321
        0.543216789
        0.678912345
        0.234567890

14. collect()
    - the purpose of collect() method is used to convert the stream object into collection object.
    - collect() method is from stream interface and type is R object and which takes Collector<T, A, R> functional interface as an parameter.
    - collect() stream operation will comes under terminal operation because return type is R object.
    - in order to call collect method we need an stream object.
    - collect() method is basically used for collecting the elements from stream object and store into collection object.
    
        syntax:
            <R, A> R collect(Collector<T, A, R> collector)
    
        ex: Using Stream and collect() method
            ```
                import java.util.Arrays;
                import java.util.List;
                import java.util.stream.Collectors;
                import java.util.stream.Stream;
    
                public class Main {
                    public static void main(String[] args) {
                        List<String> names = Arrays.asList("abc", "bcd", "dce", "abd");
    
                        // Create a stream from the list and convert names to uppercase
                        List<String> upperCaseNames = names.stream()
                                                         .map(name -> name.toUpperCase())
                                                         .collect(Collectors.toList());
    
                        // Print the uppercase names
                        upperCaseNames.forEach(System.out::println);
                    }
                }
            ```
        Output:
            ABC
            BCD
            DCE
            ABD

15. Collectors class
  - Collectors class provides various static methods to create different types of collection objects from stream elements.
  - Collectors class is a part of java.util.stream package.
  - Collectors class implements the Collector<T, A, R> interface.

    * Commonly used methods of Collectors class
        i) toList() : It is used to collect the elements of the stream and store them in a List.
            ex:
            ```
                import java.util.Arrays;
                import java.util.List;
                import java.util.stream.Collectors;

                public class Main {
                    public static void main(String[] args) {
                        List<String> names = Arrays.asList("abc", "bcd", "dce", "abd");

                        List<String> upperCaseNames = names.stream()
                                                           .map(name -> name.toUpperCase())
                                                           .collect(Collectors.toList());

                        upperCaseNames.forEach(System.out::println);
                    }
                }
            ```
        ii) toSet() : It is used to collect the elements of the stream and store them in a Set.
            ex:
            ```
                import java.util.Arrays;
                import java.util.List;
                import java.util.Set;
                import java.util.stream.Collectors;

                public class Main {
                    public static void main(String[] args) {
                        List<String> names = Arrays.asList("abc", "bcd", "dce", "abd", "abc");

                        Set<String> uniqueNames = names.stream()
                                                       .map(name -> name.toUpperCase())
                                                       .collect(Collectors.toSet());

                        uniqueNames.forEach(System.out::println);
                    }
                }
            ```
        iii) toMap() : It is used to collect the elements of the stream and store them in a Map.
            ex:
            ```
                import java.util.Arrays;
                import java.util.List;
                import java.util.Map;
                import java.util.stream.Collectors;

                public class Main {
                    public static void main(String[] args) {
                        List<String> names = Arrays.asList("abc", "bcd", "dce", "abd");

                        Map<String, Integer> nameLengthMap = names.stream()
                                                                  .collect(Collectors.toMap(
                                                                      name -> name,
                                                                      name -> name.length()
                                                                  ));
                        
                        nameLengthMap.forEach((name, length) -> 
                            System.out.println(name + ": " + length)
                        );
                    }
                }
            ```
        
        iv) joining() : It is used to concatenate the elements of the stream into a single String.
            ex:
            ```
                import java.util.Arrays;
                import java.util.List;
                import java.util.stream.Collectors;
                public class Main {
                    public static void main(String[] args) {
                        List<String> names = Arrays.asList("abc", "bcd", "dce", "abd");

                        String joinedNames = names.stream()
                                                  .collect(Collectors.joining(", "));

                        System.out.println(joinedNames);
                    }
                }
            ```
        Output:
            abc, bcd, dce, abd

        v) toUnmodifiableList() : It is used to collect the elements of the stream and store them in an unmodifiable List.
            ex:
            ```
                import java.util.Arrays;
                import java.util.List;
                import java.util.stream.Collectors;

                public class Main {
                    public static void main(String[] args) {
                        List<String> names = Arrays.asList("abc", "bcd", "dce", "abd");

                        List<String> unmodifiableNames = names.stream()
                                                              .collect(Collectors.toUnmodifiableList());

                        unmodifiableNames.forEach(System.out::println);

                        // Attempting to modify the unmodifiable list will throw UnsupportedOperationException
                        // unmodifiableNames.add("newName"); // Uncommenting this line will cause an exception
                    }
                }
            ```

        vi) toUnmodifiableSet() : It is used to collect the elements of the stream and store them in an unmodifiable Set.
            ex:
            ```
                import java.util.Arrays;
                import java.util.List;
                import java.util.Set;
                import java.util.stream.Collectors;
                public class Main {
                    public static void main(String[] args) {
                        List<String> names = Arrays.asList("abc", "bcd", "dce", "abd", "abc");

                        Set<String> unmodifiableNamesSet = names.stream()
                                                                .collect(Collectors.toUnmodifiableSet());

                        unmodifiableNamesSet.forEach(System.out::println);

                        // Attempting to modify the unmodifiable set will throw UnsupportedOperationException
                        // unmodifiableNamesSet.add("newName"); // Uncommenting this line will cause an exception
                    }
                }
            ```

        vii) toUnmodifiableMap() : It is used to collect the elements of the stream and store them in an unmodifiable Map.
            ex:
            ```
                import java.util.Arrays;
                import java.util.List;
                import java.util.Map;
                import java.util.stream.Collectors;
                public class Main {
                    public static void main(String[] args) {
                        List<String> names = Arrays.asList("abc", "bcd", "dce", "abd");
                        Map<String, Integer> unmodifiableNameLengthMap = names.stream()
                                                                              .collect(Collectors.toUnmodifiableMap(
                                                                                  name -> name,
                                                                                  name -> name.length()
                                                                              ));
                        
                        unmodifiableNameLengthMap.forEach((name, length) -> 
                            System.out.println(name + ": " + length)
                        );
                    
                        // Attempting to modify the unmodifiable map will throw UnsupportedOperationException
                        // unmodifiableNameLengthMap.put("newName", 7); // Uncommenting this line will cause an exception
                    }
                }
            ```
        Output:
            abc: 3
            bcd: 3
            dce: 3
            abd: 3

        viii) counting() : It is used to count the number of elements in the stream.
            ex:
            ```
                import java.util.Arrays;
                import java.util.List;
                import java.util.stream.Collectors;
                public class Main {
                    public static void main(String[] args) {
                        List<String> names = Arrays.asList("abc", "bcd", "dce", "abd");

                        long count = names.stream()
                                          .collect(Collectors.counting());

                        System.out.println("Number of names: " + count);
                    }
                }
            ```
        Output:
            Number of names: 4  



16. find the even no from the list of integers using stream and filter() method and collect() method
    ex: Using Stream, filter() method and collect() method
    ```
        import java.util.Arrays;
        import java.util.List;
        import java.util.stream.Stream;
        import java.util.stream.Collectors;
        public class Main {
            public static void main(String[] args) {
                List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

                // Create a stream from the list, filter even numbers and collect them into a list
                List<Integer> evenNumbers = numbers.stream()
                                                   .filter(n -> n % 2 == 0)
                                                   .collect(Collectors.toList());

                // Print the even numbers
                evenNumbers.forEach(System.out::println);
            }
        }
    ```
    Output:
        2
        4
        6
        8
        10

    

17. Function.identity()
  - the purpose of identity() method is used to return a function that always returns its input argument.
  - identity() method is from Function interface and type is Function<T, T> object and which doesn't take any parameter.
  - identity() method will comes under static method because return type is Function<T, T> object.
  - in order to call identity method we need an Function interface.
  - identity() method is basically used for returning the input argument as it is.

    syntax:
        static <T> Function<T, T> identity()

    ex: Using Function and identity() method
        ```
            import java.util.function.Function;

            public class Main {
                public static void main(String[] args) {
                    Function<String, String> identityFunction = Function.identity();

                    String input = "Hello, World!";
                    String output = identityFunction.apply(input);

                    System.out.println("Input: " + input);
                    System.out.println("Output: " + output);
                }
            }
        ```
    Output:
        Input: Hello, World!
        Output: Hello, World!

    ex: Using Stream collect() method with Function.identity()
        ```
            import java.util.Arrays;
            import java.util.List;
            import java.util.stream.Collectors;

            public class Main {
                public static void main(String[] args) {
                    List<String> names = Arrays.asList("abc", "bcd", "dce", "abd");

                    names.stream()
                         .map(Function.identity())
                         .forEach(System.out::println);


                    Map<String, String> collectedNames = names.stream()
                                                              .collect(Collectors.toMap(Function.identity(), name -> name.toUpperCase()));

                    collectedNames.forEach((name, upperCaseName) -> System.out.println(name + ": " + upperCaseName));
                }
            }
        ```

18. Method References
  - Method reference is a shorthand notation of a lambda expression to call a method.
  - Method reference is used to refer to a method without executing it.
  - Method reference is a part of java.util.function package.
  - Method reference is used to make the code more readable and concise.

    * Types of Method References
        i) Reference to a static method
            syntax:
                ClassName::staticMethodName

            ex:
            ```
                import java.util.Arrays;
                import java.util.List;

                public class Main {
                    public static void main(String[] args) {
                        List<String> names = Arrays.asList("abc", "bcd", "dce", "abd");

                        // Using lambda expression
                        names.forEach(name -> System.out.println(name.toUpperCase()));

                        // Using method reference
                        names.forEach(Main::printUpperCase);
                    }

                    public static void printUpperCase(String name) {
                        System.out.println(name.toUpperCase());
                    }
                }
            ```

        ii) Reference to an instance method of a particular object
            syntax:
                instance::instanceMethodName

            ex:
            ```
                import java.util.Arrays;
                import java.util.List;

                public class Main {
                    public static void main(String[] args) {
                        List<String> names = Arrays.asList("abc", "bcd", "dce", "abd");

                        // Using lambda expression
                        names.forEach(name -> System.out.println(name.toUpperCase()));

                        // Using method reference
                        Main main = new Main();
                        names.forEach(main::printUpperCase);
                    }

                    public void printUpperCase(String name) {
                        System.out.println(name.toUpperCase());
                    }
                }
            ```

        iii) Reference to an instance method of an arbitrary object of a particular type
            syntax:
                ClassName::instanceMethodName

            ex:
            ```
                import java.util.Arrays;
                import java.util.List;

                public class Main {
                    public static void main(String[] args) {
                        List<String> names = Arrays.asList("abc", "bcd", "dce", "abd");

                        // Using lambda expression
                        names.stream()
                             .map(name -> name.toUpperCase())
                             .forEach(System.out::println);

                        // Using method reference
                        names.stream()
                             .map(String::toUpperCase)
                             .forEach(System.out::println);
                    }
                }
            ```

19. Optional Class
    - Optional is a container object which may or may not contain a non-null value.
    - if a value is present, isPresent() method will return true and get() method will return the value.
    - Optional class is a part of java.util package.
    - Optional class is used to represent a value that may be absent, and to avoid null pointer exceptions.

    * Commonly used methods of Optional class
        i) of() : It is used to create an Optional object with a non-null value.
            ex:
            ```
                import java.util.Optional;

                public class Main {
                    public static void main(String[] args) {
                        Optional<String> optional = Optional.of("Hello, World!");

                        if (optional.isPresent()) {
                            System.out.println("Value: " + optional.get());
                        } else {
                            System.out.println("No value present.");
                        }
                    }
                }
            ```
        ii) ofNullable() : It is used to create an Optional object that may hold a null value.
            ex:
            ```
                import java.util.Optional;

                public class Main {
                    public static void main(String[] args) {
                        String value = null;
                        Optional<String> optional = Optional.ofNullable(value);

                        if (optional.isPresent()) {
                            System.out.println("Value: " + optional.get());
                        } else {
                            System.out.println("No value present.");
                        }
                    }
                }
            ```
        iii) empty() : It is used to create an empty Optional object.
            ex:
            ```
                import java.util.Optional;

                public class Main {
                    public static void main(String[] args) {
                        Optional<String> optional = Optional.empty();

                        if (optional.isPresent()) {
                            System.out.println("Value: " + optional.get());
                        } else {
                            System.out.println("No value present.");
                        }
                    }
                }
            ```
        iv) isPresent() : It is used to check if a value is present in the Optional object.
            ex:
            ```
                import java.util.Optional;

                public class Main {
                    public static void main(String[] args) {
                        Optional<String> optional = Optional.of("Hello, World!");

                        if (optional.isPresent()) {
                            System.out.println("Value is present.");
                        } else {
                            System.out.println("No value present.");
                        }
                    }
                }
            ```
        v) get() : It is used to retrieve the value from the Optional object. It throws NoSuchElementException if no value is present.
            ex:
            ```
                import java.util.Optional;

                public class Main {
                    public static void main(String[] args) {
                        Optional<String> optional = Optional.of("Hello, World!");

                        if (optional.isPresent()) {
                            String value = optional.get();
                            System.out.println("Value: " + value);
                        } else {
                            System.out.println("No value present.");
                        }
                    }
                }
            ```
        vi) orElse() : It is used to return the value if present, otherwise returns the specified default value.
            ex:
            ```
                import java.util.Optional;
                public class Main {
                    public static void main(String[] args) {
                        String value = null;
                        Optional<String> optional = Optional.ofNullable(value);

                        String result = optional.orElse("Default Value");
                        System.out.println("Result: " + result);
                    }
                }
            ```
        Output:
            Result: Default Value

20. Java8 Date and Time API
    - Java 8 introduced a new Date and Time API in the java.time package.
    - The new Date and Time API is immutable and thread-safe.
    - The new Date and Time API provides a more comprehensive set of classes for handling date and time.

    * Commonly used classes in the java.time package
        i) LocalDate : It represents a date (year, month, day) without time.
            ex:
            ```
                import java.time.LocalDate;

                public class Main {
                    public static void main(String[] args) {
                        LocalDate currentDate = LocalDate.now();
                        System.out.println("Current Date: " + currentDate);

                        LocalDate specificDate = LocalDate.of(2023, 10, 5);
                        System.out.println("Specific Date: " + specificDate);

                        LocalDate parsedDate = LocalDate.parse("2023-10-05");
                        System.out.println("Parsed Date: " + parsedDate);
                    }
                }
            ```
        ii) LocalTime : It represents a time (hour, minute, second, nanosecond) without date.
            ex:
            ```
                import java.time.LocalTime;

                public class Main {
                    public static void main(String[] args) {
                        LocalTime currentTime = LocalTime.now();
                        System.out.println("Current Time: " + currentTime);

                        LocalTime specificTime = LocalTime.of(14, 30, 0);
                        System.out.println("Specific Time: " + specificTime);

                        LocalTime parsedTime = LocalTime.parse("14:30:00");
                        System.out.println("Parsed Time: " + parsedTime);
                    }
                }
            ```
        iii) LocalDateTime : It represents a date-time (year, month, day, hour, minute, second, nanosecond).
            ex:
            ```
                import java.time.LocalDateTime;

                public class Main {
                    public static void main(String[] args) {
                        LocalDateTime currentDateTime = LocalDateTime.now();
                        System.out.println("Current Date-Time: " + currentDateTime);

                        LocalDateTime specificDateTime = LocalDateTime.of(2023, 10, 5, 14, 30, 0);
                        System.out.println("Specific Date-Time: " + specificDateTime);

                        LocalDateTime parsedDateTime = LocalDateTime.parse("2023-10-05T14:30:00");
                        System.out.println("Parsed Date-Time: " + parsedDateTime);
                    }
                }
            ```
        