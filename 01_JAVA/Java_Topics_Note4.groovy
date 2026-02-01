

159. InnerClasses
- sometimes we are creating a class inside a class is called inner class
- inner class is a class which is defined inside a class or inside a method
- inner class is also called nested class
- inner class is used to logically group classes that are only used in one place
- inner class is used to increase the encapsulation
- inner class is used to access the members of the outer class including private members
  ex:
  ```class Outer {
      private int data = 10;
      class Inner {
          public void display() {
              System.out.println("Data: " + data); // Accessing outer class private member
          }
      }
      public void show() {
          Inner inner = new Inner();
          inner.display();
      }
  }
  public class Test {
      public static void main(String[] args) {
          Outer outer = new Outer();
          outer.show();
      }
  }```
  Output:
  Data: 10

160. Types of Inner Classes

  1. Non-static Inner Class (Instance Inner Class)
  - Non-static inner class is a class which is defined inside a class and it is not declared as static
  - Non-static inner class can access the members of the outer class including private members
  - Non-static inner class can be instantiated only after instantiating the outer class
    ex:
    ```class Outer {
        private int data = 10;
        class Inner {
            public void display() {
                System.out.println("Data: " + data); // Accessing outer class private member
            }
        }
        public void show() {  
            Inner inner = new Inner();
            inner.display();
        }
    }
    public class Test {
        public static void main(String[] args) {
            Outer outer = new Outer();
            outer.show();
        }
    }```
    Output:
    Data: 10

  2. Static Inner Class (Static Nested Class)
  - Static inner class is a class which is defined inside a class and it is declared as static
  - Static inner class can access the static members of the outer class including private members
  - Static inner class can be instantiated without instantiating the outer class
    ex:
    ```class Outer {
        private static int data = 20;
        static class Inner {
            public void display() {
                System.out.println("Data: " + data); // Accessing outer class static member
            }
        }
    }
    public class Test {
        public static void main(String[] args) {
            Outer.Inner inner = new Outer.Inner(); // No need to instantiate Outer class
            inner.display();
        }
    }```
    Output:
    Data: 20

  3. Local Inner Class / Method Inner Class
  - Local inner class is a class which is defined inside a method
  - Local inner class can access the members of the outer class including private members
  - Local inner class can access the local variables of the method if they are declared as final
    ex:
    ```class Outer {
        private int data = 30;
        public void show() {
            final int localVar = 40; // Local variable must be final to be accessed by local inner class
            class Inner {
                public void display() {
                    System.out.println("Data: " + data); // Accessing outer class private member
                    System.out.println("Local Variable: " + localVar); // Accessing local variable
                }
            }
            Inner inner = new Inner();
            inner.display();
        }
    }
    public class Test {
        public static void main(String[] args) {
            Outer outer = new Outer();
            outer.show();
        }
    }```
    Output:
    Data: 30
    Local Variable: 40

  4. Anonymous Inner Class
  - Anonymous inner class is a class which is defined without a name
  - Anonymous inner class is used to provide implementation of an interface or to extend a class
  - Anonymous inner class can access the members of the outer class including private members
  - Anonymous inner class can access the local variables of the method if they are declared as final
    ex:
    ```interface MyInterface {
        void display();
    }
    class Outer {
        private int data = 50;
        public void show() {
            final int localVar = 60; // Local variable must be final to be accessed by anonymous inner class  
            MyInterface obj = new MyInterface() { // Anonymous inner class
                public void display() {
                    System.out.println("Data: " + data); // Accessing outer class private member
                    System.out.println("Local Variable: " + localVar); // Accessing local variable
                }
            };
            obj.display();
        }
    }
    public class Test {
        public static void main(String[] args) {
            Outer outer = new Outer();
            outer.show();
        } 
    }```
    Output:
    Data: 50
    Local Variable: 60

    *** Note : if we want to run any inner class 
        so step is like
            - javac Test.java
            - java Test$1  (for anonymous inner class)
            - java Test$Inner  (for non-static inner class)
            - java Test$1Inner (for local inner class)
            - java Outer$Inner (for static inner class)

161. Normal Java Class Vs Anonymous Inner Class
    1. Normal Java Class
    - Normal Java class is a class which is defined with a name
    - Normal Java class can be instantiated using new keyword
    - Normal Java class can have constructors
    - Normal Java class can be used to create multiple objects
    - Normal Java class can be defined in a separate file or inside another class
    - Normal Java class can extend only one class and implement multiple interfaces

    2. Anonymous Inner Class
        - Anonymous inner class is a class which is defined without a name
        - Anonymous inner class is used to provide implementation of an interface or to extend a class
        - Anonymous inner class can access the members of the outer class including private members
        - Anonymous inner class can access the local variables of the method if they are declared as final
        - Anonymous inner class is instantiated and defined at the same time
        - Anonymous inner class can be used to create only one object
        - Anonymous inner class can be defined inside a method or as an argument to a method
        - Anonymous inner class can extend only one class or implement only one interface
        ex:
        ```interface MyInterface {
            void display();
        }
        class NormalClass implements MyInterface {
            public void display() {
                System.out.println("Normal Class Display Method");
            }
        }
        public class Test {
            public static void main(String[] args) {    
                // Using Normal Java Class
                MyInterface obj1 = new NormalClass();
                obj1.display();

                // Using Anonymous Inner Class
                MyInterface obj2 = new MyInterface() { // Anonymous inner class
                    public void display() {
                        System.out.println("Anonymous Inner Class Display Method");
                    }
                };
                obj2.display();
            }
        }```

        Output:
        Normal Class Display Method
        Anonymous Inner Class Display Method

162. Normal java class vs Static Inner Class
    1. Normal Java Class
    - Normal Java class is a class which is defined with a name
    - Normal Java class can be instantiated using new keyword
    - Normal Java class can have constructors
    - Normal Java class can be used to create multiple objects
    - Normal Java class can be defined in a separate file or inside another class
    - Normal Java class can extend only one class and implement multiple interfaces

    2. Static Inner Class
    - Static inner class is a class which is defined inside a class and it is declared as static
    - Static inner class can access the static members of the outer class including private members
    - Static inner class can be instantiated without instantiating the outer class
    - Static inner class can have constructors
    - Static inner class can be used to create multiple objects
    - Static inner class is defined inside another class
    - Static inner class can extend only one class and implement multiple interfaces
    ex:
    ```class Outer {
        private static int data = 20;
        static class Inner {
            public void display() {
                System.out.println("Data: " + data); // Accessing outer class static member
            }
        }
    }
    public class Test {
        public static void main(String[] args) {
            Outer.Inner inner = new Outer.Inner(); // No need to instantiate Outer class
            inner.display();
        }
    }```


163. java.lang package
- java.lang package is a default package which is imported by default in every java program
- java.lang package contains classes which are fundamental to the design of the java programming language
- java.lang package contains classes which are used for basic operations like string manipulation, mathematical calculations,
  threading, system operations, etc.
- java.lang package contains classes like Object, String, StringBuffer, StringBuilder, Math, System, Thread, Throwable, Exception, Runtime, etc.
- java.lang package also contains wrapper classes like Integer, Float, Double, Character, Boolean, etc.
- java.lang package also contains classes for reflection like Class, Method, Field, etc.
- java.lang package also contains classes for annotations like Annotation, Deprecated, Override, etc.
- java.lang package also contains classes for number formatting like Number, Byte, Short, Long, etc.

164. Object class
- Object class is a superclass of all classes in java
- Object class is defined in java.lang package
- Object class contains most common methods which are used in all classes / objects
- Object class contains methods like toString(), equals(), hashCode(), getClass(), clone(), finalize(), etc.
- Object class is used to provide a common interface for all objects in java
- Object class is used to provide a default implementation of methods which can be overridden by subclasses

    Note: by default Object class is a superclass of all classes in java
          if we are not extending any class then also our class is extending Object class implicitly


165. Object class all methods
- toString(): to return string representation of the object
- hashCode(): Returns a hash code value for the object (used in hashing data structures like HashMap, HashSet).
- equals(Object obj): Compares the current object with the specified object for equality.
- getClass(): Returns the runtime class of the object (an instance of Class<?>).
- clone(): Creates and returns a copy (clone) of the object. (Class must implement Cloneable interface).
- finalize(): Called by the garbage collector before reclaiming the object’s memory (deprecated in Java 9, removed in Java 18).
- wait(): Causes the current thread to wait until another thread invokes notify() or notifyAll() on the same object.
- wait(long timeout): Same as wait(), but waits at most the specified number of milliseconds.
- wait(long timeout, int nanos): Same as wait(long), but allows nanosecond precision.
- notify(): Wakes up a single thread that is waiting on this object’s monitor.
- notifyAll(): Wakes up all threads that are waiting on this object’s monitor.

  * toString() method
    - toString() method is used to return string representation of the object
    - toString() method is defined in Object class
    - toString() method is overridden in String class, StringBuffer class, StringBuilder class, etc.
    - toString() method is used to print the object in a readable format
    ex:
    ```class Person {
        private String name;
        private int age;
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        @Override
        public String toString() {
            return "Person [name=" + name + ", age=" + age + "]";
        }
    }
    class Department {
        private String name;
        public Department(String name) {
            this.name = name;
        }
    }
    public class Test {
        public static void main(String[] args) {
            Person person = new Person("John", 25);
            System.out.println(person); // Implicitly calls toString() method
            System.out.println(person.toString()); // Explicitly calls toString() method

            Department dept = new Department("HR");
            System.out.println(dept); // Calls default toString() method from Object class
            System.out.println(dept.toString()); // Calls default toString() method from Object class
        }
    }```
    Output:
    Person [name=John, age=25]
    Person [name=John, age=25]
    Department@15db9742
    Department@15db9742

    * hashCode() method
    - hashCode() method is used to return hash code value for the object
    - hashCode() method is defined in Object class
    - hashCode() method is used in hashing data structures like HashMap, HashSet, etc.
    - hashCode() method is used to improve the performance of searching, inserting, deleting operations in hashing data structures
    - hashCode() method is overridden in String class, Integer class, etc.
    ex:
    ```class Person {
        private String name;
        private int age;
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        @Override
        public int hashCode() {
            return name.hashCode() + age;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Person person = (Person) obj;
            return age == person.age && name.equals(person.name);
        }
    }

    * equals() method
    - equals() method is used to compare the current object with the specified object for equality
    - equals() method is defined in Object class
    - equals() method is overridden in String class, Integer class, etc.
    - equals() method is used to compare the content of the objects
    - equals() method is used in hashing data structures like HashMap, HashSet, etc.
    ex:
    ```class Person {
        private String name;
        private int age;
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Person person = (Person) obj;
            return age == person.age && name.equals(person.name);
        }
        @Override
        public int hashCode() {
            return name.hashCode() + age;
        }
        }
    public class Test {
        public static void main(String[] args) {
            Person person1 = new Person("John", 25);
            Person person2 = new Person("John", 25);
            Person person3 = new Person("Jane", 30);
            System.out.println(person1.equals(person2)); // true
            System.out.println(person1.equals(person3)); // false
            System.out.println(person1.hashCode()); // hash code value
            System.out.println(person2.hashCode()); // hash code value
            System.out.println(person3.hashCode()); // hash code value
        }
    }```
    Output:
    true
    false
    hash code value
    hash code value
    hash code value

    ***** Note: if we are overriding equals() method then we must override hashCode() method also
          because if two objects are equal then their hash code must be same
          but if two objects are not equal then their hash code may be same or different


    * getClass() method
    - getClass() method is used to return the runtime class of the object
    - getClass() method is defined in Object class
    - getClass() method returns an instance of Class<?> which represents the class of the object
    ex:
    ```class Person {
        private String name;
        private int age;
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    public class Test {
        public static void main(String[] args) {
            Person person = new Person("John", 25);
            System.out.println(person.getClass()); // class Person
            System.out.println(person.getClass().getName()); // Person
            System.out.println(person.getClass().getSimpleName()); // Person
        }
    }```
    Output:
    class Person
    Person
    Person

    * clone() method
    - clone() method is used to create and return a copy (clone) of the object
    - clone() method is defined in Object class
    - clone() method is used to create a new object which is a copy of the existing object
    - clone() method is overridden in classes which implement Cloneable interface
    ex:
    ```class Person implements Cloneable {
        private String name;
        private int age;
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
    public class Test {
        public static void main(String[] args) {
            try {
                Person person1 = new Person("John", 25);
                Person person2 = (Person) person1.clone(); // Cloning person1
                System.out.println(person1 == person2); // false (different objects)
                System.out.println(person1.equals(person2)); // false (not overridden equals method)
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }```
    Output:
    false
    false

    **Note: if we are not implementing Cloneable interface then clone() method will throw CloneNotSupportedException
    **Note: we have to override clone() method and call super.clone() method to create a copy of the object and 
            must handle CloneNotSupportedException


    * finalize() :
    - finalize() is a method and its associated with garbage collector
    - Garbage collector handles a unused objects cleanup activity,
    - Garbage collector is a Automatic memory cleanup activity
    - if any unreferenced object have any cleanup activity then garbage collector calls finalize() method to 
      perform cleanup activity
    - once finalize() method completes execution then immediately garbage collector will destroy unreferenced object

    ex:
    ```class Person {
        private String name;
        private int age;
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        @Override
        protected void finalize() throws Throwable {
            System.out.println("Finalize method called for " + name);
        }
    }
    public class Test {
        public static void main(String[] args) {
            Person person1 = new Person("John", 25);
            Person person2 = new Person("Jane", 30);
            person1 = null; // person1 is now unreferenced
            System.gc(); // Suggesting JVM to run garbage collector
            // Adding a delay to ensure garbage collector has time to run
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }```
    Output:
    Finalize method called for John

    **Note: finalize() method is deprecated in Java 9 and removed in Java 18
          because it is not guaranteed that finalize() method will be called by garbage collector
          so it is not a reliable way to perform cleanup activity
          instead of finalize() method we can use try-with-resources or explicit resource management


    * wait()
    - wait() method is used to make the current thread to wait until another thread invokes notify() or notifyAll() 
        on the same object
    - wait() method must be called from a synchronized context (inside synchronized block or synchronized method

    * wait(long timeout)
    - wait(long timeout) method is used to make the current thread to wait until another thread invokes notify() or notifyAll() 
        on the same object or until the specified timeout expires

    * wait(long timeout, int nanos)
    - wait(long timeout, int nanos) method is used to make the current thread to wait until another thread invokes notify() or notifyAll() 
        on the same object or until the specified timeout expires with nanosecond precision

    * notify()
    - notify() method is used to wake up a single thread that is waiting on this object's monitor

    * notifyAll()
    - notifyAll() method is used to wake up all threads that are waiting on this object's monitor


166. toString() method And hashCode() method Internal Working
- if we are not overriding toString() method then default implementation of toString() method from Object class will be called
   in that case toString() method internally calls hashCode() method to get the hash code value of the object
   and then converts the hash code value to hexadecimal format and returns the string representation of the object
   ex:
   ```class Person {
       private String name;
       private int age;
       public Person(String name, int age) {    
           this.name = name;
           this.age = age;
       }
   }
   public class Test {
       public static void main(String[] args) {
           Person person = new Person("John", 25);
           System.out.println(person); // Implicitly calls toString() method
           System.out.println(person.toString()); // Explicitly calls toString() method
       }
   }```
   Output:
   Person@15db9742
   Person@15db9742
    

    **Note: if we are overriding toString() method then overridden toString() method will be called
            in that case hashCode() method will not be called

167. String class
- the object can hold sequence of characters is called String object
- String is the most commonly used class in java
- once we create a String object we cannot modify it, if we try to modify it then a new String object will be created
  ex:
  ```String str = "Hello"; // Creating a String object
  str = str + " World"; // Modifying the String object, a new String object will be created```
- String class is immutable (once we create a String object we cannot modify it)

 note: in string class .equals() method is overridden to compare the content of the string objects
       in string class hashCode() method is overridden to return the hash code value based on the content of the string object
       so if two string objects have same content then their hash code value will be same

         ex:
         ```String str1 = new String("Hello");
            String str2 = new String("Hello");
            System.out.println(str1.equals(str2)); // true
            System.out.println(str1.hashCode() == str2.hashCode()); // true```

168. String constant pool
- String constant pool is a special memory area in the heap memory where string literals are stored
   
   * Case study of String constant pool

   1) String name = "Vivek";
        - here "Vivek" is a string literal
        - when we create a string literal, JVM checks the string constant pool for the same string literal
        - if the string literal is found in the string constant pool, then the reference of the existing string object is returned
        - if the string literal is not found in the string constant pool, then a new string object is created in the string constant pool
            and its reference is returned

    2) String name = new String("Vivek");
        - here new keyword is used to create a string object
        - when we use new keyword, JVM creates a new string object in the heap memory
        - JVM does not check the string constant pool for the same string literal
        - so a new string object is created in the heap memory even if the same string literal is present in the string constant pool
        - but the string literal "Vivek" is stored in string constant pool, reused if it already present
        - so in new String("Vivek") → always creates a new object in the heap, but still ensures the literal "Vivek" exists in the SCP

    Note: Garbage collector does not remove string literals from the string constant pool.
        String literals stay in memory for the life of the program, while string objects created with new are removed if they are unreferenced.

169. String class important methods
- char charAt(int index): Returns the character at the specified index.
- int length(): Returns the length of the string.
- String substring(int beginIndex): Returns a new string that is a substring of this string, 
   starting from the specified index to the end of the string.
    ex: String str = "Hello World";
        System.out.println(str.substring(6)); // World
- String substring(int beginIndex, int endIndex): Returns a new string that is a substring of this string, 
    starting from the specified beginIndex to endIndex-1.
    ex: String str = "Hello World";
        System.out.println(str.substring(0, 5)); // Hello
- String concat(String str): Concatenates the specified string to the end of this string.
    ex: String str1 = "Hello";
        String str2 = " World";
        System.out.println(str1.concat(str2)); // Hello World
- boolean equals(Object obj): Compares this string to the specified object for equality.
- boolean equalsIgnoreCase(String str): Compares this string to the specified string for equality, ignoring case considerations.
- int compareTo(String str): Compares this string to the specified string lexicographically.
- int compareToIgnoreCase(String str): Compares this string to the specified string lexicographically, ignoring case considerations.
- String toLowerCase(): Converts all characters in this string to lowercase.
- String toUpperCase(): Converts all characters in this string to uppercase.
- String trim(): Removes leading and trailing whitespace from this string.
- String replace(char oldChar, char newChar): Returns a new string resulting from replacing all occurrences of oldChar in this string with newChar.
- String replace(CharSequence target, CharSequence replacement): Replaces each substring of this string that matches the literal target 
    sequence with the specified literal replacement


170. StringBuffer class
- StringBuffer class is used to create mutable string objects (once we create a StringBuffer object we can modify it)
- StringBuffer class is defined in java.lang package
- StringBuffer class is synchronized (thread-safe)
- StringBuffer class is slower than StringBuilder class because of synchronization
- StringBuffer class is faster than String class because String class is immutable
- StringBuffer class is used in multi-threaded environment where thread-safety is required
  ex:
  ```StringBuffer sb = new StringBuffer("Hello");
  sb.append(" World"); // Modifying the StringBuffer object
  System.out.println(sb); // Hello World``` 

    * constructor of StringBuffer class
    1) StringBuffer(): creates an empty StringBuffer object with default capacity of 16 
    2) StringBuffer(int capacity): creates an empty StringBuffer object with specified capacity
    3) StringBuffer(String str): creates a StringBuffer object with the specified string


    * important methods of StringBuffer class
    - StringBuffer append(String str): Appends the specified string to the end of this StringBuffer.
    - StringBuffer insert(int offset, String str): Inserts the specified string at the specified offset
       ex: StringBuffer sb = new StringBuffer("Hello");
           sb.insert(5, " World");
           System.out.println(sb); // Hello World
    - StringBuffer replace(int start, int end, String str): Replaces the characters in the specified range with the specified string
       ex: StringBuffer sb = new StringBuffer("Hello World");
           sb.replace(6, 11, "Java");
           System.out.println(sb); // Hello Java
    - StringBuffer delete(int start, int end): Deletes the characters in the specified range
       ex: StringBuffer sb = new StringBuffer("Hello World");
           sb.delete(5, 11);
           System.out.println(sb); // Hello
    - StringBuffer reverse(): Reverses the characters in this StringBuffer
       ex: StringBuffer sb = new StringBuffer("Hello");
           sb.reverse();
           System.out.println(sb); // olleH
    - int length(): Returns the length of the StringBuffer
    - int capacity(): Returns the current capacity of the StringBuffer
    - char charAt(int index): Returns the character at the specified index
    - void setCharAt(int index, char ch): Sets the character at the specified index
       ex: StringBuffer sb = new StringBuffer("Hello");
           sb.setCharAt(0, 'h');
           System.out.println(sb); // hello
    - String toString(): Converts this StringBuffer to a String
    - void ensureCapacity(int minimumCapacity): Ensures that the capacity is at least equal to the specified minimum capacity
    - void trimToSize(): Trims the capacity of this StringBuffer to be equal to its current size
       ex: StringBuffer sb = new StringBuffer(50);
           sb.append("Hello");
           System.out.println(sb.capacity()); // 50
           sb.trimToSize();
           System.out.println(sb.capacity()); // 5

171. StringBuilder class
- StringBuilder class is used to create mutable string objects (once we create a StringBuilder object we can modify it)
- StringBuilder class is defined in java.lang package
- StringBuilder class is not synchronized (not thread-safe)
- StringBuilder class is faster than StringBuffer class because it is not synchronized
- StringBuilder class is faster than String class because String class is immutable
- StringBuilder class is used in single-threaded environment where thread-safety is not required
  ex:
  ```StringBuilder sb = new StringBuilder("Hello");
  sb.append(" World"); // Modifying the StringBuilder object
  System.out.println(sb); // Hello World``` 

    * constructor of StringBuilder class
    - Note : same as StringBuffer class

    * important methods of StringBuilder class
    - Note : same as StringBuffer class

    *** Note : only difference between StringBuffer and StringBuilder class is
                StringBuffer class is synchronized (thread-safe)
                StringBuilder class is not synchronized (not thread-safe)
                so StringBuffer class is slower than StringBuilder class

172. StringBuffer vs StringBuilder
    1. StringBuffer
    - StringBuffer class is synchronized (thread-safe)
    - StringBuffer class is slower than StringBuilder class because of synchronization
    - threads are required to wait to get the lock on the StringBuffer object to access it, so it is slower
    - StringBuffer class is used in multi-threaded environment where thread-safety is required
    - introduced in JDK 1.0

    2. StringBuilder
    - StringBuilder class is not synchronized (not thread-safe)
    - StringBuilder class is faster than StringBuffer class because it is not synchronized
    - threads are not required to wait to get the lock on the StringBuilder object to access it, so it is faster
    - StringBuilder class is used in single-threaded environment where thread-safety is not required
    - introduced in JDK 1.5

    *** Note : if we are working in multi-threaded environment then we should use StringBuffer class
              if we are working in single-threaded environment then we should use StringBuilder class


173. String vs StringBuffer vs StringBuilder
    1. String
    - String class is immutable (once we create a String object we cannot modify it)
    - String class is slower than StringBuffer and StringBuilder class because of immutability
    - if we try to modify a String object then a new String object will be created
    - String class is used when we have less number of modifications to the string
    - String class is defined in java.lang package

    2. StringBuffer
    - StringBuffer class is mutable (once we create a StringBuffer object we can modify it)
    - StringBuffer class is synchronized (thread-safe)
    - StringBuffer class is slower than StringBuilder class because of synchronization
    - StringBuffer class is used in multi-threaded environment where thread-safety is required
    - StringBuffer class is defined in java.lang package

    3. StringBuilder
    - StringBuilder class is mutable (once we create a StringBuilder object we can modify it)
    - StringBuilder class is not synchronized (not thread-safe)
    - StringBuilder class is faster than StringBuffer class because it is not synchronized
    - StringBuilder class is used in single-threaded environment where thread-safety is not required
    - StringBuilder class is defined in java.lang package

    *** Note : 
        - Use StringBuffer in multi-threaded environments (thread-safe).
        - Use StringBuilder in single-threaded environments (faster).
        - Use String if you have few modifications.
        - Use StringBuffer or StringBuilder if you have many modifications.

174. Method Chaining concept
- Method chaining is a programming technique in which multiple method calls are chained together in a single statement
- Method chaining is achieved by returning the current object (this) from the method
- Method chaining is commonly used in classes like StringBuilder and StringBuffer to perform multiple operations on
  the same object in a single statement
  ex:
  ```StringBuilder sb = new StringBuilder();
  sb.append("Hello").append(" ").append("World").append("!").reverse();
  System.out.println(sb); // !dlroW olleH```

175. wrapper classes
- Wrapper classes are used to convert primitive data types into objects references
- Wrapper classes are used in collections like ArrayList, HashMap, etc. because collections can store only objects references
- Wrapper classes are used in generics because generics can store only objects references
- Wrapper classes are used in reflection because reflection can work only with objects references
- Wrapper classes are used in serialization because serialization can work only with objects references

  * constructors
  - Note : all wrapper classes have two constructors
    1) WrapperClassName(primitiveDataType value): creates a wrapper object with the specified primitive value
    2) WrapperClassName(String str): creates a wrapper object with the specified string value (string must be parsable to the primitive type)
       ex: Integer i = new Integer("123"); // valid
           Integer j = new Integer("abc"); // invalid, throws NumberFormatException
    
    * important methods of wrapper classes
    - static WrapperClassName valueOf(String str): returns a wrapper object with the specified string value (string must be parsable to the primitive type)
       ex: Integer i = Integer.valueOf("123"); // valid
           Integer j = Integer.valueOf("abc"); // invalid, throws NumberFormatException
    - static WrapperClassName valueOf(primitiveDataType value): returns a wrapper object with the specified primitive value
       ex: Integer i = Integer.valueOf(123);
    - primitiveDataType xxxValue(): returns the primitive value of the wrapper object
       ex: Integer i = Integer.valueOf(123);
           int j = i.intValue(); // returns 123
    - static primitiveDataType parseXxx(String str): parses the string and returns the primitive value (string must be parsable to the primitive type)
       ex: int i = Integer.parseInt("123"); // valid
           int j = Integer.parseInt("abc"); // invalid, throws NumberFormatException
    - String toString(): returns the string representation of the wrapper object
       ex: Integer i = Integer.valueOf(123);
           String str = i.toString(); // returns "123"
    - static String toString(primitiveDataType value): returns the string representation of the primitive value
       ex: String str = Integer.toString(123); // returns "123" 

176. Void class
- Void class is a wrapper class for the primitive type void
- Void class is defined in java.lang package
- Void class is used in reflection to represent the void return type of a method
- Void class has a single static field TYPE which represents the void type
  ex:
  ```import java.lang.reflect.Method;
  public class Test {
      public static void main(String[] args) throws Exception {
          Method method = Test.class.getMethod("myMethod");
          System.out.println(method.getReturnType() == Void.TYPE); // true
      }
      public static void myMethod() {
      }
  }```

    Output: true

177. AutoBoxing and UnBoxing
   
    * AutoBoxing
    - AutoBoxing is the automatic conversion of primitive data type to its corresponding wrapper class object

    ex:
    ```int i = 10;
    Integer obj = i; // AutoBoxing```
    - here int i is automatically converted to Integer obj

    * UnBoxing
    - UnBoxing is the automatic conversion of wrapper class object to its corresponding primitive data type
    ex:
    ```Integer obj = new Integer(10);
    int i = obj; // UnBoxing```
    - here Integer obj is automatically converted to int i

    * Note: AutoBoxing and UnBoxing is introduced in JDK 1.5
          AutoBoxing and UnBoxing is done by the compiler internally
          AutoBoxing and UnBoxing is used to make the code more readable and easier to write
          AutoBoxing and UnBoxing is used in collections and generics to store primitive data types as objects references

178. widening and narrowing concept
- Widening is the automatic conversion of a smaller data type to a larger data type
    ex:
    ```int i = 10;
    long l = i; // Widening```
    - here int i is automatically converted to long l

- Narrowing is the manual conversion of a larger data type to a smaller data type
    ex:
    ```long l = 10;
    int i = (int) l; // Narrowing```
    - here long l is manually converted to int i

179. relation between '==' operator and equals() method

    * '==' operator
    - '==' operator is used to compare the references of two objects
    - if two references are pointing to the same object then '==' operator returns true
    - if two references are pointing to different objects then '==' operator returns false
    ex:
    ```String str1 = new String("Hello");
    String str2 = new String("Hello");
    System.out.println(str1 == str2); // false```

    * equals() method
    - equals() method is used to compare the content of two objects
    - if two objects have the same content then equals() method returns true
    - if two objects have different content then equals() method returns false
    ex:
    ```String str1 = new String("Hello");
    String str2 = new String("Hello");
    System.out.println(str1.equals(str2)); // true```

180. clone() method internal working
- the process of creating a new object which is a copy of the existing object is called cloning
- main purpose of clonning is to maintain backup copy of the object
  syntax:
  ```protected Object clone() throws CloneNotSupportedException```

  ex:
    ```class Person implements Cloneable {
        private String name;
        private int age;
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
    public class Test {
        public static void main(String[] args) {
            try {
                Person person1 = new Person("John", 25);
                Person person2 = (Person) person1.clone(); // Cloning person1
                System.out.println(person1 == person2); // false (different objects)
                System.out.println(person1.equals(person2)); // false (not overridden equals method)
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }```
    Output:
    false
    false

    **Note: if we are not implementing Cloneable interface then clone() method will throw CloneNotSupportedException
    **Note: we have to override clone() method and call super.clone() method to create a copy of the object and 
            must handle CloneNotSupportedException

    
    * Shallow Cloning
    - Shallow Cloning is the process of creating a new object which is a copy of the existing object
    - In shallow cloning, if an object has a reference to another object, only the reference is copied, not the actual object. 
    - so both the objects will point to the same reference object
    - if we modify the reference object using one object, the change will be reflected in the other object as well
    - Shallow Cloning is done by default when we call super.clone() method
    ex:
    ```class Address {
        String city;
        public Address(String city) {
            this.city = city;
        }
    }
    class Person implements Cloneable {
        String name;
        Address address;
        public Person(String name, Address address) {
            this.name = name;
            this.address = address;
        }
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone(); // Shallow Cloning
        }
    }
    public class Test {
        public static void main(String[] args) {
            try {
                Address addr = new Address("Nagar");
                Person person1 = new Person("Vivek", addr);
                Person person2 = (Person) person1.clone(); // Cloning person1
                System.out.println(person1.address.city); // Nagar
                System.out.println(person2.address.city); // Nagar
                person2.address.city = "Pune"; // Modifying address of person2
                System.out.println(person1.address.city); // Pune (affected due to shallow cloning)
                System.out.println(person2.address.city); // Pune
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }```
    Output:
    Nagar
    Nagar
    Pune (affected due to shallow cloning)
    Pune

    * Deep Cloning
    - Deep Cloning is the process of creating a new object which is a copy of the existing object
    - In deep cloning, if an object has a reference to another object, both the object and the referenced object are cloned
    - so both the objects will point to different reference objects
    - if we modify the reference object using one object, the change will not be reflected in the other object
    - Deep Cloning is done by overriding clone() method and calling clone() method of the referenced object
    ex:
    ```class Address implements Cloneable {
        String city;
        public Address(String city) {
            this.city = city;
        }
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone(); // Cloning Address object
        }
    }
    class Person implements Cloneable {
        String name;
        Address address;
        public Person(String name, Address address) {
            this.name = name;
            this.address = address;
        }
        @Override
        protected Object clone() throws CloneNotSupportedException {
            Person cloned = (Person) super.clone(); // Shallow Cloning
            cloned.address = (Address) address.clone(); // Deep Cloning of Address object
            return cloned;
        }
    }
    public class Test {
        public static void main(String[] args) {
            try {
                Address addr = new Address("Nagar");
                Person person1 = new Person("Vivek", addr);
                Person person2 = (Person) person1.clone(); // Cloning person1
                System.out.println(person1.address.city); // Nagar
                System.out.println(person2.address.city); // Nagar
                person2.address.city = "Pune"; // Modifying address of person2
                System.out.println(person1.address.city); // Nagar (not affected due to deep cloning)
                System.out.println(person2.address.city); // Pune
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }```
    Output:
    Nagar
    Nagar
    Nagar (not affected due to deep cloning)
    Pune

-------------------------
* Collections Framework :
-------------------------
- Collections Framework is a unified architecture for representing and manipulating collections of objects
- Collections Framework is defined in java.util package
- Collections Framework provides a set of interfaces, classes and algorithms to store, retrieve and manipulate data

    - array is a indexed collection of fixed no of homogeneous data elements 
    - array can hold a fixed number of values of same type.
    - Advantages: the main Advantage of an array is we can represent n no of values by using a single variable , so that will 
       improve readability of the code.


    * limitations of array
    1) fixed size : once we create an array we cannot change its size, if we want to change its size then we have to create 
        a new array and copy the elements , so we always need to know the size of the array at the time of creation
    2) homogenious data : array can holds only same type of data elements , if we want to store different type of data elements 
        then we have to create different arrays for different data types
    3) no built-in methods : array does not provide any built-in methods to perform common operations like sorting, searching, etc
    4) no dynamic resizing : array does not support dynamic resizing, if we want to add or remove elements then we have to create a 
        new array and copy the elements
    5) no type safety : array does not provide type safety, we can store any type of data in an array, so we may get runtime errors
    6) no support for generics : array does not support generics, so we cannot create a generic array

    * Collections Framework advantages
    1) dynamic size : collections can grow and shrink dynamically as we add or remove elements
    2) heterogenious data : collections can store different types of data elements in a single collection
    3) built-in methods : collections provide a set of built-in methods to perform common operations like sorting, searching, etc
    4) dynamic resizing : collections support dynamic resizing, we can add or remove elements without creating a new collection
    5) type safety : collections provide type safety, we can create a collection of a specific type
    6) support for generics : collections support generics, we can create a generic collection

181. Difference between Arrays and Collections
    1) Size
    - Arrays have a fixed size, once we create an array we cannot change its size
    - Collections have a dynamic size, collections can grow and shrink dynamically as we add or remove elements

    2) Data types
    - Arrays can store only same type of data elements (homogenious data)
    - Collections can store different types of data elements in a single collection (heterogenious data)

    3) Built-in methods
    - Arrays do not provide any built-in methods to perform common operations like sorting, searching, etc
    - Collections provide a set of built-in methods to perform common operations like sorting, searching, etc

    4) Dynamic resizing
    - Arrays do not support dynamic resizing, if we want to add or remove elements then we have to create a new array and copy the elements
    - Collections support dynamic resizing, we can add or remove elements without creating a new collection

    5) Type safety
    - Arrays do not provide type safety, we can store any type of data in an array, so we may get runtime errors
    - Collections provide type safety, we can create a collection of a specific type

    6) Support for generics
    - Arrays do not support generics, so we cannot create a generic array
    - Collections support generics, we can create a generic collection

182. Collection I. (root interface)
- if we want to represent a group of individual objects as a single entity then we can use collection
- Collection is a root interface in the Collections Framework
- it contains several classes and interfaces to represent a group of individual objects as a single entity

183. Key interfaces of Collection Framework

    - Collection
    - List
    - Set
    - SortedSet
    - NavigableSet
    - Queue
    - Deque
    - Map
    - SortedMap
    - NavigableMap

184. Collection interface
- if we want to represent a group of indivisual objects as a single entity then we can use collection
- Collection has most common utility methods to perform operations on any collection object
- Collection interface is defined in java.util package and it is root interface of the Collections Framework
- there no direct implementation class of Collection interface

185. Important methods of Collection interface
- boolean add(E e): Adds the specified element to the collection
- boolean addAll(Collection<? extends E> c): Adds all the elements in the specified collection to this collection
- void clear(): Removes all the elements from the collection
- boolean contains(Object o): Returns true if the collection contains the specified element
- boolean containsAll(Collection<?> c): Returns true if the collection contains all the elements in the specified collection
- boolean isEmpty(): Returns true if the collection is empty
- Iterator<E> iterator(): Returns an iterator over the elements in the collection
- boolean remove(Object o): Removes a single instance of the specified element from the collection, if it is present
- boolean removeAll(Collection<?> c): Removes all the elements in the specified collection from this collection
- boolean retainAll(Collection<?> c): Retains only the elements in this collection that are contained in the specified collection
- int size(): Returns the number of elements in the collection
- Object[] toArray(): Returns an array containing all the elements in the collection
- <T> T[] toArray(T[] a): Returns an array containing all the elements in the collection; 
    the runtime type of the returned array is that of the specified array

186. Difference between Collection and Collections
    1) Collection
    - Collection is an interface in the Collections Framework
    - Collection interface is defined in java.util package
    - Collection interface is the root interface of the Collections Framework
    - Collection interface has several classes and interfaces to represent a group of objects as a single entity

    2) Collections
    - Collections is a utility class in the Collections Framework
    - Collections class is defined in java.util package
    - Collections class contains static methods that operate on or return collections objects
    - Collections class provides methods for sorting, searching, and manipulating collections objects

187. List interface
- List interface is a child interface of Collection interface
- if we want to represent a group of individual objects as a single entity where duplicates are allowed and insertion order is preserved
  then we should go for List interface
- there are three implementation classes of List interface
    1) ArrayList
    2) LinkedList
    3) Vector

188. Set interface
- Set interface is a child interface of Collection interface
- if we want to represent a group of individual objects as a single entity where duplicates are not allowed and insertion order is not preserved
  then we should go for Set interface
- there are three implementation classes of Set interface
    1) HashSet
    2) LinkedHashSet
    3) TreeSet

189. SortedSet interface
- SortedSet interface is a child interface of Set interface
- if we want to represent a group of indivisual objects as a single entity where dublicate are not allowed and insertion order is not preserved
  and the elements are sorted in ascending order then we should go for SortedSet interface
- there is one implementation class of SortedSet interface
    1) TreeSet

190. NavigableSet interface
- NavigableSet interface is a child interface of SortedSet interface
- if we want to represent a group of indivisual objects as a single entity where dublicate are not allowed and insertion order is not preserved
  and the elements are sorted in ascending order then we should go for NavigableSet interface

191. Difference between List and Set
    1) Dublicate elements
    - List allows dublicate elements
    - Set does not allow dublicate elements

    2) Insertion order
    - List - insertion order preserves
    - Set - insertion order not preserve it depends on implementation class

    3) Implementation classes
    - List has three implementation classes : ArrayList, LinkedList, Vector
    - Set has three implementation classes : HashSet, LinkedHashSet, TreeSet

    4) Accessing elements
    - List allows accessing elements by index
    - Set does not allow accessing elements by index

192. Queue interface
- Queue interface is a child interface of Collection interface
- if we want to represent a group of indivisual objects as a single entity where dublicate are allowed and insertion order is preserved
  and the elements are processed in FIFO (First In First Out) order then we should go for Queue interface
- there are two implementation classes of Queue interface
    1) PriorityQueue 
    2) BlockingQueue (sub-interface of Queue interface)
        - PriorityBlockingQueue (Class)
        - ArrayBlockingQueue (Class)  
        - LinkedBlockingQueue (Class)

193. Map interface

- Note: all above interfaces[Collection, List, Set, SortedSet, NavigableSet, Queue] 
            - are used to represent a group of indivisual objects as a single entity
        - but if we wan't to represent group of objects as key-value pair then we should go for Map interface

- Map interface is not a child interface of Collection interface
- if we want to represent a group of objects as key-value pair then we should go for Map interface
- in Map interface keys are unique and values can be dublicate and both keys and values should be objects
- there are three implementation classes of Map interface
    1) HashMap
    2) LinkedHashMap
    3) TreeMap
    4) Hashtable
    5) Properties (sub-class of Hashtable class)
    6) WeakHashMap
    7) IdentityHashMap


194. SortedMap interface
- SortedMap interface is a child interface of Map interface
- if we want to represent a group of objects as key-value pair according to some sorting order of keys then we should go for SortedMap interface
- in SortedMap the sorting order should be based on Key but not on Value
- there is one implementation class of SortedMap interface
    1) TreeMap

195. NavigableMap interface
- NavigableMap interface is a child interface of SortedMap interface
- if we want to represent a group of objects as key-value pair according to some sorting order of keys then we should go for NavigableMap interface
- in NavigableMap the sorting order should be based on Key but not on Value
- NavigableMap interface provides methods to navigate the map
- there is one implementation class of NavigableMap interface
    1) TreeMap


* Collection Framework Hierarchy
  Note: the following are legacy Characters present in Collection Framework
        1) Enumeration interface
        2) Vector class
        3) Stack class
        4) Hashtable class
        5) Properties class
        6) Dictionary class (abstract class)

    Note : For Collection Framework Hierarchy refer Images/Collection_Framework_Hierarchy.jpeg

    
196. Collection interface
    - 184 and 185

    Note : all collection classes are implementing Serializable and cloneable interfaces
           so all collection objects can be serialized and cloned
    Q. Why Serializable and Cloneable interfaces are implemented in all collection classes?
    - Serializable interface is implemented in all collection classes to make the collection objects serializable
    - Cloneable interface is implemented in all collection classes to make the collection objects cloneable

197. List interface
- if we want to represent a group of individual objects as a single entity where duplicates are allowed and insertion order is preserved
  then we should go for List interface
- List interface is a child interface of Collection interface
- we can preserve Insertion order with index and we can differentiate dublicate elements with index
   hence - Index will pay very important role in List interface

   * List interface defines following methods
    - Note : all methods of Collection interface are applicable to List interface + its own mwthods

   - void add(int index, E element): Inserts the specified element at the specified position in the list
   - boolean addAll(int index, Collection<? extends E> c): Inserts all the elements in the specified collection at the specified position in the list
   - E get(int index): Returns the element at the specified position in the list
   - int indexOf(Object o): Returns the index of the first occurrence of the specified element in the list, 
            or -1 if the list does not contain the element
        ex: List<String> list = new ArrayList<>();
            list.add("A");
            list.add("B");
            list.add("C");
            System.out.println(list.indexOf("B")); // 1
            System.out.println(list.indexOf("D")); // -1
   - int lastIndexOf(Object o): Returns the index of the last occurrence of the specified element in the list, 
            or -1 if the list does not contain the element
        ex: List<String> list = new ArrayList<>();
            list.add("A");
            list.add("B");
            list.add("C");
            list.add("B");
            System.out.println(list.lastIndexOf("B")); // 3
            System.out.println(list.lastIndexOf("D")); // -1
   - ListIterator<E> listIterator(): Returns a list iterator over the elements in the list
        ex: List<String> list = new ArrayList<>();
            list.add("A");
            list.add("B");
            list.add("C");
            ListIterator<String> it = list.listIterator();
            while(it.hasNext()) {
                System.out.println(it.next());
            }
            Output:
            A
            B
            C

   - ListIterator<E> listIterator(int index): Returns a list iterator over the elements in the list, starting at the specified position
        ex: List<String> list = new ArrayList<>();
            list.add("A");
            list.add("B");
            list.add("C");
            ListIterator<String> it = list.listIterator(1);
            while(it.hasNext()) {
                System.out.println(it.next());
            }
            Output:
            B
            C
   - E remove(int index): Removes the element at the specified position in the list
   - E set(int index, E element): Replaces the element at the specified position in the list with the specified element
   - List<E> subList(int fromIndex, int toIndex): Returns a view of the portion of the list between the specified fromIndex, 
        inclusive, and toIndex, exclusive
        ex: List<String> list = new ArrayList<>();
            list.add("A");
            list.add("B");
            list.add("C");
            List<String> subList = list.subList(0, 2);
            System.out.println(subList); // [A, B]
    

198. ArrayList class
- if we want to represent a group of indivisual objects as a single entity where dublicate are allowed and insertion order is preserved
  then we should go for ArrayList class
- underlying data structure of ArrayList class is resizable array or Growable array
- insertion order is preserved and dublicate are allowed
- heterogenious objects are allowed
- null insertion is allowed but only one null value is allowed

    *****Note: 
        - ArrayList is a best choice when the frequent operation is retrieval of data
            because ArrayList uses a resizable array, so it provides fast access to elements by index.  
        - ArrayList is the worst choice when the frequent operation is insertion and deletion of data in the middle
            because ArrayList uses a resizable array, inserting or deleting elements requires shifting, so these operations are slower.


    * constructors of ArrayList class
    - ArrayList(): creates an empty ArrayList with an initial capacity of 10
    - ArrayList(int initialCapacity): creates an empty ArrayList with the specified initial capacity
    - ArrayList(Collection<? extends E> c): creates an ArrayList with all elements from the given collection, keeping their order
        ex: List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
            System.out.println(list); // [A, B, C]
    - ArrayList(int initialCapacity, int capacityIncrement): creates an empty ArrayList with the specified initial capacity and capacity increment
        ex: ArrayList<String> list = new ArrayList<>(5, 3);
            System.out.println(list.size()); // 0
            System.out.println(list.capacity()); // 5
            list.add("A");
            list.add("B");
            list.add("C");
            list.add("D");
            list.add("E");
            System.out.println(list.size()); // 5
            System.out.println(list.capacity()); // 5
            list.add("F");
            System.out.println(list.size()); // 6
            System.out.println(list.capacity()); // 8 (5 + 3)

199. RandomAccess interface
- RandomAccess interface is a marker interface
- RandomAccess interface is implemented by ArrayList class
- RandomAccess interface is used to indicate that a List implementation supports fast (generally constant time) random access
- RandomAccess interface is used by algorithms to determine whether they can use random access
  or they should use sequential access
- RandomAccess interface does not contain any methods
    
200. How to get synchronized version of ArrayList object
- we can get synchronized version of ArrayList object by using Collections.synchronizedList() method
  ex:
  ```List<String> list = new ArrayList<>();
  List<String> synchronizedList = Collections.synchronizedList(list);```
- here synchronizedList is a synchronized version of list object and list is not synchronized

    Note: similarly we can get synchronized version of other collection objects by using following methods
        1) Collections.synchronizedSet(Set<T> s): returns a synchronized (thread-safe) set backed by the specified set
        2) Collections.synchronizedMap(Map<K,V> m): returns a synchronized (thread-safe) map backed by the specified map
        3) Collections.synchronizedCollection(Collection<T> c): returns a synchronized (thread-safe) collection backed by the specified collection

201. LinkedList
- if we want to represent a group of indivisual objects as a single entity where dublicate are allowed and insertion order is preserved
  then we should go for LinkedList class
- underlying data structure of LinkedList class is doubly linked list
- insertion order is preserved and dublicate are allowed
- heterogenious objects are allowed
- null insertion is allowed but only one null value is allowed
- LinkedList class implements List, Serializable and Cloneable interfaces but not RandomAccess interface

    *****Note:
            - LinkedList is a best choice when the frequent operation is insertion and deletion of data in the middle
                because LinkedList uses a doubly linked list, inserting or deleting elements does not require shifting, so these operations are faster.
            - LinkedList is the worst choice when the frequent operation is retrieval of data
                because LinkedList uses a doubly linked list, so accessing elements by index requires traversing the list, so this operation is slower.


    * constructors of LinkedList class
    - LinkedList(): creates an empty LinkedList
    - LinkedList(Collection<? extends E> c): creates a LinkedList with all elements from the given collection, keeping their order
        ex: List<String> list = new LinkedList<>(Arrays.asList("A", "B", "C"));
            System.out.println(list); // [ A, B, C ]
    
    * Important methods of LinkedList class
    - void addFirst(E e): Inserts the specified element at the beginning of the list
    - void addLast(E e): Appends the specified element to the end of the list
    - E getFirst(): Returns the first element in the list
    - E getLast(): Returns the last element in the list
    - E removeFirst(): Removes and returns the first element from the list
    - E removeLast(): Removes and returns the last element from the list
    - E peekFirst(): Retrieves, but does not remove, the first element of the list
    - E peekLast(): Retrieves, but does not remove, the last element of the list
    - E pollFirst(): Retrieves and removes the first element of the list
    - E pollLast(): Retrieves and removes the last element of the list
    - boolean offerFirst(E e): Inserts the specified element at the front of the list
    - boolean offerLast(E e): Inserts the specified element at the end of the list

    ex:
    ```LinkedList<String> list = new LinkedList<>();
    list.add("A");
    list.add("B");
    list.add("C");
    System.out.println(list); // [A, B, C]
    list.addFirst("D");
    System.out.println(list); // [D, A, B, C]
    list.addLast("E");
    System.out.println(list); // [D, A, B, C, E]
    System.out.println(list.getFirst()); // D
    System.out.println(list.getLast()); // E
    System.out.println(list.removeFirst()); // D
    System.out.println(list); // [A, B, C, E]
    System.out.println(list.removeLast()); // E
    System.out.println(list); // [A, B, C]
    System.out.println(list.peekFirst()); // A
    System.out.println(list.peekLast()); // C
    System.out.println(list.pollFirst()); // A
    System.out.println(list); // [B, C]
    System.out.println(list.pollLast()); // C
    System.out.println(list); // [B]
    list.offerFirst("F");
    System.out.println(list); // [F, B]
    list.offerLast("G");
    System.out.println(list); // [F, B, G]```

202. Difference between ArrayList vs LinkedList
    1) Underlying data structure
    - ArrayList uses a resizable array as its underlying data structure
    - LinkedList uses a doubly linked list as its underlying data structure

    2) Accessing elements
    - ArrayList allows fast access to elements by index (constant time O(1))
    - LinkedList requires traversing the list to access elements by index (linear time O(n))

    3) Insertion and deletion
    - ArrayList requires shifting elements when inserting or deleting elements in the middle (linear time O(n))
    - LinkedList allows fast insertion and deletion of elements in the middle (constant time O(1))

    4) Memory usage
    - ArrayList uses less memory per element because it stores elements in a contiguous block of memory
    - LinkedList uses more memory per element because it stores additional pointers for each element

    5) Performance
    - ArrayList is generally faster for accessing elements and iterating through the list
    - LinkedList is generally faster for inserting and deleting elements in the middle of the list

203. Vector class
- if we want to represent a group of indivisual objects as a single entity where dublicate are allowed and insertion order is preserved
  then we should go for Vector class
- underlying data structure of Vector class is resizable array or Growable array
- insertion order is preserved and dublicate are allowed
- heterogenious objects are allowed
- null insertion is allowed but only one null value is allowed
- every method of Vector class is synchronized (thread-safe)
- at a time only one thread can access the Vector object so it is thread-safe
- relatively performance is low because it is synchronized
- Vector class implements List, Serializable and Cloneable interfaces but not RandomAccess interface

    * constructors of Vector class
    - Vector(): creates an empty Vector with an initial capacity of 10
    - Vector(int initialCapacity): creates an empty Vector with the specified initial capacity
    - Vector(int initialCapacity, int capacityIncrement): creates an empty Vector with the specified initial capacity and capacity increment
    - Vector(Collection<? extends E> c): creates a Vector with all elements from the given collection, keeping their order
        ex: List<String> list = new Vector<>(Arrays.asList("A", "B", "C"));
            System.out.println(list); // [A, B, C]
    - Vector(int initialCapacity, int capacityIncrement): creates an empty Vector with the specified initial capacity and capacity increment
        ex: Vector<String> list = new Vector<>(5, 3);
            System.out.println(list.size()); // 0
            System.out.println(list.capacity()); // 5
            list.add("A");
            list.add("B");
            list.add("C");
            list.add("D");
            list.add("E");
            System.out.println(list.size()); // 5
            System.out.println(list.capacity()); // 5
            list.add("F");
            System.out.println(list.size()); // 6
            System.out.println(list.capacity()); // 8 (5 + 3)

    * methods of Vector class
    - int capacity(): Returns the current capacity of the vector
    - void trimToSize(): Trims the capacity of the vector to be the vector's current size
        ex: Vector<String> list = new Vector<>(5, 3);
            System.out.println(list.size()); // 0
            System.out.println(list.capacity()); // 5
            list.add("A");
            list.add("B");
            list.add("C");
            System.out.println(list.size()); // 3
            System.out.println(list.capacity()); // 5
            list.trimToSize();
            System.out.println(list.size()); // 3
            System.out.println(list.capacity()); // 3

    - Enumeration<E> elements(): Returns an enumeration of the components of the vector
    - void ensureCapacity(int minCapacity): Increases the capacity of the vector, if necessary, 
        to ensure that it can hold at least the number of components specified by the minimum capacity argument
    - E elementAt(int index): Returns the component at the specified index
    - void setElementAt(E obj, int index): Sets the component at the specified index to be the specified object
    - void removeElementAt(int index): Removes the component at the specified index
    - boolean removeElement(Object obj): Removes the first occurrence of the specified object from the vector
    - void insertElementAt(E obj, int index): Inserts the specified object as a component at the specified index
    - void addElement(E obj): Adds the specified object to the end of the vector
    - void removeAllElements(): Removes all components from the vector


204. Difference between ArrayList vs Vector

    * ArrayList
    - if we want to represent a group of indivisual objects as a single entity where dublicate are allowed and insertion order is preserved
      then we should go for ArrayList class
    - every method of ArrayList class is not synchronized (not thread-safe)
    - at a time multiple threads can access the ArrayList object so it is not thread-safe
    - relatively performance is high because it is not synchronized
    - introduced in JDK 1.2 (Not a legacy class)

    * Vector
    - if we want to represent a group of indivisual objects as a single entity where dublicate are allowed and insertion order is preserved
      then we should go for Vector class
    - every method of Vector class is synchronized (thread-safe)
    - at a time only one thread can access the Vector object so it is thread-safe
    - relatively performance is low because it is synchronized
    - introduced in JDK 1.0 (legacy class)


205. Stack class
- Stack class is a subclass of Vector class
- Stack class represents a last-in-first-out (LIFO) stack of objects
- Stack class extends Vector class and inherits all its methods
- Stack class provides additional methods to perform stack operations

    * methods of Stack class
    - E push(E item): Pushes an item onto the top of the stack
    - E pop(): Removes and returns the item at the top of the stack
    - E peek(): Returns the item at the top of the stack without removing it
    - boolean isEmpty(): Returns true if the stack is empty
    - int search(Object o): Returns the 1-based position of the object on the stack
        ex: Stack<String> stack = new Stack<>();
            stack.push("A");
            stack.push("B");
            stack.push("C");
            System.out.println(stack.search("B")); // 2
            System.out.println(stack.search("D")); // -1


206. The Cursors in Collection Framework
- if we want to get objects one by one from a collection object then we should go for Cursor
- Cursor is an object that enables us to traverse through a collection of objects
- there are three types of cursors in Collection Framework
    1) Enumeration 
    2) Iterator
    3) ListIterator

207. Enumeration interface
- Enumeration interface is a legacy cursor
- we can use Enumeration interface to get objects one by one from legacy collection objects like Vector, Hashtable, Properties
- we can create Enumeration object by calling elements() method of legacy collection objects like Vector, Hashtable, Properties
   syntax of elements() method
    - Enumeration<E> elements(): Returns an enumeration of the components of the vector

    ex:
    ```Vector<String> vector = new Vector<>();
    vector.add("A");
    vector.add("B");
    vector.add("C");
    Enumeration<String> enumeration = vector.elements();
    while(enumeration.hasMoreElements()) {
        System.out.println(enumeration.nextElement());
    }```
    Output:
    A
    B
    C

    ex:
    ```Hashtable<Integer, String> hashtable = new Hashtable<>();
    hashtable.put(1, "A");
    hashtable.put(2, "B");
    hashtable.put(3, "C");
    Enumeration<String> enumeration = hashtable.elements();
    while(enumeration.hasMoreElements()) {
        System.out.println(enumeration.nextElement());
    }```
    Output:
    A
    B
    C

    * Enumeration interface defines following methods
    - boolean hasMoreElements(): Returns true if the enumeration has more elements
    - E nextElement(): Returns the next element in the enumeration

    * Limitations of Enumeration interface
    -  Enumeration interface does not provide remove() method to remove elements from the collection object
       so we cannot remove elements from the collection object while iterating through the collection object
       hence it is not a fail-safe cursor
    -  Enumeration interface can be used only with legacy collection objects like Vector, Hashtable, Properties
       so it is not a universal cursor
    
208. Iterator interface
- Iterator interface is a universal cursor
- we can use Iterator interface to get objects one by one from any collection object
- we can create Iterator object by calling iterator() method of any collection object
   syntax of iterator() method
    - Iterator<E> iterator(): Returns an iterator over the elements in the collection
    ex:
    ```List<String> list = new ArrayList<>();
    list.add("A");
    list.add("B");
    list.add("C");
    Iterator<String> iterator = list.iterator();
    while(iterator.hasNext()) {
        System.out.println(iterator.next());
    }```
    Output:
    A
    B
    C

    * Iterator interface defines following methods
    - boolean hasNext(): Returns true if the iteration has more elements
    - E next(): Returns the next element in the iteration
    - void remove(): Removes from the underlying collection the last element returned by this iterator

    * Advantages of Iterator interface over Enumeration interface
    -  Iterator interface provides remove() method to remove elements from the collection object
       so we can remove elements from the collection object while iterating through the collection object
       hence it is a fail-safe cursor
    -  Iterator interface can be used with any collection object
       so it is a universal cursor

    * Limitations of Iterator interface
    -  by using Enumeration and Iterator we can always move only in forward direction
       so we cannot move in backward direction in the collection object
    - we can perform only read and remove operations on the collection object
       so we cannot add elements to the collection object while iterating through the collection object
    -  Iterator interface can be used only with collection objects
       so we cannot use Iterator interface with Map objects


209. ListIterator interface
- ListIterator interface is a universal cursor
- we can use ListIterator interface to get objects one by one from any List object
- by using ListIterator we can move in both forward and backward directions in the List object
- by using ListIterator we can perform read, remove and add operations on the List object
- we can create ListIterator object by calling listIterator() method of any List object
   syntax of listIterator() method
    - ListIterator<E> listIterator(): Returns a list iterator over the elements in the list
    - ListIterator<E> listIterator(int index): Returns a list iterator over the elements in the list, starting at the specified position

    ex:
    ```List<String> list = new ArrayList<>();
    list.add("A");
    list.add("B");
    list.add("C");
    ListIterator<String> listIterator = list.listIterator();
    while(listIterator.hasNext()) {
        System.out.println(listIterator.next());
    }```
    Output:
    A
    B
    C

    ex:
    ```List<String> list = new ArrayList<>();
    list.add("A");
    list.add("B");
    list.add("C");
    ListIterator<String> listIterator = list.listIterator(1);
    while(listIterator.hasNext()) {
        System.out.println(listIterator.next());
    }```
    Output:
    B
    C


    * ListIterator interface defines following methods

        Note: all methods of Iterator interface are applicable to ListIterator interface + its own methods 

            - boolean hasNext(): Returns true if the iteration has more elements
            - E next(): Returns the next element in the iteration
            - int nextIndex(): Returns the index of the element that would be returned by a subsequent call to next()

            - boolean hasPrevious(): Returns true if there are more elements when traversing the list in the reverse direction
            - E previous(): Returns the previous element in the list and moves the cursor position backwards
            - int previousIndex(): Returns the index of the element that would be returned by a subsequent call to previous()

            - void set(E e): Replaces the last element returned by next() or previous() with the specified element
            - void add(E e): Inserts the specified element into the list (optional operation)
            - void remove(): Removes from the underlying collection the last element returned by this iterator

    ex:
    ```List<String> list = new ArrayList<>();
    list.add("A");
    list.add("B");
    list.add("C");
    ListIterator<String> listIterator = list.listIterator();
    while(listIterator.hasNext()) {
        System.out.println(listIterator.next());
    }
    while(listIterator.hasPrevious()) {
        System.out.println(listIterator.previous());
    }```
    Output:
    A
    B
    C
    C
    B
    A

    ex:
    ```List<String> list = new ArrayList<>();
    list.add("A");
    list.add("B");
    list.add("C");
    ListIterator<String> listIterator = list.listIterator();
    while(listIterator.hasNext()) {
        String element = listIterator.next();
        if(element.equals("B")) {
            listIterator.set("D");
        }
    }
    System.out.println(list); // [A, D, C]```

    ex:
    ```List<String> list = new ArrayList<>();
    list.add("A");
    list.add("B");
    list.add("C");
    ListIterator<String> listIterator = list.listIterator();
    while(listIterator.hasNext()) {
        String element = listIterator.next();
        if(element.equals("B")) {
            listIterator.add("D");
        }
    }
    System.out.println(list); // [A, B, D, C]```

    ex:
    ```List<String> list = new ArrayList<>();
    list.add("A");
    list.add("B");
    list.add("C");
    ListIterator<String> listIterator = list.listIterator();
    while(listIterator.hasNext()) {
        String element = listIterator.next();
        if(element.equals("B")) {
            listIterator.remove();
        }
    }
    System.out.println(list); // [A, C]```

    ***** Note:
        - Most powerful cursor in Collection Framework is ListIterator but it's limitation is it is applicable only for List objects

210. Comparison table of Cursors in Collection Framework

    Property          | Enumeration         | Iterator            | ListIterator
----------------------|---------------------|---------------------|---------------------
Type                  | Legacy cursor       | Universal cursor    | Universal cursor
Collection types      | Legacy collections  | All collections     | Only List collections
Direction             | Forward only        | Forward only        | Both directions
Operations            | Read only           | Read and remove     | Read, remove, and add
Fail-safe             | No                  | Yes                 | Yes
Modification          | No                  | Yes                 | Yes
-----------------------------------------------------------------------------------------

211. Set interface
- if we want to represent a group of individual objects as a single entity where duplicates are not allowed and insertion order is not preserved
  then we should go for Set interface
- Set interface is a child interface of Collection interface
- set interface doesn't provide any methods so we have to use Collection interface methods to perform operations on Set objects
- all implementation classes of Set interface are not synchronized (not thread-safe)


- there are three implementation classes of Set interface
    1) HashSet
    2) LinkedHashSet
    3) TreeSet

    Note: all three implementation classes of Set interface are implementing Serializable and Cloneable interfaces
          so all Set objects can be serialized and cloned but not RandomAccess interface
    
212. HashSet class
- if we want to represent a group of indivisual objects as a single entity where dublicate are not allowed and insertion order is not preserved
  then we should go for HashSet class
- underlying data structure of HashSet class is HashMap
- insertion order is not preserved and it is base on hashcode of the objects
- dublicate elements are not allowed
- heterogenious objects are allowed
- null insertion is allowed but only one null value is allowed
- HashSet class implements Set, Serializable and Cloneable interfaces but not RandomAccess interface
- every method of HashSet class is not synchronized (not thread-safe)

    Note: HashSet is the best choice when frequent operation is searching
    Note: in HashSet dublicates are not allowed if we are trying to insert dublicate object then we won't get any compile time error or runtime error
          but the dublicate object will not be inserted into the HashSet object

    * constructors of HashSet class
    - HashSet(): creates an empty HashSet with an initial capacity of 16 and load factor of 0.75
    - HashSet(int initialCapacity): creates an empty HashSet with the specified initial capacity and load factor of 0.75
    - HashSet(int initialCapacity, float loadFactor): creates an empty HashSet with the specified initial capacity and load factor
    - HashSet(Collection<? extends E> c): creates a HashSet with all elements from the given collection, keeping their order
        ex: Set<String> set = new HashSet<>(Arrays.asList("A", "B", "C"));
            System.out.println(set); // [A, B, C]
    - HashSet(int initialCapacity, float loadFactor, boolean dummy): creates an empty HashSet with the specified initial capacity, 
            load factor and dummy value
        ex: HashSet<String> set = new HashSet<>(5, 0.75f, true);
            System.out.println(set.size()); // 0
            System.out.println(set.isEmpty()); // true
            set.add("A");
            set.add("B");
            set.add("C");
            System.out.println(set.size()); // 3
            System.out.println(set.isEmpty()); // false

    * Important methods of HashSet class
    - float loadFactor(): Returns the load factor of the HashSet
    - int capacity(): Returns the current capacity of the HashSet
    - void trimToSize(): Trims the capacity of the HashSet to be the HashSet's current size
        ex: HashSet<String> set = new HashSet<>(5, 0.75f);
            System.out.println(set.size()); // 0
            System.out.println(set.capacity()); // 5
            set.add("A");
            set.add("B");
            set.add("C");
            System.out.println(set.size()); // 3
            System.out.println(set.capacity()); // 5
            set.trimToSize();
            System.out.println(set.size()); // 3
            System.out.println(set.capacity()); // 3

    - void ensureCapacity(int minCapacity): Increases the capacity of the HashSet, if necessary, 
        to ensure that it can hold at least the number of components specified by the minimum capacity argument
    - Spliterator<E> spliterator(): Creates a late-binding and fail-fast Spliterator over the elements in the HashSet
        ex: HashSet<String> set = new HashSet<>();
            set.add("A");
            set.add("B");
            set.add("C");
            Spliterator<String> spliterator = set.spliterator();
            spliterator.forEachRemaining(System.out::println);
            Output:
            A
            B
            C

    - Iterator<E> iterator(): Returns an iterator over the elements in the HashSet
        ex: HashSet<String> set = new HashSet<>();
            set.add("A");
            set.add("B");
            set.add("C");
            Iterator<String> iterator = set.iterator();
            while(iterator.hasNext()) {
                System.out.println(iterator.next());
            }
            Output:
            A
            B
            C

    - Object[] toArray(): Returns an array containing all elements in the HashSet
        ex: HashSet<String> set = new HashSet<>();
            set.add("A");
            set.add("B");
            set.add("C");
            Object[] array = set.toArray();
            System.out.println(Arrays.toString(array)); // [A, B, C]
    - <T> T[] toArray(T[] a): Returns an array containing all elements in the HashSet; the runtime type of the returned array 
        is that of the specified array
        ex; HashSet<String> set = new HashSet<>();
            set.add("A");
            set.add("B");
            set.add("C");
            String[] array = set.toArray(new String[0]);
            System.out.println(Arrays.toString(array)); // [A, B, C]

213. Fill ratio / Load factor in HashSet
- Load factor is a measure of how full the HashSet is allowed to get before its capacity is automatically increased
- Load factor is a float value between 0 and 1
- Default load factor of HashSet is 0.75
- when the number of elements in the HashSet exceeds the product of the load factor and the current capacity,
  the capacity of the HashSet is automatically increased
- we can specify the load factor while creating the HashSet object
   ex: HashSet(int initialCapacity, float loadFactor): creates an empty HashSet with the specified initial capacity and load factor
        ex: HashSet<String> set = new HashSet<>(5, 0.5f);
            System.out.println(set.size()); // 0
            System.out.println(set.capacity()); // 5
            set.add("A");
            set.add("B");
            set.add("C");
            System.out.println(set.size()); // 3
            System.out.println(set.capacity()); // 5
            set.add("D");
            System.out.println(set.size()); // 4
            System.out.println(set.capacity()); // 10 (5 * 0.5 = 2.5, 5 + 5 = 10)
            set.add("E");
            System.out.println(set.size()); // 5
            System.out.println(set.capacity()); // 10


214. LinkedHashSet class
- if we want to represent a group of indivisual objects as a single entity where dublicate are not allowed and insertion order is preserved
  then we should go for LinkedHashSet class
- it is a subclass of HashSet class
- LinkedHashSet class is same as HashSet encluding methods and constructors
- underlying data structure of LinkedHashSet class is HashMap with a doubly linked list 

   Ex:
    ```LinkedHashSet<String> set = new LinkedHashSet<>();
     set.add("A");
     set.add("B");
     set.add("C");
     System.out.println(set); // [A, B, C]
     set.add("B");
     System.out.println(set); // [A, B, C]```
     Note: Here, insertion order is preserved, and duplicates are not allowed.
    
     Note: LinkedHashSet class is slightly slower than HashSet class because it maintains a doubly linked list to preserve the insertion order.

     Note: In general, we can use LinkedHashSet to develop cache memory-based applications because it maintains the insertion order.

215. SortedSet interface

    * SortedSet interface defines following methods in addition to Set interface methods
    - Object first(): Returns the first (lowest) element currently in the sorted set'
    - Object last(): Returns the last (highest) element currently in the sorted set
    - SortedSet<E> headSet(E toElement): Returns a view of the portion of this set whose elements are strictly less than toElement
    - SortedSet<E> tailSet(E fromElement): Returns a view of the portion of this set whose elements are greater than or equal to fromElement
    - SortedSet<E> subSet(E fromElement, E toElement): Returns a view of the portion of this set whose elements range from fromElement, 
            inclusive, to toElement
    - Comparator<? super E> comparator(): Returns the comparator used to order the elements in the set, or null if the set uses the natural ordering of its elements
        ex: SortedSet<Integer> set = new TreeSet<>();
            set.add(10);
            set.add(20);
            set.add(30);
            System.out.println(set.first()); // 10
            System.out.println(set.last()); // 30
            System.out.println(set.headSet(20)); // [10]
            System.out.println(set.tailSet(20)); // [20, 30]
            System.out.println(set.subSet(10, 30)); // [10, 20]
            System.out.println(set.comparator()); // null (natural ordering)

        Note: the defoult natural Sorting order
                - for numbers - Ascending order
                - for characters - Ascending order
                - for strings - Dictionary ordering

216. TreeSet class
- if we want to represent a group of indivisual objects as a single entity where dublicate are not allowed and elements are sorted in natural order
  then we should go for TreeSet class
- underlying data structure of TreeSet class is Red-Black tree
- insertion order is not preserved and elements are sorted in natural order
- heterogenious objects are not allowed otherwise we will get RuntimeException RE : ClassCastException
- null insertion is posible (only one null value is allowed) if and only if TreeSet is empty
  otherwise we will get RuntimeException RE : NullPointerException
    ex: TreeSet<String> set = new TreeSet<>();
        set.add(null);
        System.out.println(set); // [null]
        set.add("A");
        System.out.println(set); // [A, null] - RE : NullPointerException

- dublicate elements are not allowed
- TreeSet implement serializable, Cloneable and SortedSet interfaces but not RandomAccess interface
- every method of TreeSet class is not synchronized (not thread-safe)
- all object will be inserted based on some sorting order , it may be default natural sorting order or custom sorting order

    Note: TreeSet is the best choice when frequent operation is searching
    Note: in TreeSet dublicates are not allowed if we are trying to insert dublicate object then we won't get any compile time error or runtime error
          but the dublicate object will not be inserted into the TreeSet object

    * constructors of TreeSet class
    - TreeSet(): creates an empty TreeSet that will be sorted in natural order
    - TreeSet(Comparator<? super E> comparator): creates an empty TreeSet that will be sorted according to the specified comparator

    - TreeSet(Collection<? extends E> c): creates a TreeSet with all elements from the given collection, sorted in natural order
        ex: Set<String> set = new TreeSet<>(Arrays.asList("C", "A", "B"));
            System.out.println(set); // [A, B, C]

    - TreeSet(SortedSet<E> s): creates a TreeSet with all elements from the given sorted set, sorted in natural order
        ex: SortedSet<String> sortedSet = new TreeSet<>(Arrays.asList("C", "A", "B"));
            Set<String> set = new TreeSet<>(sortedSet);
            System.out.println(set); // [A, B, C]


    *** null acceptance in TreeSet
    - if we are trying to insert null value into empty TreeSet then it will be inserted successfully
      because there is no other object to compare with null value so null value will be inserted successfully
        ex: TreeSet<String> set = new TreeSet<>();
            set.add(null);
            System.out.println(set); // [null]
    - TreeSet(): creates an empty TreeSet that will be sorted in natural order
        ex: TreeSet<String> set = new TreeSet<>();
            set.add(null);
            System.out.println(set); // [null]
            set.add("A");
            System.out.println(set); // RE : NullPointerException

    * Important methods of TreeSet class
    - Comparator<? super E> comparator(): Returns the comparator used to order the elements in the set, or null if the set uses the natural 
            ordering of its elements
        ex: TreeSet<Integer> set = new TreeSet<>();
            set.add(10);
            set.add(20);
            set.add(30);
            System.out.println(set.comparator()); // null (natural ordering)
            TreeSet<String> set1 = new TreeSet<>(Comparator.reverseOrder());
            set1.add("A");
            set1.add("B");
            set1.add("C");
            System.out.println(set1.comparator()); // java.util.Collections$ReverseComparator@15db9742 (custom ordering)


217. Comparable interface
- it is present in java.lang package and it contains only one method is compareTo(Object obj)

    Syntax:
        public int compareTo(Object obj);

    ex: 
        obj.compareTo(obj1);
        - returns -ve : if obj is less than obj1
        - returns 0 : if obj is equal to obj1
        - returns +ve : if obj is greater than obj1


    ex: 
    ```class Student implements Comparable<Student> {
        int rollNo;
        String name;

        Student(int rollNo, String name) {
            this.rollNo = rollNo;
            this.name = name;
        }

        @Override
        public int compareTo(Student obj) {
            return this.rollNo - obj.rollNo; // Ascending order based on rollNo
        }

        @Override
        public String toString() {
            return "Student{" +
                    "rollNo=" + rollNo +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    public class Main {
        public static void main(String[] args) {
            TreeSet<Student> set = new TreeSet<>();
            set.add(new Student(3, "C"));
            set.add(new Student(1, "A"));
            set.add(new Student(2, "B"));
            System.out.println(set); // [Student{rollNo=1, name='A'}, Student{rollNo=2, name='B'}, Student{rollNo=3, name='C'}]
        }
    }```

    *** note: if default natural sorting order not available or if we are not satisfied with default natural sorting order
            then we can go for customized Sorting by using Comparator
        
        Comparable : ment for default natural sorting order
                where as
        Comparator : ment for customized sorting order


218. Comparator interface
- it is present in java.util package and it contains two methods compare(Object obj1, Object obj2) and equals(Object obj)
- we can use Comparator interface to define multiple sorting sequences for a class
- we can use Comparator interface to define customized sorting sequence for a 

    Note: if we implement comparator interface then only one method needs to be overridden that is compare() method
            because equals() method is already defined in Object class so anyway indirectly it will be present in class 
            if we override or not 

    syntax:
        public int compare(Object obj1, Object obj2);
        public boolean equals(Object obj);

    ex:
       obj.compare(obj1, obj2);
        - returns -ve : if obj1 is less than obj2
        - returns 0 : if obj1 is equal to obj2
        - returns +ve : if obj1 is greater than obj2

    ex:
    ```class Student {
        int rollNo;
        String name;

        Student(int rollNo, String name) {
            this.rollNo = rollNo;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "rollNo=" + rollNo +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    class SortByRollNo implements Comparator<Student> {
        @Override
        public int compare(Student obj1, Student obj2) {
            return obj1.rollNo - obj2.rollNo; // Ascending order based on rollNo
        }
    }
    class SortByName implements Comparator<Student> {
        @Override
        public int compare(Student obj1, Student obj2) {
            return obj1.name.compareTo(obj2.name); // Ascending order based on name
        }
    }
    class SortByNameDesc implements Comparator<Student> {
        @Override
        public int compare(Student obj1, Student obj2) {
            return obj2.name.compareTo(obj1.name); // Descending order based on name
        }
    }
    public class Main {
        public static void main(String[] args) {
            TreeSet<Student> set = new TreeSet<>(new SortByRollNo());
            set.add(new Student(3, "C"));
            set.add(new Student(1, "A"));
            set.add(new Student(2, "B"));
            System.out.println(set); // [Student{rollNo=1, name='A'}, Student{rollNo=2, name='B'}, Student{rollNo=3, name='C'}]

            TreeSet<Student> set1 = new TreeSet<>(new SortByName());
            set1.add(new Student(3, "C"));
            set1.add(new Student(1, "A"));
            set1.add(new Student(2, "B"));
            System.out.println(set1); // [Student{rollNo=1, name='A'}, Student{rollNo=2, name='B'}, Student{rollNo=3, name='C'}]

            TreeSet<Student> set2 = new TreeSet<>(new SortByNameDesc());
            set2.add(new Student(3, "C"));
            set2.add(new Student(1, "A"));
            set2.add(new Student(2, "B"));
            System.out.println(set2); // [Student{rollNo=3, name='C'}, Student{rollNo=2, name='B'}, Student{rollNo=1, name='A'}]
        }
    }```


219. various possible implementation of compare() method
    
    Integer I1 = (Integer) obj;
    Integer I2 = (Integer) obj;


    1) return I1.compareTo(I2); // Ascending order
    2) return -I1.compareTo(I2); // Descending order
    3) return I2.compareTo(I1); // Descending order
    4) return -I2.compareTo(I1); // Ascending order
    5) return I1 - I2; // Ascending order
    6) return I2 - I1; // Descending order
    7) return +1; // Insertion order  ex: if we are trying to insert 10, 20, 30 then it will be inserted as 10, 20, 30
    8) return -1; // Reverse of insertion order  ex: if we are trying to insert 10, 20, 30 then it will be inserted as 30, 20, 10
    9) return 0; // Dublicate objects are not allowed, only first object will be inserted, rest all objects will be treated as duplicate

    
220. write a program to insert String object into TreeSet where all elements should be sorted in descending order
- we can use Comparator interface to define customized sorting sequence for a class

    ex:
    ```class SortStringDesc implements Comparator<String> {
        @Override
        public int compare(String obj1, String obj2) {
            return obj2.compareTo(obj1); // Descending order based on name
        }
    }
    public class Main {
        public static void main(String[] args) {
            TreeSet<String> set = new TreeSet<>(new SortStringDesc());
            set.add("C");
            set.add("A");
            set.add("B");
            System.out.println(set); // [C, B, A]
        }
    }```

221. write a program to insert an StringBuffer object into TreeSet where all elements should be sorted in ascending order
- StringBuffer class is not implementing Comparable interface so default natural sorting order is not available
- we can use Comparator interface to define customized sorting sequence for a class
    ex:
    ```class SortStringBufferAsc implements Comparator<StringBuffer> {
        @Override
        public int compare(StringBuffer obj1, StringBuffer obj2) {
            String str1 = obj1.toString();
            String str2 = obj2.toString();
            return str1.compareTo(str2); // Ascending order based on name
        }
    }
    public class Main {
        public static void main(String[] args) {
            TreeSet<StringBuffer> set = new TreeSet<>(new SortStringBufferAsc());
            set.add(new StringBuffer("C"));
            set.add(new StringBuffer("A"));
            set.add(new StringBuffer("B"));
            System.out.println(set); // [A, B, C]
        }
    }```


    *****Note: if we are trying to insert StringBuffer object into TreeSet without implementing Comparator interface
          then we will get RuntimeException RE : ClassCastException because StringBuffer class is not implementing Comparable interface
          so default natural sorting order is not available

          ex: RE: ClassCastException
          ```public class Main {
              public static void main(String[] args) {
                  TreeSet<StringBuffer> set = new TreeSet<>();
                  set.add(new StringBuffer("C"));
                  set.add(new StringBuffer("A"));
                  set.add(new StringBuffer("B"));
                  System.out.println(set);
              }
          }```

    *****Note: if we are defining our own sorting by comparator then objects need to be comparable and homogeneous
          otherwise we will get RuntimeException RE : ClassCastException

222. Comparable vs Comparator

    Property          | Comparable          | Comparator
----------------------|---------------------|---------------------
Type                  | Inbuilt interface   | Inbuilt interface

Package               | java.lang           | java.util

Purpose               | Default natural     | Customized sorting
                      | sorting order       | order

Number of methods     | One (compareTo)     | Two (compare, equals)

Implementation        | Class must          | Separate class
                      | implement           | must implement
                      | Comparable          | Comparator
                      | interface           | interface

Multiple sorting      | Not possible        | Possible          

Note : we can't apply comparable on our own classes
       but we can apply comparator on our own classes


223. Write a program to insert an Employee object into TreeSet where all elements should be sorted in ascending order based on salary
- Employee class is not implementing Comparable interface so default natural sorting order is not available
- we can use Comparator interface to define customized sorting sequence for a class
    ex:
    ```class Employee {
        int empId;
        String name;
        double salary;

        Employee(int empId, String name, double salary) {
            this.empId = empId;
            this.name = name;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "empId=" + empId +
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }
    class SortBySalaryAsc implements Comparator<Employee> {
        @Override
        public int compare(Employee obj1, Employee obj2) {
            return Double.compare(obj1.salary, obj2.salary); // Ascending order based on salary
        }
    }
    public class Main {
        public static void main(String[] args) {
            TreeSet<Employee> set = new TreeSet<>(new SortBySalaryAsc());
            set.add(new Employee(1, "A", 50000));
            set.add(new Employee(2, "B", 30000));
            set.add(new Employee(3, "C", 40000));
            System.out.println(set); // [Employee{empId=2, name='B', salary=30000.0}, Employee{empId=3, name='C', salary=40000.0}, Employee{empId=1, name='A', salary=50000.0}]
        }
    }```

    
224. Comparison table of Set implementation classes
    Property          | HashSet             | LinkedHashSet       | TreeSet
----------------------|---------------------|---------------------|---------------------
Type                  | Class               | Class               | Class

Underlying data       | HashMap             | HashMap with a      | Red-Black tree
structure             |                     | doubly linked list  |

Insertion order       | Not preserved       | Preserved           | Not preserved

Sorting order         | Not sorted          | Not sorted          | Sorted in natural
                      |                     |                     | order or custom

Null insertion        | Allowed (only one   | Allowed (only one   | Allowed only if
                      | null value)         | null value)         | TreeSet is empty (From 1.7 its not allowed)

Dublicate elements    | Not allowed         | Not allowed         | Not allowed

Heterogenious         | Allowed             | Allowed             | Not allowed



225. Map interface
- if we want to represent a group of key-value pairs as a single entity where keys are unique and values can be duplicate
  then we should go for Map interface
- Map interface is not a child interface of Collection interface
- Map interface doesn't provide any methods so we have to use Object class methods to perform operations on Map objects
- all implementation classes of Map interface are not synchronized (not thread-safe)
- both keys and values are objects only , we cannot store primitive data types directly
  but we can store primitive data types by using wrapper classes
  
  Note: each key-value pair is called an Entry and represented as Map.
    so Map is concidered as a collection of a Entry Objects.

  * Entry<K, V> interface 
    - it is a child interface of Map interface
    - it represents a key-value pair
    - Entry<K, V> interface defines following methods
        - K getKey(): Returns the key corresponding to this entry
        - V getValue(): Returns the value corresponding to this entry
        - V setValue(V value): Replaces the value corresponding to this entry with the specified value (optional operation)
        - boolean equals(Object o): Compares the specified object with this entry for equality

    Note: we can create Entry objects only by using Map interface methods
          we cannot create Entry objects directly by using new operator

    Note: we can use Entry objects to iterate through the Map object
          because Map interface doesn't extend Collection interface so we cannot use Iterator or ListIterator to iterate through the Map object
          but we can use Entry objects to iterate through the Map object

    ex:
    ```Map<String, Integer> map = new HashMap<>();
    map.put("A", 1);
    map.put("B", 2);
    map.put("C", 3);
    Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
    for(Map.Entry<String, Integer> entry : entrySet) {
        System.out.println(entry.getKey() + " : " + entry.getValue());
    }```
    Output:
    A : 1
    B : 2
    C : 3


226. Map Interface methods
- void clear(): Removes all of the mappings from this map (optional operation)
- boolean containsKey(Object key): Returns true if this map contains a mapping for the specified key
- boolean containsValue(Object value): Returns true if this map maps one or more keys to the specified value
- Set<Map.Entry<K, V>> entrySet(): Returns a Set view of the mappings contained in this map
- V get(Object key): Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key
- boolean isEmpty(): Returns true if this map contains no key-value mappings
- Set<K> keySet(): Returns a Set view of the keys contained in this map
- V put(K key, V value): Associates the specified value with the specified key in this map (optional operation)
- void putAll(Map<? extends K, ? extends V> m): Copies all of the mappings from the specified map to this map (optional operation)
- V remove(Object key): Removes the mapping for a key from this map if it is present (optional operation)
    ex: Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        System.out.println(map); // {A=1, B=2, C=3}
        map.remove("B");
        System.out.println(map); // {A=1, C=3}

- int size(): Returns the number of key-value mappings in this map
- Collection<V> values(): Returns a Collection view of the values contained in this map
- V getOrDefault(Object key, V defaultValue): Returns the value to which the specified key is mapped, or defaultValue if this map 
    contains no mapping for the key
      ex: Map<String, Integer> map = new HashMap<>();
          map.put("A", 1);
          map.put("B", 2);
          System.out.println(map.getOrDefault("A", 0)); // 1
          System.out.println(map.getOrDefault("C", 0)); // 0


227. HashMap
- if we want to represent a group of key-value pairs as a single entity where keys are unique and values can be duplicate
  then we should go for HashMap class
- underlying data structure of HashMap class is HashTable (array of linked list) and internal implementation is based on hashing technique
- insertion order is not preserved and it is base on hashcode of the keys
- keys must be unique and values can be duplicate
- heterogenious objects are allowed for both keys and values
- null insertion is allowed for both keys and values but only one null key is allowed and multiple null values are allowed
- HashMap class implements Map, Serializable and Cloneable interfaces but not RandomAccess interface
- every method of HashMap class is not synchronized (not thread-safe)

    NOTE: HashMap is the best choice when frequent operation is searching
    NOTE: in HashMap dublicates are not allowed for keys if we are trying to insert dublicate key then we won't get any compile time error or runtime error
          but the old value will be replaced with new value for that key    
    
    * constructors of HashMap class
    - HashMap(): creates an empty HashMap with an initial capacity of 16 and load factor of 0.75
    - HashMap(int initialCapacity): creates an empty HashMap with the specified initial capacity and load factor of 0.75
    - HashMap(int initialCapacity, float loadFactor): creates an empty HashMap with the specified initial capacity and load factor
    - HashMap(Map<? extends K, ? extends V> m): creates a HashMap with all mappings from the given map
        ex: Map<String, Integer> map = new HashMap<>(Map.of("A", 1, "B", 2, "C", 3));
            System.out.println(map); // {A=1, B=2, C=3}
    - HashMap(int initialCapacity, float loadFactor, boolean dummy): creates an empty HashMap with the specified initial capacity,
            load factor and dummy value
        ex: HashMap<String, Integer> map = new HashMap<>(5, 0.75f, true);
            System.out.println(map.size()); // 0
            System.out.println(map.isEmpty()); // true
            map.put("A", 1);
            map.put("B", 2);
            map.put("C", 3);
            System.out.println(map.size()); // 3
            System.out.println(map.isEmpty()); // false

    * Important methods of HashMap class
    - float loadFactor(): Returns the load factor of the HashMap
    - int capacity(): Returns the current capacity of the HashMap
    - void trimToSize(): Trims the capacity of the HashMap to be the HashMap's current size
        ex: HashMap<String, Integer> map = new HashMap<>(5, 0.75f);
            System.out.println(map.size()); // 0
            System.out.println(map.capacity()); // 5
            map.put("A", 1);
            map.put("B", 2);
            map.put("C", 3);
            System.out.println(map.size()); // 3
            System.out.println(map.capacity()); // 5
            map.trimToSize();
            System.out.println(map.size()); // 3
            System.out.println(map.capacity()); // 3
    - void ensureCapacity(int minCapacity): Increases the capacity of the HashMap, if necessary,
        to ensure that it can hold at least the number of components specified by the minimum capacity argument
    - V putIfAbsent(K key, V value): If the specified key is not already associated with a value (or is mapped to null)
        associates it with the given value and returns null, else returns the current value
        ex: Map<String, Integer> map = new HashMap<>();
            map.put("A", 1);
            map.putIfAbsent("B", 2);
            System.out.println(map); // {A=1, B=2}
            map.putIfAbsent("A", 3);
            System.out.println(map); // {A=1, B=2}
    - V replace(K key, V value): Replaces the entry for the specified key only if it is currently mapped to some value
        ex: Map<String, Integer> map = new HashMap<>();
            map.put("A", 1);
            map.put("B", 2);
            System.out.println(map); // {A=1, B=2}
            map.replace("A", 3);
            System.out.println(map); // {A=3, B=2}
            map.replace("C", 4);
            System.out.println(map); // {A=3, B=2}
    - boolean replace(K key, V oldValue, V newValue): Replaces the entry for the specified key only if currently mapped to the specified value
        ex: Map<String, Integer> map = new HashMap<>();
            map.put("A", 1);
            map.put("B", 2);
            System.out.println(map); // {A=1, B=2}
            map.replace("A", 1, 3);
            System.out.println(map); // {A=3, B=2}
            map.replace("B", 1, 4);
            System.out.println(map); // {A=3, B=2}
    

228. how to get syncronized version of HashMap objct
- we can get syncronized version of HashMap object by using Collections.synchronizedMap() method
    ex: Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        Map<String, Integer> syncMap = Collections.synchronizedMap(map);
        System.out.println(syncMap); // {A=1, B=2, C=3}

    - syncMap is synchronized version of map object and map is not synchronized

229. LinkedHashMap class
- if we want to represent a group of key-value pairs as a single entity where keys are unique and values can be duplicate
  then we should go for LinkedHashMap class
- it is a subclass of HashMap class
- underlying data structure of LinkedHashMap class is HashMap with a doubly linked list
- insertion order is preserved and it is not base on hashcode of the keys
- keys must be unique and values can be duplicate
- heterogenious objects are allowed for both keys and values
- null insertion is allowed for both keys and values but only one null key is allowed and multiple null values are allowed
- LinkedHashMap class implements Map, Serializable and Cloneable interfaces but not RandomAccess interface
- every method of LinkedHashMap class is not synchronized (not thread-safe) (not thread-safe)
- introduced in JDK 1.4

    NOTE: LinkedHashMap is the best choice when frequent operation is insertion and traversal
    NOTE: in LinkedHashMap dublicates are not allowed for keys if we are trying to insert dublicate key then we won't get any compile time error 
        or runtime error but the old value will be replaced with new value for that key    
    
    * constaructors and methods of LinkedHashMap class are same as HashMap class

    ***Note : LinkedHashSet and LinkedHashMap are commanly used For developing Cache memory based applications
            because both maintains insertion order
    

230. IdentityHashmap class
- if we want to represent a group of key-value pairs as a single entity where keys are unique and values can be duplicate
  then we should go for IdentityHashMap class
- underlying data structure of IdentityHashMap class is HashTable (array of linked list) and internal implementation is based on hashing technique
- insertion order is not preserved and it is base on hashcode of the keys
- keys must be unique and values can be duplicate
- heterogenious objects are allowed for both keys and values
- null insertion is allowed for both keys and values but only one null key is allowed and multiple null values are allowed
- IdentityHashMap class implements Map, Serializable and Cloneable interfaces but not RandomAccess interface
- every method of IdentityHashMap class is not synchronized (not thread-safe)
- introduced in JDK 1.4

    Special features of IdentityHashMap class
    - in IdentityHashMap class keys are compared by using == operator but in HashMap class keys are compared by using equals() method
    - in IdentityHashMap class hashcode of keys are calculated by using System.identityHashCode() method but in 
        HashMap class hashcode of keys are calculated by using hashCode() method
    
        ex: 
        ```String str1 = new String("A");
        String str2 = new String("A");
        System.out.println(str1 == str2); // false
        System.out.println(str1.equals(str2)); // true  
        IdentityHashMap<String, Integer> identityMap = new IdentityHashMap<>();
        identityMap.put(str1, 1);
        identityMap.put(str2, 2);
        System.out.println(identityMap); // {A=1, A=2} - two different keys
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put(str1, 1);
        hashMap.put(str2, 2);
        System.out.println(hashMap); // {A=2} - one key```

231. WeakHashMap class
- if we want to represent a group of key-value pairs as a single entity where keys are unique and values can be duplicate
  then we should go for WeakHashMap class
- underlying data structure of WeakHashMap class is HashTable (array of linked list) and internal implementation is based on hashing technique
- insertion order is not preserved and it is base on hashcode of the keys
- keys must be unique and values can be duplicate
- heterogenious objects are allowed for both keys and values
- null insertion is allowed for both keys and values but only one null key is allowed and multiple null values are allowed
- WeakHashMap class implements Map, Serializable and Cloneable interfaces but not RandomAccess interface
- every method of WeakHashMap class is not synchronized (not thread-safe)
- introduced in JDK 1.2

    Note : In WeakHashMap class keys are weakly referenced so if a key is not referenced by any other object
           then it will be eligible for Garbage Collector automatically

           ex:
           ```Map<String, Integer> map = new WeakHashMap<>();
              String key1 = new String("A");
              String key2 = new String("B");
                map.put(key1, 1);
                map.put(key2, 2);
                System.out.println(map); // {A=1, B=2}
                key1 = null;
                       
                    System.gc();
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(map); // {B=2} - A is garbage collected```

        But In HashMap class keys are strongly referenced so even if a key is not referenced by any other object
        then also it will not be eligible for Garbage Collector automatically 
        in this casse HashMap Dominates Garbage Collector.


232. SortedMap interface
- if we want to represent a group of key-value pairs as a single entity according to some sorting order based on keys
  then we should go for SortedMap interface
- SortedMap interface is a child interface of Map interface

  * Methods of SortedMap interface
    - K firstKey(): Returns the first (lowest) key currently in this map
    - K lastKey(): Returns the last (highest) key currently in this map
    - SortedMap<K, V> headMap(K toKey): Returns a view of the portion of this map whose keys are strictly less than toKey
    - SortedMap<K, V> tailMap(K fromKey): Returns a view of the portion of this map whose keys are greater than or equal to fromKey
    - SortedMap<K, V> subMap(K fromKey, K toKey): Returns a view of the portion of this map whose keys range from fromKey, inclusive, to toKey
    - Comparator<? super K> comparator(): Returns the comparator used to order the keys in this map, or null if this map uses the 
        natural Sorting ordering of its keys

        ex: SortedMap<Integer, String> map = new TreeMap<>();
            map.put(3, "C");
            map.put(1, "A");
            map.put(2, "B");
            System.out.println(map.firstKey()); // 1
            System.out.println(map.lastKey()); // 3
            System.out.println(map.headMap(2)); // {1=A}
            System.out.println(map.tailMap(2)); // {2=B, 3=C}
            System.out.println(map.subMap(1, 3)); // {1=A, 2=B}
            System.out.println(map.comparator()); // null (natural ordering)

        Note: the defoult natural Sorting order
                - for numbers - Ascending order
                - for characters - Ascending order
                - for strings - Dictionary ordering 


233. TreeMap class
- if we want to represent a group of key-value pairs as a single entity according to some sorting order based on keys
  then we should go for TreeMap class
- underlying data structure of TreeMap class is Red-Black tree
- insertion order is not preserved and elements are sorted in natural order or custom sorting order based on keys
- keys must be unique and values can be duplicate
- heterogenious objects are not allowed for keys otherwise we will get RuntimeException RE : ClassCastException but values can be heterogeneous
- null insertion is not allowed for keys (From 1.7 it's not allowed) otherwise we will get RuntimeException RE : NullPointerException
- null insertion is allowed for values and multiple

    * Constructors of TreeMap class
    - TreeMap(): creates an empty TreeMap that will be sorted in natural order
    - TreeMap(Comparator<? super K> comparator): creates an empty TreeMap that will be sorted according to the specified comparator
    - TreeMap(Map<? extends K, ? extends V> m): creates a TreeMap with all mappings from the given map, sorted in natural order
    - TreeMap(SortedMap<K, ? extends V> m): creates a TreeMap with all mappings from the given sorted map, sorted in natural order

    * Important methods of TreeMap class
    - Comparator<? super K> comparator(): Returns the comparator used to order the keys in this map, or null if this map uses the 
        natural Sorting ordering of its keys
    - K firstKey(): Returns the first (lowest) key currently in this map
    - K lastKey(): Returns the last (highest) key currently in this map
    - SortedMap<K, V> headMap(K toKey): Returns a view of the portion of this map whose keys are strictly less than toKey
    - SortedMap<K, V> tailMap(K fromKey): Returns a view of the portion of this map whose keys are greater than or equal to fromKey
    - SortedMap<K, V> subMap(K fromKey, K toKey): Returns a view of the portion of this map whose keys range from fromKey, inclusive, to toKey

        ex: TreeMap<Integer, String> map = new TreeMap<>();
            map.put(3, "C");
            map.put(1, "A");
            map.put(2, "B");
            System.out.println(map); // {1=A, 2=B, 3=C}
            System.out.println(map.firstKey()); // 1
            System.out.println(map.lastKey()); // 3
            System.out.println(map.headMap(2)); // {1=A}
            System.out.println(map.tailMap(2)); // {2=B, 3=C}
            System.out.println(map.subMap(1, 3)); // {1=A, 2=B}
            System.out.println(map.comparator()); // null (natural ordering)
            TreeMap<String, Integer> map1 = new TreeMap<>(Comparator.reverseOrder());
            map1.put("A", 1);
            map1.put("C", 3);
            map1.put("B", 2);
            System.out.println(map1); // {C=3, B=2, A=1}
            System.out.println(map1.firstKey()); // C
            System.out.println(map1.lastKey()); // A
            System.out.println(map1.headMap("B")); // {C=3}
            System.out.println(map1.tailMap("B")); // {B=2, A=1}
            System.out.println(map1.subMap("A", "C")); // {B=2, A=1}
            System.out.println(map1.comparator()); // java.util.Collections$ReverseComparator@15db9742 (custom ordering)


234. Demo Program for Customized Sorting order by using Comparator interface
- we can use Comparator interface to define customized sorting sequence for a class
    ex:
    ```class SortByKeyDesc implements Comparator<String> {
        @Override
        public int compare(String obj1, String obj2) {
            return obj2.compareTo(obj1); // Descending order based on key
        }
    }
    public class Main {
        public static void main(String[] args) {
            TreeMap<String, Integer> map = new TreeMap<>(new SortByKeyDesc());
            map.put("C", 3);
            map.put("A", 1);
            map.put("B", 2);
            System.out.println(map); // {C=3, B=2, A=1}
        }
    }```

235. Hashtable class
- if we want to represent a group of key-value pairs as a single entity where keys are unique and values can be duplicate
  then we should go for Hashtable class
- underlying data structure of Hashtable class is HashTable (array of linked list) and internal implementation is based on hashing technique
- insertion order is not preserved and it is base on hashcode of the keys
- keys must be unique and values can be duplicate
- heterogenious objects are allowed for both keys and values
- null insertion is not allowed for both keys and values otherwise we will get RuntimeException RE : NullPointerException
- Hashtable class implements Map, Serializable and Cloneable interfaces but not RandomAccess interface
- every method of Hashtable class is synchronized (thread-safe) but it is slow
- introduced in JDK 1.0

    Note: Hashtable is the best choice when frequent operation is searching

    * Constructors of Hashtable class
    - Hashtable(): creates an empty Hashtable with an initial capacity of 11 and load factor of 0.75
    - Hashtable(int initialCapacity): creates an empty Hashtable with the specified initial capacity and load factor of 0.75
    - Hashtable(int initialCapacity, float loadFactor): creates an empty Hashtable with the specified initial capacity and load factor
    - Hashtable(Map<? extends K, ? extends V> m): creates a Hashtable with all mappings from the given map

    * Important methods of Hashtable class
    - float loadFactor(): Returns the load factor of the Hashtable
    - int capacity(): Returns the current capacity of the Hashtable
    - void rehash(): Increases the capacity of the Hashtable and rehashes the contents
        ex: Hashtable<String, Integer> table = new Hashtable<>(5, 0.75f);
            System.out.println(table.size()); // 0
            System.out.println(table.capacity()); // 5
            table.put("A", 1);
            table.put("B", 2);
            table.put("C", 3);
            System.out.println(table.size()); // 3
            System.out.println(table.capacity()); // 5
            table.rehash();
            System.out.println(table.size()); // 3
            System.out.println(table.capacity()); // 11
    - V putIfAbsent(K key, V value): If the specified key is not already associated with a value (or is mapped to null)
        associates it with the given value and returns null, else returns the current value
        ex: Map<String, Integer> table = new Hashtable<>();
            table.put("A", 1);
            table.putIfAbsent("B", 2);
            System.out.println(table); // {A=1, B=2}
            table.putIfAbsent("A", 3);
            System.out.println(table); // {A=1, B=2}
    - V replace(K key, V value): Replaces the entry for the specified key only if it is currently mapped to some value
        ex: Map<String, Integer> table = new Hashtable<>();
            table.put("A", 1);
            table.put("B", 2);
            System.out.println(table); // {A=1, B=2}
            table.replace("A", 3);
            System.out.println(table); // {A=3, B=2}
            table.replace("C", 4);
            System.out.println(table); // {A=3, B=2}
    - boolean replace(K key, V oldValue, V newValue): Replaces the entry for the specified key only if currently mapped to the specified value
        ex: Map<String, Integer> table = new Hashtable<>();
            table.put("A", 1);
            table.put("B", 2);
            System.out.println(table); // {A=1, B=2}
            table.replace("A", 1, 3);
            System.out.println(table); // {A=3, B=2}
            table.replace("B", 1, 4);
            System.out.println(table); // {A=3, B=2}
    
236. Difference between HashMap and Hashtable

    Property          | HashMap             | Hashtable
----------------------|---------------------|---------------------
Type                  | Class               | Class
Underlying data       | HashTable           | HashTable
structure             | (array of linked    | (array of linked
                      | list)               | list)

Insertion order       | Not preserved       | Not preserved

Sorting order         | Not sorted          | Not sorted

Null insertion        | Allowed (only one   | Not allowed
                      | null key and        |
                      | multiple null       |
                      | values)             |

Dublicate elements    | Not allowed for     | Not allowed for
                      | keys                | keys

Heterogenious         | Allowed             | Allowed

methods               | Not synchronized    | Synchronized
                      | (not thread-safe)   | (thread-safe)

version               | Introduced in       | Introduced in
                      | JDK 1.2             | JDK 1.0

performance           | Faster              | Slower



237. Internal Working of HashMap class
- HashMap is a data structure which is used to store key-value pairs
- HashMap is an array of linked lists
- each element of the array is called a bucket
- each bucket contains a linked list of key-value pairs
- when we create a HashMap object, an array of buckets is created with a default size of 16
- when we insert a key-value pair into the HashMap, the hashcode of the key is calculated
- the hashcode is then used to determine the index of the bucket where the key-value pair should be stored
- if the bucket is empty, the key-value pair is inserted into the bucket
- if the bucket is not empty, the linked list in the bucket is traversed to check if the key already exists
    internally it uses equals() method to check the key is already exists or not
- if the key already exists, the value is updated with the new value
- if the key does not exist, the key-value pair is added to the linked list in the bucket
- if the number of key-value pairs in the HashMap exceeds the load factor (default is 0.75), the capacity of the HashMap is doubled and all
    the key-value pairs are rehashed to the new buckets (their hash codes are recalculated for the new array size)



237. Internal Working of Hashtable class
- Hashtable is a data structure which is used to store key-value pairs
- Hashtable is an array of linked lists
- each element of the array is called a bucket
- each bucket contains a linked list of key-value pairs
- when we create a Hashtable object, an array of buckets is created with a default size of 11
- when we insert a key-value pair into the Hashtable, the hashcode of the key is calculated
- the hashcode is then used to determine the index of the bucket where the key-value pair should be stored
- if the bucket is empty, the key-value pair is inserted into the bucket
- if the bucket is not empty, the linked list in the bucket is traversed to check if the key already exists
    internally it uses equals() method to check the key is already exists or not
- if the key already exists, the value is updated with the new value
- if the key does not exist, the key-value pair is added to the linked list in the bucket
- if the number of key-value pairs in the Hashtable exceeds the load factor (default is 0.75), the capacity of the Hashtable is doubled and all
    the key-value pairs are rehashed to the new buckets (their hash codes are recalculated for the new array size)

238. Properties class
- Properties class is a subclass of Hashtable class
- Properties class is used to represent a group of key-value pairs where both keys and values are strings only
- Properties class is mainly used to store configuration data
- Properties class provides methods to read and write properties from/to a file
- Properties class implements Map, Serializable and Cloneable interfaces but not RandomAccess interface
- every method of Properties class is synchronized (thread-safe) (thread-safe)
- introduced in JDK 1.0

    ex: 
    ```public class Test {
        public static void main(String[] args) {
            Properties properties = new Properties();
            // Setting properties
            properties.setProperty("username", "admin");
            properties.setProperty("password", "12345");

            System.out.println("Username: " + properties.getProperty("username"));
            System.out.println("Password: " + properties.getProperty("password"));
           
        }
    }```

239. Queue interface
- if we want to represent a group of objects as a single entity where objects are stored and retrieved in a particular order
  then we should go for Queue interface
- Queue interface is a child interface of Collection interface
- Queue interface is used to represent a collection of objects that are processed in a FIFO (  First In First Out ) manner
- Queue interface provides methods to insert, remove and examine elements in the queue
- all implementation classes of Queue interface are not synchronized (not thread-safe)
- both heterogenious and null insertion are allowed in Queue implementations but it is not recommended
- we can use Iterator to iterate through the elements of the queue
- we cannot use ListIterator to iterate through the elements of the queue because ListIterator 
    is a child interface of List interface and Queue interface doesn't extend List interface
- introduced in JDK 1.5
    * Methods of Queue interface
    - boolean add(E e): Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions,
        returning true upon success and throwing an IllegalStateException if no space is currently available
    - boolean offer(E e): Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions
        returning true upon success and false if no space is currently available
    - E remove(): Retrieves and removes the head of this queue. This method differs from poll() only in that it throws an exception if this queue is empty
    - E poll(): Retrieves and removes the head of this queue, or returns null if this queue is empty
    - E element(): Retrieves, but does not remove, the head of this queue. This method differs from peek() only in that it throws an exception if this queue is empty
    - E peek(): Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty

        ex: Queue<Integer> queue = new LinkedList<>();
            queue.add(1);
            queue.add(2);
            queue.add(3);
            System.out.println(queue); // [1, 2, 3]
            System.out.println(queue.remove()); // 1
            System.out.println(queue); // [2, 3]
            System.out.println(queue.poll()); // 2
            System.out.println(queue); // [3]
            System.out.println(queue.element()); // 3
            System.out.println(queue.peek()); // 3
            System.out.println(queue); // [3]

240. PriorityQueue class
- if we want to represent a group of objects as a single entity where objects are stored and retrieved in a particular order
  then we should go for PriorityQueue class
- underlying data structure of PriorityQueue class is a binary heap
- PriorityQueue class is used to represent a collection of objects that are processed based on their priority
- by defoult elements are stored and retrieved in natural order but we can also define custom sorting order by using Comparator interface
- heterogenious objects are not allowed otherwise we will get RuntimeException RE : ClassCastException
- null insertion is not allowed otherwise we will get RuntimeException RE : NullPointerException
- every method of PriorityQueue class is not synchronized (not thread-safe)
- introduced in JDK 1.5

    Note: PriorityQueue is the best choice when frequent operation is insertion and deletion based on priority

    * Constructors of PriorityQueue class
    - PriorityQueue(): creates an empty PriorityQueue with an initial capacity of 11 that orders its elements according to their natural ordering
    - PriorityQueue(int initialCapacity): creates an empty PriorityQueue with the specified initial capacity that orders its elements according to their natural ordering
    - PriorityQueue(int initialCapacity, Comparator<? super E> comparator): creates an empty PriorityQueue with the specified initial capacity that orders its elements according to the specified comparator
    - PriorityQueue(Collection<? extends E> c): creates a PriorityQueue containing the elements in the specified collection that orders its elements according to their natural ordering
    - PriorityQueue(PriorityQueue<? extends E> c): creates a PriorityQueue containing the elements in the specified priority queue that orders its elements according to their natural ordering
    - PriorityQueue(SortedSet<? extends E> c): creates a PriorityQueue containing the elements in the specified sorted set that orders its elements according to their natural ordering

    * Important methods of PriorityQueue class
    - int size(): Returns the number of elements in this priority queue
    - boolean isEmpty(): Returns true if this priority queue contains no elements
    - boolean contains(Object o): Returns true if this priority queue contains the specified element
    - Object[] toArray(): Returns an array containing all of the elements in this priority queue
    - <T> T[] toArray(T[] a): Returns an array containing all of the elements in this priority queue; the runtime type of the returned array is that of the specified array
    - boolean remove(Object o): Removes a single instance of the specified element from this priority queue, if it is present
    - boolean containsAll(Collection<?> c): Returns true if this priority queue contains all of the elements in the specified collection
    - boolean addAll(Collection<? extends E> c): Adds all of the elements in the specified collection to this priority queue
    - boolean removeAll(Collection<?> c): Removes all of this priority queue's elements that are also contained in the specified collection
    - boolean retainAll(Collection<?> c): Retains only the elements in this priority queue that are contained in the specified collection
    - void clear(): Removes all of the elements from this priority queue
    - po

        ex: PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.add(3);
            pq.add(1);
            pq.add(2);
            System.out.println(pq); // [1, 3, 2]
            System.out.println(pq.remove()); // 1
            System.out.println(pq); // [2, 3]