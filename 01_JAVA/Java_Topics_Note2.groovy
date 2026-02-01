NoteBook 2 :
------------


38. package
- it is an encapsulation mechanism to group related classes and interfaces together
- it is used to avoid name conflicts

39. class level access modifiers

    1) Top level classes (outer classes)
        - public - accessible from any other class
        - default (no modifier) - accessible only within the same package
        - final - cannot be subclassed
        - abstract - cannot be instantiated
        - strictfp - ensures consistent floating-point calculations

    2) Nested classes (inner classes)
        - public - accessible from any other class
        - protected - accessible within the same package and subclasses
        - default (no modifier) - accessible only within the same package
        - private - accessible only within the same class

40. Access Specifiers vs Access Modifiers
- Access Specifiers: public, protected, default (no modifier), private
- Access Modifiers: final, abstract, static, synchronized, native, strictfp

41. public classes
- if class is public, then we can access this class from any other class
- must be defined in a file with the same name as the class

42. default classes
- if class is default, then we can access this class only within the same package

43. final modifier

    * final class
    - if a class is declared as final, then we cannot extend this class to any other class
    - used to avoid inheritance and to create immutable classes
    - ex: String, Integer, etc.

    * final method
    - if a method is declared as final, then we cannot override this method
    - used to stop method overriding in subclasses / child classes
    - ex: public final void display() {} 

    * final variable
    - if a variable is declared as final, then we cannot change the value of this variable
    - used to create constants
    - ex: public static final int MAX_VALUE = 100;

44. abstract modifier
- abstract is a modifier that can be applied to classes and methods but not to variables

    * abstract class
    - if a class is declared as abstract, then we cannot create an object of this class
    - used to provide a base class for other classes to extend and implement abstract methods
    - ex: public abstract class Shape {}

    * abstract method
    - if a method is declared as abstract, then we must override this method in the subclass / child class
    - used to provide a method signature without implementation in the abstract class
    - ex: public abstract void draw();

    note: we can't use abstract  modifier with final, native, private, static, synchronized, strictfp
        - because illegal combination of modifiers abstract and final

45. abstract class vs abstract method

- Abstract Class:
  - if we know the specification and implementation but not completely then we should go with Abstract class
  - Abstract class is a combination of abstract methods and concrete methods 
  - in an abstract class, there are no restrictions on variable declaration
  - Abstract class provides partial abstraction

- Abstract Method:
  - if we know the specification but not the implementation then we should go with Abstract method
  - Abstract method is a method without a body
  - in an abstract method, we can declare only final and static variables
  - Abstract method provides 100% abstraction

46. strictfp modifier
  - strictfp is a modifier that can be applied to classes, interfaces, and methods
  - it is used to ensure that floating-point calculations are consistent across different platforms
  - when a class or method is declared as strictfp, all floating-point calculations within that class or
   method will adhere to the IEEE 754 standard for floating-point arithmetic
  - ex: public strictfp class Calculator {}

47. public members
- if a member is declared as public, then we can access this member from any other class
- ex: public int age;

48. default members
- if a member is declared as default, then we can access this member only within the same package
- ex: int age;

49. private members
- if a member is declared as private, then we can access this member only within the same class
- ex: private int age;

50. protected members
- if a member is declared as protected, then we can access this member within the same package and 
    subclasses from other packages
- ex: protected int age;

51. static modifier
- static is a modifier that can be applied to variables, methods, blocks, and nested classes
- it is used to create class-level members that are shared among all instances of the class
- static members can be accessed without creating an instance of the class
- ex: public static int count;
- ex: public static void display() {}
- ex: static { // static block }
- ex: public static class InnerClass {}

- note: we can't use static modifier with local variables and interfaces
    - because illegal modifier for the local variable age; only final is permitted
    - because interfaces are implicitly abstract and cannot be instantiated
- note: we can't use static modifier with final, abstract, native, private, synchronized, strictfp
    - because illegal combination of modifiers: static and final

    * static variable
    - if a variable is declared as static, then it is common for all objects of the class

    * static method
    - if a method is declared as static, then we can call this method without creating an object of the class
    - static methods can access only static variables and static methods directly
    - static methods cannot access instance variables and instance methods directly

    * static block
    - static block is used to initialize static variables
    - static block is executed only once when the class is loaded into memory

    * static nested class
    - static nested class is a nested class that is declared as static
    - static nested class can access static members of the outer class directly
    - static nested class cannot access instance members of the outer class directly

52. final variable
    * static final variable
    - if a variable is declared as static final, then it is a constant and its value cannot be changed
    - used to create constants that are common for all objects of the class
    - ex: public static final int MAX_VALUE = 100;

    * non-static final variable
    - if a variable is declared as final, then it is a constant for each object of the class and its value cannot be changed
    - used to create constants that are specific to each object of the class
    - ex: public final int id;
    - note: we must initialize a final variable either at the time of declaration or in the constructor
        - because the final variable id might not have been initialized

    * final local variable
    - if a local variable is declared as final, then its value cannot be changed within the method
    - used to create constants within a method
    - ex: public void display() { final int MAX = 100; }
    - note: we must initialize final local variable at the time of declaration
        - because the final local variable max might not have been initialized
    
53. synchronized modifier
- synchronized is a modifier it can be applied to methods and blocks but not to variables and classes
- it is used to provide thread safety by allowing only one thread to access a synchronized method or block at a time
- ex: public synchronized void display() {}
- ex: synchronized(this) { // synchronized block }
- note: we can't use synchronized modifier with final, abstract, native, private, static, strictfp
    - because illegal combination of modifiers: synchronized and final

54. native modifier
- native is a modifier that can be applied only to methods
- it is used to indicate that the method is implemented in native code using JNI (Java Native Interface)
- ex: public native void display();
- note: we can't use native modifier with final, abstract, private, static, strictfp
    - because illegal combination of modifiers: native and final

55. transient modifier
- transient is a modifier that can be applied only to variables
- at the time of serialization, if we don't want to store the value of a variable to meet security constraints, 
    then we can declare that variable as transient
- at the time of serialization JVM ignore original value of transient variable and save default value of that variable
    to the file
- default value: for object null, for int 0, for boolean false
- ex: private transient int password;

56. volatile modifier
- volatile is a modifier that can be applied only to variables
- if the value of a variable keep changing by multiple threads, then there is a chance of data inconsistency
- to avoid data inconsistency, we can declare that variable as volatile
- when a variable is declared as volatile, then for every thread JVM will create a copy of that variable 
- for every modification performed by thread will takes place in local copy so there is no effect on other threads
- ex: private volatile boolean flag;

- NOTE : main Disadvantages of volatile modifier
    1) we can't use volatile modifier with final, abstract, native, private, static, synchronized, strictfp
        - because illegal combination of modifiers: volatile and final
    2) we can't declare complex data types (like array, collection, etc.) as volatile
    3) we can't perform compound operations (like increment, decrement, etc.) on volatile variables
    4) we can't use volatile variables in conditional statements (like if, switch, etc.)
    5) also increases complexity of code

57. Interface
  - if we know the specification and don't know about the implementation then we should go with an interface
  - in an interface, every method is abstract whether we declare it or not 
  - In an interface, variables are public static final 
  - From Java 8 onwards, it can have default and static methods.
  - An interface provides 100% abstraction

  * interface declaration and implementation
    - interface is declared using interface keyword
    - a class implements an interface using implements keyword
    - a class can implement multiple interfaces
    - ex: public interface Drawable {}
    - ex: public class Circle implements Drawable {}

  * interface methods
    - all methods in an interface are implicitly public and abstract
    - from Java 8, we can have default and static methods in an interface
    -   Note : default keyword is mandatory for a default method
    -   Note : static keyword is mandatory for a static method
        ex: public interface Drawable {
                void draw(); // abstract method
                default void display() { System.out.println("default method");} // default method
                static void info() {System.out.println("static method");} // static method
            }
    - default methods have a body and can be overridden in the implementing class
    - static methods belong to the interface and cannot be overridden in the implementing class
    - ex: public void draw(); (abstract method)
    - ex: public default void display() {} (default method)
    - ex: public static void info() {} (static method)

  * interface variables
    - all variables in an interface are implicitly public, static, and final
    - we must initialize interface variables at the time of declaration
    - ex: public static final int MAX_VALUE = 100;
    - ex: int MAX_VALUE = 100; (public, static, and final are optional)

58. extends vs implements
- extends is used for class to class inheritance and interface to interface inheritance, 
    only one inheritance is possible
- implements is used for class to interface inheritance, multiple inheritance is possible
- ex: class A extends B {}
- ex: interface A extends B {}
- ex: class A implements B, C {}

59. interface naming conflicts
- if a class implements multiple interfaces that have methods with the same signature, 
    then there is a naming conflict
- to resolve the naming conflict, we have to give implementation for only one method
- ex:
    interface A {
        void display();
    }
    interface B {
        void display();
    }
    class C implements A, B {
        public void display() { // implementation for display() method
            System.out.println("display method");
        }
    }
-  note: because of this naming conflict, interface supports multiple inheritance

60. Interface variable naming conflicts
- if a class implements multiple interfaces that have variables with the same name,
    then there is a naming conflict
- to resolve the naming conflict, we have to use the interface name to access the variable
- ex:
    interface A {
        int value = 10;
    }
    interface B {
        int value = 20;
    }
    class C implements A, B {
        public void display() {
            System.out.println(value); // error: reference to value is ambiguous
            System.out.println(A.value); // access value from interface A
            System.out.println(B.value); // access value from interface B
        }
    }

    - otherwise, we will get a compiler error:
        error: reference to value is ambiguous
            System.out.println(value);

61. marker interface
- marker interface is an interface that does not contain any methods or variables 
- by implementing a marker interface JVM will provide some special behavior to the class
- ex: Serializable, Cloneable, Remote, etc. 

- by implementing 
    - Serializable - to make object serializable
    - Cloneable - to make object cloneable  

62. why classes getting aetting special behavior by implementing marker interface
- because JVM will check whether the class is implementing that marker interface or not
- if the class is implementing that marker interface, then JVM will provide special behavior to that class

63. adapter classes
- adapter class is a class that provides empty implementation for all methods of an interface
- by extending an adapter class, we can override only the methods that we are interested in
- ex: 
    interface MouseListener {
        void mouseClicked();
        void mousePressed();
        void mouseReleased();
        void mouseEntered();
        void mouseExited();
    }
    abstract class MouseAdapter implements MouseListener {
        public void mouseClicked() {}
        public void mousePressed() {}
        public void mouseReleased() {}
        public void mouseEntered() {}
        public void mouseExited() {}
    }
    class MyMouseListener extends MouseAdapter {
        public void mouseClicked() {
            System.out.println("mouse clicked");
        }
    }

Note : Marker interface and adapter classes simplifies complexity of the programming and this 
          this are best utility to programmers and programmers life becomes easy

64. new vs constructor

    * new
    - new is an operator that is used to create an object of a class
    - new operator allocates memory for the object and returns the reference of the object

    * constructor
    - constructor is a special method that is used to initialize the object of a class
    - constructor is called at the time of object creation to initialize the object

    ex: Student s = new Student(); 
        - here new is an operator and Student() is a constructor

65. child object vs parent constructor
- when we are creating a child class object automatically parent class constructor will be executed first
   to perform parent class object initialization and then child class constructor will execute to perform 
   child class object initialization
- ex:
    class Parent {
        Parent(int x) {
            System.out.println("parent constructor");
        }
    }
    class Child extends Parent {
        Child(int y) {
            super(y); // calling parent class constructor  
            System.out.println("child constructor");
        }
    }
    class Test {
        public static void main(String[] args) {
            Child c = new Child(20); // creating child class object
        }
    }
    output:
        parent constructor
        child constructor  

66. we are not creating object for abstract class then why abstract class have a constructor
- for initialization of abstract class object abstract class constructor is required
- when we are creating a child class object, parent class constructor will be executed first to perform
   parent class object initialization
- ex:
    abstract class Parent {
        Parent(int x) {
            System.out.println("parent constructor");
        }
    }
    class Child extends Parent {
        Child(int y) {
            super(y); // calling parent class constructor
            System.out.println("child constructor");
        }
    }
    class Test {
        public static void main(String[] args) {
            Child c = new Child(20); // creating child class object
        }
    }
    output:
        parent constructor
        child constructor

67. data hiding
- data hiding is a mechanism to restrict access to the data members of a class
- by using data hiding, we can protect the data from unauthorized access and modification
- to achieve data hiding, we can declare the data members of a class as private and provide
   public getter and setter methods to access and modify the data members
- ex:
    class Student {
        private int id; // private data member
        private String name; // private data member
        public int getId() { // public getter method
            return id;
        }
        public void setId(int id) { // public setter method
            this.id = id;
        }
        public String getName() { // public getter method
            return name;
        }
        public void setName(String name) { // public setter method
            this.name = name;
        }
    }
- note: data hiding is a fundamental concept of OOPs and it is used to achieve encapsulation

68. Abstraction
    - hiding internal implementation and providing only a specification is called abstraction
    ex: Bank ATM, bank offering a set of services without showing internal implementation

    There are two types of abstraction:
        . Full Abstraction / Interface:
            - Any service requirement specification needs an implementation, which can be provided by an interface
            - an interface is a combination of public static final variables and only abstract methods
            - an interface provides 100% abstraction
            Note: if you know the specification and don't know the implementation then you should go with an interface

        . Partial Abstraction / Abstract Class:
            - a class which is declared with the abstract keyword and contains partial implementation; this type of class is called an abstract class.
            - an abstract class can contain concrete methods + abstract methods
            - an abstract class provides partial abstraction
            Note: if we know the specification and implementation but not completely then we should go with an abstract class

69. Encapsulation: 
    - Wrapping a data member and member function in a single unit; it's called encapsulation.
    ex: POJO
        - in a POJO, every variable is private and as per requirement, we can declare getter/setter methods 
    - It provides data hiding and security.

    Note: encapsulation = data hiding + abstraction

    * tightly encapsulated class
    - a class is said to be tightly encapsulated if all its data members are private and
      it provides public getter and setter methods to access and modify the data members
    - ex:
        class Student {
            private int id; // private data member
            private String name; // private data member
            public int getId() { // public getter method
                return id;
            }
            public void setId(int id) { // public setter method
                this.id = id;
            }
            public String getName() { // public getter method
                return name;
            }
            public void setName(String name) { // public setter method
                this.name = name;
            }
        }

    * loosely encapsulated class
    - a class is said to be loosely encapsulated if it has some data members as private and some data members as public
    - ex:
        class Student {
            private int id; // private data member
            public String name; // public data member
            public int getId() { // public getter method
                return id;
            }
            public void setId(int id) { // public setter method
                this.id = id;
            }
        }

- Note: tightly encapsulated class is more secure than loosely encapsulated class

70. Is-A Relationship / Inheritance

    - Creating a new class from an existing class
    - the subclass inherits properties from a superclass and adds or modifies the functionality; this process is called inheritance
    
    . There are 5 types of inheritance:
      - single-level inheritance: one class having one sub class.
      - multilevel inheritance: one class having one parent and one subclass.
      - Hierarchical Inheritance: one class having more than one subclass.
      - multiple inheritance: one class having more than one parent class.
      - Hybrid Inheritance: combination of more than one inheritance type.

71. Has a Relationship / Composition
    - Creating a new class from existing class by using reference is called Composition
    - the new class contains the reference of existing class and use the properties of existing class
      this process is called composition
    - ex:
        class Engine {
            void start() {
                System.out.println("Engine started");
            }
        }
        class Car {
            Engine engine; // reference of Engine class
            Car() {
                engine = new Engine(); // creating object of Engine class
            }
            void startCar() {
                engine.start(); // using Engine's start method
                System.out.println("Car started");
            }
        }
        class Test {
            public static void main(String[] args) {
                Car car = new Car();
                car.startCar();
            }
        }
        Output:
        Engine started
        Car started

72. Difference between composition and aggregation

    * composition
    - Composition is a strong type of association where the child object cannot exist without the parent object
    - In composition, the parent class is responsible for the lifecycle of the child class
    - In composition, the child class is a part of the parent class
        ex: of composition: Car and Engine

    - note: Composition means that one class is made up of one or more objects from other classes. 
                In simple terms, it’s like saying, “A car has an engine.”

        - Car is a class.
        - Engine is another class.
        - The Car class contains (or is composed of) an Engine object.
        - So, instead of a car being a type of engine, a car has an engine. This helps organize code by showing real-world
         relationships.


    * aggregation
    - Aggregation is a weak type of association where the child object can exist without the parent object
    - In aggregation, the child class can have its own lifecycle independent of the parent class
    - In aggregation, the child class is not a part of the parent class
        ex: of aggregation: Library and Book 

    - note: Aggregation is a way to show that one class uses another class, but they can exist independently. 
                It’s like saying, “A library has books.”
        - Library is a class.
        - Book is another class.
        - The Library class contains (or aggregates) Book objects.
        - However, books can exist without being in a library. This shows a relationship where one class uses another, 
          but they are not tightly connected.

73. Is a Relationship vs Has a Relationship

    * Is a Relationship
    - Is a relationship is achieved through inheritance
    - In Is a relationship, the subclass inherits properties and behaviors from the superclass
    - In Is a relationship, the subclass can be treated as an instance of the superclass
        ex: Dog is an Animal (Dog extends Animal)

    * Has a Relationship
    - Has a relationship is achieved through composition or aggregation
    - In Has a relationship, the class contains references to other classes as its members
    - In Has a relationship, the class cannot be treated as an instance of the contained class
        ex: Car has an Engine (Car contains Engine object)

74. Overloading (Compile-time Polymorphism):
  - within the same class, we can define more than one method with different parameters; this process is called method overloading.
  - we can overload private, final, and static methods.
  - in method overloading, return type declaration has no restrictions.
  - in overloading, the throws keyword declaration has no restrictions.
  - in overloading, method resolution is always based on the object reference.

75. Overriding (Run-time Polymorphism):
  - if a child class is not satisfied with the parent class method implementation, then the child is allowed to redefine that method as per the requirement; this process is called method overriding. 
  - we can't override private, final, and static methods.
  - in method overriding, the return type must be the same or a covariant is allowed.
  - in overriding, if the child class method throws any exception, then the parent class method should throw the same error or its parent.
  - in overriding, method resolution is always based on the runtime object.


76. method hiding
  - if a child class defines a static method with the same signature as a static method in the parent class,
      then the child class method hides the parent class method
  - method hiding is not method overriding because static methods are resolved at compile time based on the
      reference type, not the object type
  - ex:
        class Parent {
            static void display() {         
                System.out.println("parent display");
            }
        }
        class Child extends Parent {
            static void display() {
                System.out.println("child display");
            }
        }
        class Test {
            public static void main(String[] args) {
                Parent p = new Child();
                p.display(); // calls Parent's display method (method hiding)
            }
        }
        output:
            parent display 
    - note: to call the child class static method, we have to use the child class reference

77. method overriding vs method hiding

    * method overriding
    - if child class not satisfied  with parent class method implementation then child is allow to redefine that method 
      as per requirement this process is called method overriding 
    - in method overriding, the method resolution is based on the runtime object
    - method overriding is used to achieve runtime polymorphism
    - ex:
        class Parent {
            void display() {
                System.out.println("parent display");
            }
        }
        class Child extends Parent {
            void display() {
                System.out.println("child display");
            }
        }
        class Test {
            public static void main(String[] args) {
                Parent p = new Child();
                p.display(); // calls Child's display method (method overriding)
            }
        }
        output:
            child display

    * method hiding
    - if a child class defines a static method with the same signature as a static method in the parent class,
      then the child class method hides the parent class method
    - in method hiding, the method resolution is based on the reference type
    - method hiding is not used to achieve polymorphism
    - ex:
        class Parent {
            static void display() {
                System.out.println("parent display");
            }
        }
        class Child extends Parent {
            static void display() {
                System.out.println("child display");
            }
        }
        class Test {
            public static void main(String[] args) {
                Parent p = new Child();
                p.display(); // calls Parent's display method (method hiding)
            }
        }
        output:
            parent display

78. method overriding with respected to var-arg method
- if a child class defines a method with the same signature as a var-arg method in the parent class,
    then the child class method overrides the parent class var-arg method
- ex:
    class Parent {
        void display(int... nums) { // var-arg method       
            System.out.println("parent display");
        }
    }
    class Child extends Parent {
        void display(int num) { // regular method
            System.out.println("child display");
        }
    }
    class Test {
        public static void main(String[] args) {
            Parent p = new Child();
            p.display(10); // calls parent's display method (method overloading)
            
            Child p1 = new Child();
            p1.display(10); // calls child's display method (method overriding)
        }
    }
    output:
        parent display
        child display

79. Overloading vs Overriding

- Overloading (Compile-time Polymorphism):
  - within the same class, we can define more than one method with different parameters; this process is called method overloading.
  - we can overload private, final, and static methods.
  - in method overloading, return type declaration has no restrictions.
  - in overloading, the throws keyword declaration has no restrictions.
  - in overloading, method resolution is always based on the object reference.

- Overriding (Run-time Polymorphism):
  - if a child class is not satisfied with the parent class method implementation, then the child is allowed to redefine that method as per the requirement; this process is called method overriding. 
  - we can't override private, final, and static methods.
  - in method overriding, the return type must be the same or a covariant is allowed.
  - in overriding, if the child class method throws any exception, then the parent class method should throw the same error or its parent.
  - in overriding, method resolution is always based on the runtime object.

80. Polymorphism: Flexibility and dynamic behavior.
    - one action can be performed in multiple ways; this process is called polymorphism.
      or 
    - one object can perform multiple tasks; this process is called polymorphism.

    ex: a parent class can hold its own object or its child class object.
  
    . There are two types of polymorphism:

    1) Compile-time Polymorphism / Method Overloading:
    - within the same class, we can define more than one method with different parameters; this process is called method overloading.

    2) Runtime Polymorphism / Method Overriding:
    - if a child class is not satisfied with the parent class method implementation, then the child is allowed to redefine that method as per the requirement; this process is called method overriding.
    - in method overriding, parameters and method name must be same.
    - return type covariant is allowed. 
       ex: if the super method throws an Exception, we can throw a RuntimeException in the sub-method.

81. coupling
- Coupling refers to how much one class or module depends on another.
- loose coupling is good because it makes code easier to change and maintain.
- High coupling is bad because it makes code harder to change and more complex.
    
    there are two types of coupling: tight coupling and loose coupling
    1) Tight Coupling
    - Tight coupling means classes are strongly dependent on each other.
    - If one class changes, other classes may also need to change.
    - Tight coupling makes code harder to maintain and test.
    - ex:
        class A {
            void methodA() {
                System.out.println("Method A");
            }
        }
        class B {
            A a = new A(); // B is tightly coupled to A
            void methodB() {
                a.methodA();
                System.out.println("Method B");
            }
        }
        class Test {
            public static void main(String[] args) {
                B b = new B();
                b.methodB();
            }
        }
        output:
            Method A
            Method B

    
    2) Loose Coupling
    - Loose coupling means classes are less dependent on each other.
    - If one class changes, other classes may not need to change.
    - Loose coupling makes code easier to maintain and test.
    - ex:
        class A {   
            void methodA() {
                System.out.println("Method A");
            }
        }
        class B {
            A a; // B is loosely coupled to A
            B(A a) { // A is injected into B
                this.a = a;
            }
            void methodB() {
                a.methodA();
                System.out.println("Method B");
            }
        }
        class Test {
            public static void main(String[] args) {
                A a = new A();
                B b = new B(a); // injecting A into B
                b.methodB();
            }
        }
        output:
            Method A
            Method B

82. cohesion
- Cohesion means how well the parts of a class or module work together for a single purpose.
- High cohesion is good: the class does one thing well and is easy to understand.
- Low cohesion is bad: the class does many unrelated things and is hard to understand.

83. object type casting
- object type casting is the process of converting one object type to another object type
- there are two types of object type casting: upcasting and downcasting
    1) upcasting
    - upcasting is the process of converting a subclass object to a superclass object
    - upcasting is done automatically by the compiler
    - upcasting is safe because the subclass object contains all the properties and behaviors of the superclass
    - ex:
        class Parent {
            void display() {
                System.out.println("parent display");
            }
        }
        class Child extends Parent {
            void display() {
                System.out.println("child display");
            }
            void childMethod() {
                System.out.println("child method");
            }
        }
        class Test {
            public static void main(String[] args) {
                Parent p = new Child(); // upcasting
                p.display(); // calls Child's display method (method overriding)
                // p.childMethod(); // error: cannot find symbol
            }
        }
        output:
            child display

    2) downcasting
    - downcasting is the process of converting a superclass object to a subclass object
    - downcasting is done manually by the programmer using type casting operator
    - downcasting is unsafe because the superclass object may not contain all the properties and behaviors of the subclass
    - ex:
        class Parent {
            void display() {
                System.out.println("parent display");
            }
        }
        class Child extends Parent {
            void display() {
                System.out.println("child display");
            }
            void childMethod() {
                System.out.println("child method");
            }
        }
        class Test {
            public static void main(String[] args) {
                Parent p = new Parent();
                Child c = (Child) p; // downcasting (unsafe)
                c.display(); // calls Child's display method (method overriding)
                c.childMethod(); // calls Child's childMethod
            }
        }
        output:
            Exception in thread "main" java.lang.ClassCastException: Parent cannot be cast to Child

84. static control flow
- static control flow is the order in which static blocks, static variables, and main method are executed
- static blocks and static variables are executed in the order they are defined in the class
- main method is executed after all static blocks and static variables are executed
- ex:
    class Test {
        static int a = 10; // static variable
        static {
            System.out.println("static block 1");
        }
        static int b = 20; // static variable
        static {
            System.out.println("static block 2");
        }
        public static void main(String[] args) {            
            System.out.println("main method");
            System.out.println("a = " + a);
            System.out.println("b = " + b);
        }
    }
    output:
        static block 1
        static block 2
        main method
        a = 10
        b = 20

85. static block
- static block is a block of code that is executed when the class is loaded into memory
- static block is used to initialize static variables
- static block is executed only once when the class is loaded into memory
- ex:
    class Test {
        static int a;   // static variable
        static {
            a = 10; // initializing static variable
            System.out.println("static block");
        }
        public static void main(String[] args) {
            System.out.println("main method");
            System.out.println("a = " + a);
        }
    }
    output:
        static block
        main method
        a = 10

86. static control flow in parent - child  relationship
- in parent-child relationship, static blocks and static variables of the parent class are executed first
   and then static blocks and static variables of the child class are executed
- ex:
    class Parent {
        static int a = 10; // static variable
        static {    
            System.out.println("parent static block 1");
        }
        static int b = 20; // static variable
        static {
            System.out.println("parent static block 2");
        }
    }
    class Child extends Parent {
        static int c = 30; // static variable
        static {
            System.out.println("child static block 1");
        }
        static int d = 40; // static variable
        static {
            System.out.println("child static block 2");
        }
    }
    class Test {
        public static void main(String[] args) {
            System.out.println("main method");
            System.out.println("a = " + Parent.a);
            System.out.println("b = " + Parent.b);
            System.out.println("c = " + Child.c);
            System.out.println("d = " + Child.d);
        }
    }
    output:
        parent static block 1
        parent static block 2
        child static block 1
        child static block 2
        main method
        a = 10
        b = 20
        c = 30
        d = 40

87. instance control flow
- instance control flow is the order in which instance blocks, instance variables, and constructor are executed
- instance blocks and instance variables are executed in the order they are defined in the class
- constructor is executed after all instance blocks and instance variables are executed
- ex:
    class Test {
        int a = 10; // instance variable
        {
            System.out.println("instance block 1");
        }
        int b = 20; // instance variable
        {
            System.out.println("instance block 2");
        }
        Test() { // constructor
            System.out.println("constructor");
        }
        public static void main(String[] args) {
            Test t = new Test(); // creating object of Test class
            System.out.println("a = " + t.a);
            System.out.println("b = " + t.b);
        }
    }
    output:
        instance block 1
        instance block 2
        constructor
        a = 10
        b = 20


88. instance control flow in parent - child relationship
- in parent-child relationship, instance blocks and instance variables of the parent class are executed first
    and then instance blocks and instance variables of the child class are executed
- constructor of the parent class is executed first and then constructor of the child class is executed
- ex:
    class Parent {
        int a = 10; // instance variable
        {
            System.out.println("parent instance block 1");
        }
        int b = 20; // instance variable    
        {
            System.out.println("parent instance block 2");
        }
        Parent() { // constructor
            System.out.println("parent constructor");
        }
    }
    class Child extends Parent {
        int c = 30; // instance variable
        {
            System.out.println("child instance block 1");
        }
        int d = 40; // instance variable    
        {
            System.out.println("child instance block 2");
        }
        Child() { // constructor
            System.out.println("child constructor");
        }
    }
    class Test {
        public static void main(String[] args) {
            Child c = new Child(); // creating object of Child class
            System.out.println("a = " + c.a);
            System.out.println("b = " + c.b);
            System.out.println("c = " + c.c);
            System.out.println("d = " + c.d);
        }
    }
    output:
        parent instance block 1
        parent instance block 2
        parent constructor
        child instance block 1
        child instance block 2
        child constructor
        a = 10
        b = 20
        c = 30
        d = 40

89. how many ways we can create object in java
- there are 3 ways to create object in java

    1) using new keyword
    - ex: Template obj = new Template();

    2) using newInstance() method of Class class
    - ex: Class cls = Class.forName("Template");
        Template obj = (Template) cls.newInstance();

        note: this method is deprecated in java 9 and later versions

    3) using clone() method of Object class
    - ex: Template obj1 = new Template();
          Template obj2 = (Template) obj1.clone();

    4) using factory method  
    - ex:
        class Singleton {
            private static Singleton instance; 
            private Singleton() { 
            }
            public static Singleton getInstance() { 
                if (instance == null) { 
                    instance = new Singleton();
                }
                return instance; 
            }
        }
        class Test {
            public static void main(String[] args) {
                Singleton s1 = Singleton.getInstance();
                Singleton s2 = Singleton.getInstance(); 
                System.out.println(s1 == s2); 
            }
        }

    5) using deserialization
    - ex:
        class Student implements Serializable {
            int id;
            String name;
            Student(int id, String name) {
                this.id = id;
                this.name = name;
            }
        }
        class Test {
            public static void main(String[] args) throws Exception {
                Student s1 = new Student(1, "John");
                // serialize the object
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"));
                oos.writeObject(s1);
                oos.close();
                // deserialize the object
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"));
                Student s2 = (Student) ois.readObject();
                ois.close();
                System.out.println("id = " + s2.id + ", name = " + s2.name);
            }
        }
        output:
            id = 1, name = John 


90. constructor
- constructor is a special method that is used to initialize the object of a class
- constructor is called at the time of object creation to initialize the object
- constructor name must be same as class name
- constructor does not have any return type, not even void
- constructor can have parameters to initialize the object with different values
- if we do not define any constructor, then compiler will provide a default constructor
- ex:
    class Test {
        int a;
        Test(int a) { // parameterized constructor
            this.a = a; // initializing instance variable
        }
        public static void main(String[] args) {
            Test t = new Test(10); // creating object of Test class
            System.out.println("a = " + t.a);
        }
    }
    output: 
        a = 10

91. type of constructor
- there are two types of constructor: default constructor and parameterized constructor
    1) default constructor
    - if we do not define any constructor, then compiler will provide a default constructor
    - default constructor does not have any parameters
    - default constructor initializes the object with default values
    - ex:
        class Test {
            int a; // instance variable
            // default constructor provided by compiler
            public static void main(String[] args) {
                Test t = new Test(); // creating object of Test class
                System.out.println("a = " + t.a); // default value of int is 0
            }
        }
        output:
            a = 0

    2) parameterized constructor
    - parameterized constructor is a constructor that has parameters
    - parameterized constructor initializes the object with different values
    - ex:
        class Test {
            int a; // instance variable
            Test(int a) { // parameterized constructor
                this.a = a; // initializing instance variable
            }
            public static void main(String[] args) {
                Test t = new Test(10); // creating object of Test class
                System.out.println("a = " + t.a);
            }
        }
        output:
            a = 10

92. difference between constructor and instance block
- constructor is a special method that is used to initialize the object of a class
- instance block is a block of code that is executed when an object of the class is created
- constructor name must be same as class name, but instance block does not have any name
- constructor can have parameters, but instance block cannot have parameters
- constructor is called only once at the time of object creation, but instance block is executed every time an object is created
- constructor can be overloaded, but instance block cannot be overloaded
- ex:
    class Test {
        int a;
        { // instance block
            a = 10; // initializing instance variable
            System.out.println("instance block");
        }
        Test(int a) { // parameterized constructor
            this.a = a; // initializing instance variable
            System.out.println("constructor");
        }
        public static void main(String[] args) {
            Test t1 = new Test(20); // creating object of Test class
            System.out.println("a = " + t1.a);
            Test t2 = new Test(30); // creating another object of Test class
            System.out.println("a = " + t2.a);
        }
    }
    output:
        instance block
        constructor
        a = 20
        instance block
        constructor
        a = 30

93. singleton class
- singleton class is a class that can have only one object at a time
- to create a singleton class, we need to follow these steps:
    1) make the constructor of the class private
    2) create a static method that returns the instance of the class
    3) create a static variable to hold the instance of the class
- ex:
    class Singleton {
        private static Singleton instance; // static variable to hold the instance
        private Singleton() { // private constructor
            // private constructor to prevent instantiation
        }
        public static Singleton getInstance() { // static method to return the instance
            if (instance == null) { // if instance is null, create a new instance
                instance = new Singleton();
            }
            return instance; // return the instance
        }
    }
    class Test {
        public static void main(String[] args) {
            Singleton s1 = Singleton.getInstance(); // getting the instance of Singleton class
            Singleton s2 = Singleton.getInstance(); // getting the instance of Singleton class
            System.out.println(s1 == s2); // true, both references point to the same object
        }
    }
    output:
        true

94. Advantages of singleton class
- Ensures only one object exists in the JVM.
- Useful when exactly one resource is needed (e.g., configuration manager, logger, cache, thread pool)
- Since only one instance is created, memory usage is lower compared to creating multiple objects of the same class.

95. object
- object is an instance of a class and object is physical representation of a class
