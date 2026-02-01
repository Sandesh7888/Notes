NoteBook 1 :
------------


1. Identifier 
- a name of the java program is called identifier , which can used for identification purpose .
- it can be a variable , methodName , ClassName or lableName
- allowed characters are 'a to z ', 'A to Z' , '_' , '$'

2. Reserved Words 
- In Java, some words are reserved to represent a meaning or functionality; such types of words are Reserved Words.
- in java 53 Reserved words are there
    - keywords 
        - if keywords are associated with functionality that is called keywords
        - used keywords 48 
        - unused keywords 2 ('goto' , 'const')

            - keywords for datatype (8)
                - byte, short, int long , float, double, boolean, char
            - keywords for flowcontrol (11)
                - if, else, switch, case, default, while, do, for, break, continue, return
            - object related keyword (4)
                - new, instanceof, super, this
            - keywords for Modifiers
                - public, private, protected, static, final, abstract, synchronized, native, strictfp, volatile
            - keywords for exception handling 
                - try, catch, finally, throw, throws, assert
            - class related keywords 
                - class, interface, extends, implements, import, package
            - void return type keyword
                if method won't return anything
            - unused keywords
                - goto : uses of goto created sevral problem in old languages and so this keyword is deprecated
                - const : replaced with final keyword
            - enum keyword
                - enum is a group constant variables

    - reserved literals
        - if reserved word represents only value that reserved word are literals
        - 'true' , 'false' and 'null'

3. Why Java is a strongly typed language
- In Java, every variable and every expression has some type. Each and every datatype is clearly defined, and every assignment should be checked by the compiler for type compatibility.
- Because of the above reasons, we conclude Java is a strongly typed programming language.

4. Java is a pure object-oriented language or not 
- Java is not a pure object-oriented language because several OOPs features are not satisfied by Java (like operator overloading, multiple inheritance).
- Moreover, we are depending on primitive datatypes which are non-objects.

    - primitive datatype
        1) numeric datatype
            - integral datatype - byte, short, int, long
            - floating point datatype - float , double
        2) non-numeric dataype
            - char , boolean

5. datatypes
    - byte - 1 byte (8 bits)
        best choice when we want to handle a data stream pipelines(over a network)
    - short - 2 byte (16 bits)
    - int - 4 byte (32 bits)
    - long - 8 byte (64 bits)
    - float - 4 byte (32 bits)
    - double - 8 byte (64 bits)
    - boolean - size not applicable 
    - char - 2 byte (16 bits)

6. literals 
- a constant value which can be assign to the variable is called literal
    int x = 10; --- 10 is literal

7. String literal 
- a sequence of a characters within a double quotes is treated a string literal
    String x = "vivek";

8. Array 
- array is a indexed collection of fixed no of homogenious data elements 
- array can holds fixed number of values of same type.
- Advantages : the main Advantages of a array is we can represent n no of values by using single variable , so that will 
   improves readablity of a code.
- Disadvantages: Arrays are fixed in size. Once we create an array, there is no chance of increasing or decreasing the size based on our requirement.
- Example: `int[] arr = {1,2,3};`

    . One Dimentional Array :
    - 

    . Two Dimentional Array :
    -

    . Three Dimentional Array :
    - 

    * Array Creation :
    ------------------
    - int [] a = new int[3];
        - every array in java is an object only hence we can create arrays by using new operator 
        Note: every array type corresponding classes available and this classes are part of java language and not available
            to programmer level 
            System.out.println(s.getClass().getName()); -> [a

    * loop hole in arrays
    ---------------------
    - int[] a = new int[];
        - CE : at the time array creation compalsary we should specify the size otherwise we will get compile time error.

    - int[] x = new int[0]; -> valid 

    - int[] x = new int[-3]; CE : NegativeArraySizeException

    - int[] x = new int['a'] -> valid : it will store the 97 ascii value

    - int[] x = new int[10l] -> CE : possible loss of precission , found long , required int

    Note: To specify the array size, allowed datatypes are byte, short, char, int (otherwise you will get a compile-time error).


    * array declaration & creation and Initilization
    ------------------------------------------------
    - int[] x -> array declaration 
    - x = new int[3]; -> array creation 
    - x[0] = 10; -> array initilization

    - int[] x = {10, 20, 30, 40} ->  array declaration & creation and Initilization in single line


9. length vs length()

    * length
    --------
    - length is a final variable applicable for arrays.
    - length variable represents the size of an array.
    ex: int[] x = new int[6];
        System.out.println(x.length); -> OP: 6

        System.out.println(x.length()); -> CE

    * length()
    - length() method is a final method applicable for string objects.
    - length() method represents a count of the string characters.
    ex: String name = "Vivek";
        System.out.println(name.length()); -> OP: 5


10. Anonymous Array 
- sometimes we can declare an array without name such type of nameless array are called anonymous array.
- main use of anonymous array is instant use 
ex : new int{10,20,30};



11. Types of a variable 

- based on type of value variables are divided into two type 

    A. primitive variable 
    B. reference variable 

- base on position of a declaration and behaviour all variable are divided into three type 

    . Instance Variables (Non-static Fields):
    - if a value of a variable is varied from object to object that varibale called as instance variable
    - They are created when an object is created and destroyed when the object is destroyed.
    - JVM will provide default value for Instance Variable.
    - Memory Location: Heap (as part of the object).

        note -: 
                - '''
                class Test 
                {
                    int x = 10;
                    public static void main(String[] args)
                    {
                        System.out.println(x); -> CE: non-static variable x cannot be referenced from a static context 
                        Test test = new Test();
                        System.out.println(test.x);  -> valid
                    }
                }
                '''

  . Static Variables (Class variables):
    - if value of a variable is not varied from object to object and its common for all objects this type of variable is called 
        static variable.
    - Declared with the `static` modifier within a class, but outside any method, constructor or block.
    - There will br only one copy for a  class variable for that class, all class objects are its common.
    - They are created when the program starts and destroyed when the program stops.
    - Memory Location: "Method Area"
        
        note -: 
                - '''
                class Test 
                {
                    static int x = 10;
                    public static void main(String[] args)
                    {
                        system.out.println(x);  -> 10

                        Test test = new Test();
                        system.out.println(test.x);  -> 10

                        system.out.println(Test.x);  -> 10
                    }
                }
                '''

        note -: 
                - '''
                class Test 
                {
                    static int x = 10;
                    int y = 100;
                    public static void main(String[] args)
                    {
                        Test test = new Test();
                        system.out.println(test.x);  -> 10
                        system.out.println(test.y);  -> 100

                        Test test1 = new Test();
                        test1.x = 200;
                        test1.y = 700;
                        system.out.println(test1.x);  -> 200
                        system.out.println(test1.y);  -> 700

                        Test test3 = new Test();
                        system.out.println(test3.x);  -> 700
                        system.out.println(test3.y);  -> 100
                    }
                }
                '''


  . Local Variables:
    - sometimes to meet a temprory requirement of execution we can Declare a variable inside methods, constructors, or blocks
        such types of variable is called local variable.
    - They are created when the method, constructor or block is entered and destroyed once it exits.
    - JVM won't provide defoult varibale for local variable , compiler will not throw an error but before use we have to initialize
        them , otherwise we will get COMPILER ERROR : 'variable x might not have been initialized'
    - Memory Location: Stack memory.
    - local variable are thread safe - becouse each thread will create a seprate copy for local variable 

        note -: 
                - '''
                class Test 
                {
                    public static void main(String[] args)
                    {
                        int x;
                        System.out.println(x); // CE: variable x might not be initialized
                    }
                }
                '''

12. var - arg method (variable no of argument method)
- we can declare a method which can take no of arguments such type of method are called var-arg method
-we can declare var-arg method as follows
    m1(int... x) or m1(int ...x) or m1(int...x)

    test:
    m1();
    m1(10,20);
    m1(10,20,30);

    note :
        m1(int x, int...y); -> valid
        m1(String s , double...y); -> valid

        m1(int...x, double...y)-> invalid


13. main() method 

- public static void main(String[] args)
    - public - to call by jvm from anywhere
    - static - without existance object also jvm has to call this method 
    - void - main method wont return anything 
    - main - name of the method which is configured in jvm 
    - String[] args - command line argument 

    note : we can declare a main method with final , synchronized modifier
            - static public synchronized final -> this modifiers order is not required we can give any way 

    We can Declare a main() as below way also
    
    ```
    class Test 
    {
        static public synchronized final void main(String[] args)
        {
            System.out.println("HI");
        }
    }
    ```

    ```
    class Test 
    {
       static public synchronized final void main(String... args)
        {
            System.out.println("HI");
        }
    }
    ```

13. increment and decrement operators

    * Increment
    - pre-increment : ++x
    - post-increment : x++

    * Decrement
    - pre-decrement : --x
    - post-decrement : x--


14. instanceof
- The instanceof operator is used to test whether an object is an instance of a specific class or subclass, 
    or implements a specific interface.
    ex: 
    ```
    class Animal {}
    class Dog extends Animal {}
    
    public class Test {
        public static void main(String[] args) {
            Animal a = new Dog();
            System.out.println(a instanceof Dog);    // true
            System.out.println(a instanceof Animal); // true
            System.out.println(a instanceof Object); // true
        }
    }
    ```

15. Infinity
- in integral arithmetic (byte, short, int, long) there is no way to represent Infinity
  ex: System.out.println(10/0);  -> OP: AE /by Zero
- but in floating point Arithmatic (float, double) there is way to represent Infinity for this float and double
    classes contains the following two constants
    - POSITIVE_INFINITY
    - NEGATIVE_INFINITY
- hence : even the result is infinity we won't get Arithmatic Exception in floating point Arithmatic
    ex: System.out.println(10/0.0);  -> OP : Infinity
        System.out.println(-10/0.0); -> OP : -Infinity
        System.out.println(-10/0);   -> OP : -Infinity

16. NaN (Not a Number)
- in integral arithmetic (byte, short, int, long) there is no way to represent undefined results
    - hence : if the result undefined we will get RuntimeException saying 
        ArithmaticException : /by Zero
    ex: System.out.println(0/0);  -> OP: AE /by Zero
- but in floating point Arithmatic (float, double) there is way to represent undefined results for this 
    Float and Double classes containes 'NaN' constant
    - hence : if the result is undefined we won't get floating point Arithmatic Exception 
    ex: System.out.println(0.0/0);   OP: NaN
        System.out.println(-0.0/0);  OP: NaN

17. Arithmetic Exception:
- It is a runtime exception, not a compile-time error.
- It is possible only in integral arithmetic but not in floating point.
- The only operators which cause Arithmetic Exception are / and %.

18. String Concatenation Operator (+) :-
- the only overloaded operator in java is '+' operator sometimes it access Arithmatic addition operator and sometimes 
    it access String concatenation operator
- Note : if atleast one argument is string type then '+' operator access concatinaton operator and if both argument are 
    no type then '+' operator access Arithmatic addition operator

    ex:
        String a = "Vivek";
        int b = 10, c = 20, d = 30;

        System.out.println(a + b +  c + d);  OP: Vivek102030
        System.out.println(b +  c + d + a);  OP: 60Vivek
        System.out.println(c + d + a + b);  OP: 50Vivek10
        System.out.println(d + a + b + c);  OP: 30Vivek1020

19. Relational Operators (<, <=, >, >=) :
- we can apply Relational Operators for every primitive type except boolean

    ex: 
        System.out.println(10 < 20);        OP: true
        System.out.println('a' < 20);       OP: false
        System.out.println('a' < 97.6);     OP: true
        System.out.println('a' < 'A');      OP: true
        System.out.println(true > false);   CE: operator > cannot be applied to boolean

- we can apply Relational Operator for Object Types

    ex:
        System.out.println("vivek123" > "durga");   
                OP: CE : Operator > cannot be applied to Java.lang.String, Java.lang.String

- nesting of relational operator is not allowed otherwise we will get compile time error 
    ex: 
        System.out.println(10 < 20 < 30);  
            OP: true < 30  
            CE: Operator < cannot br applied to boolean, int

20. equality operator 

- `==`
    
    - Purpose: Checks if two values are equal.
    - For primitives (like int, char, etc.): Compares actual values.
    - For objects (like String, custom classes): 
        Compares references (i.e., whether both refer to the exact same object in memory).

        Note: 
            ex:
                Thread t = new Thread();
                String s = new String("Vivek");
                Object o = new Object();

                System.out.println(s == o);           OP: false
                System.out.println(t == o);           OP: false
                System.out.println(s == t);           OP: CE : incompatible Type Java.lang.String, Java.lang.Thread

- `!=`
    - Purpose: Checks if two values are not equal.
    - For primitives: True if values are different.
    - For objects: True if references point to different objects.

21. Difference between '==' operator & .equals() method

- in general we can use '==' operator for reference comparison (address comparision)
    and .equals() method for content comparision

    ex:
        String s1 = new String("Vivek");
        String s2 = new String("Vivek");

        System.out.println(s1 == s2);           OP: false
        System.out.println(s1.equals(s2));      OP: true

    Note: for any object reference 'r == null' always false
            but 
            'null == null' is always true

        ex:
            String s1 = new String("Vivek");
            String s2 = null;
            System.out.println(s1 == null);      OP: false
            System.out.println(s2 == null);      OP: true
            System.out.println(null == null);    OP: true

22. Bitwisw Operator ( '&' , '|' , '^' )
- '&' returns true if both argument are true
- '|' returns true if atleast one argument is true
- '^' : " X - OR "-> returns true if both argument are different 

    ex: 
        System.out.println(true & false);   OP : false
        System.out.println(true | false);   OP : true
        System.out.println(true ^ false);   OP : true

23. Short Circuit Operator :
- this are exactly same as bitwise operators ('&' , '|') except the following difference

& , | :->
- both arguments should be evoluated always 
- relatively performance is low
- applicable for both boolean & integral type 

&& , || :->
- second argument evoluation is optional 
- relativly performance is high 
- applicable only for boolean bu not for integral type 


24. Type - cast operator :-

    1) Implicit type casting : 
    - compiler is responsible to perform implici type casting 
    - whenever we assigning smaller datatype value to bigger datatype variable implicit type casting will be performed 
    - is is also known as widening or upcasting
    - the following are various posible conversion where implicit Type casting will be performed
    
    ex: byte -> short -> int -> long -> float -> double 
                char -> int -> long -> float -> double 

    2) Explicit type casting :-
    - programmer is responsible to perform explicit type casting 
    - whenever we assigning bigger datatype value to smaller datatype variable then explicit type cating will br
        required
    - the following are various posiblities where explicit type casting is required.
        ex: 
            double -> float -> long -> int -> short -> byte
            double -> float -> long -> int -> char
    
        ex: int x = 130;
            byte b = x;                -> CE: possible loss of precision found: int required: byte
            byte b = (byte) x;
            System.out.println(b);      -> OP: -126

    - whenever we assigning bigger datatype value to smaller datatype variable by explicit typecasting 
        the most significant will be list significant bits
        ex:
            double d = 130.456;
            int x = (int) d;
            System.out.println(x);      OP: 130

            byte b = (byte) d;
            System.out.println(b);      OP: -126

25. Assignment Operators :-
    1) simple Assignment:-
        ex: int x = 10;

    2) Chained Assignment:-
        ex int a = b = c = d = 10;
            CE: cannot find symbol b , c, d.
        
        but 
            int b, c, d;
            int a = b = c = d = 10;

26. Compound Assignment Operator:-
    - sometimes assign operator mixed with some other operators such type of assigment operator are 
        called compound assignment operator.

    '+=' , '-=' , '*=' , '/=' , '&=' , '|=' , '^=' , '>>=' (Right shift) , '>>>=' (unsign equal to), 
    '<<=' (left Shift)

    - 11 operators

27. Conditional Operator (?:)
    - the only possible ternary operator in java is condition operator 

    syntax : 
        int x = (10 < 20) ? 30 : 40;
        System.out.println(x); -> 30

    - we can perform nesting at conditional operator aslo
        int x = (10 > 20) ? 30 (40 > 50) ? 60 : 70;
        System.out.println(x); -> 70

28. 'new' operator 

    - we can use the new operator to create objects in java.
    
    note : after creating a object constructor will be perform initialization of a object.
            hence: constructor os not creation of a object & it is a initionlozation of a object.


29. new VS newInstance()
    
    * new : we can use new operator to create am object if we know classname at the beggining 
        ex: 
            Test t = new Test();
    - in the case of new we can call any constructor from class as per our requirement 
        ex: 
            Test t = new Test();
            Test t1 = new Test(10);
            Test T2 = new Test("vivek");
    - While using new Operator at runtime if the corresponding .class file is not available 
        then we will get RuntimeException : NoClassDefFoundError
    
    * newInstance() : newInstance() method is present in 'Class' class
    - we can use newinstance() method to create object if we don't know class name at the beggining and 
        it is available dynamically at runtime.
        
        ex : 
           String className = "Test";
           Object o = Class.forName(className).newInstance();
           System.out.println("Object created SuccessFully " + o.getClass().getName()); OP-> Test

    - in the case of newInstance() method it internally calls an no-arg constructor 
        hence: to use of newInstance() method class compalsary should have no-arg constructor
                Otherwise we will get runtime Exception 
                RE : InstantiationException
    - while using newInstance() method at runtime if the corresponding .class file is not avalible 
        then we will get RuntimeException : ClassNotFoundException


30. NoClassDefFoundError vs ClassNotFoundException 

    * NoClassDefFoundError
    - for hard coded classNames at runtime if the corresponding .class file is not availbale 
        then we will get Runtime Exception NoClassDefFoundError
        ex:
            Test t = new Test();
            - at runtime if test.class file not present then we will get RE : NoClassDefFoundError : Test

            public class Test 
            {
                static public synchronized final void main(String... args) throws Exception
                {
                    System.out.println("Execution Started");
                    Thread.sleep(15000);
                    System.out.println("Sleep");
        

                    TestNew testObject = new TestNew();
                    testObject.print();
                }
            }

            class TestNew
            {
                public void print()
                {
                    System.out.println("Helper class method");
                }
            }
        
        Note: When thread goes in sleep mode delete the TestNew.class file

        OP:
            Exception in thread "main" java.lang.NoClassDefFoundError: TestNew
                    at Test.main(Test.java:11)
            Caused by: java.lang.ClassNotFoundException: TestNew

    - this is unchecked exception

    * ClassNotFoundException
    - for dyanamically provided className at runtime if the corresponding .class file is not available 
        then we will get checked Exception ClassNotFoundException
        ex:
            String className = "TestNew";
            Object o = Class.forName(className).newInstance();
            System.out.println(o.getClass().getName());

            - at runtime if TestNew.class file not present then we will get RE : ClassNotFoundException : TestNew

            0/p:
                Exception in thread "main" java.lang.ClassNotFoundException: TestNew
            

        public class Test {
            public static synchronized final void main(String... args) throws Exception {
                System.out.println("Execution Started");

                Thread.sleep(12000);

                Object obj = Class.forName("TestNew").newInstance();

                System.out.println(obj.getClass().getName());
            }
        }

        class TestNew {
            public void print() {
                System.out.println("Helper class method");
            }
        }

        OP : 
            Execution Started
            Exception in thread "main" java.lang.ClassNotFoundException: TestNew
            at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641)

31. instanceof and isInstance()

    * instanceof operator
    - instanceof operator is used to check whether the given object is an instance of the specified class or its subclass
    - we can use instanceof operator when we know the class name in advance
    - applicable only for reference variable
    ex:
        String s = "Vivek";
        System.out.println(s instanceof String); OP: true
        System.out.println(s instanceof Object); OP: true
        System.out.println(s instanceof Runnable); OP: false
        System.out.println(s instanceof Comparable); OP: true
        System.out.println(s instanceof Cloneable); OP: true
        System.out.println(s instanceof Thread); OP: CE : Incompatible types: String cannot be converted to Thread

    * isInstance() method
    - isInstance() method is present in Class class and it is used to check whether the given object is an instance of the
         specified class or its subclass
    - we can use isInstance() method when we don't know the class name in advance and it is available 
        dynamically at runtime
    - applicable for both reference variable and class object
    ex:
        String s = "Vivek";
        System.out.println(String.class.isInstance(s)); OP: true
        System.out.println(Object.class.isInstance(s)); OP: true
        System.out.println(Runnable.class.isInstance(s)); OP: false
        System.out.println(Comparable.class.isInstance(s)); OP: true
        System.out.println(Cloneable.class.isInstance(s)); OP: true
        System.out.println(Thread.class.isInstance(s)); OP: false

32. flow Control statements
    1) if-else

    2) switch :
        ex:
            int x = 20;
            switch(x) {
                case 10:
                    println "x is 10"
                    break
                case 20:
                    println "x is 20"
                    break
                case 30:
                    println "x is 30"
                    break
                default:
                    println "x is something else"
            }
        
    - allowed data types for switch expression 
        - byte , short , int , char , String , enum
        - Byte , Short , Integer , Character (Wrapper class of above primitive datatypes)
        - String (Java 7 onwards)
    - not allowed data types for switch expression
        - long , float , double , boolean
        - Long , Float , Double , Boolean (Wrapper class of above primitive datatypes)

    3) while
    - if we don't know the no of iteration in advance then we can go for while loop
    - in while loop only boolean expression is allowed and only one condition check is there
    ex:
        int i = 1;
        while(i <= 10) {
            System.out.println(i);
            i++
        }

        or 

        while(rs.next()) {
            System.out.println(rs.getInt(1));
        }
    
    4) do-while
    - if we want to execute loop body at least once then we can go for do-while loop
    - in do-while loop only boolean expression is allowed and only one condition check is there
    ex:
        int i = 1;
        do {
            System.out.println(i);
            i++
        } while(i <= 10);  
    
    5) for loop
    - if we know the no of iteration in advance then we can go for for loop
    ex:
        for(int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    
    6) for-each loop
    - if we want to iterate complete collection/array then we can go for for-each loop
    - in for-each loop we can't perform increment/decrement operation on iteration variable
    ex:
        int[] arr = {10, 20, 30, 40, 50};
        for(int val : arr) {
            System.out.println(val);
        }  
    ex2:
        int[][] arr = {{10, 20, 30, 40, 50},{60, 70, 80, 90, 100}};
        for(int val[] : arr) {
            for(int inVal : val) {
                System.out.println(inVal);
            } 
        }
        
    note:
        - we can use for-each loop only for complete iteration of collection/array
        - we can't use for-each loop if we want to iterate partially or in reverse order
        - we can't use for-each loop if we want to modify the collection/array during iteration

33. Iterable (I)
- Iterable is a marker interface present in java.lang package
- Iterable interface contains only one abstract method
    - Iterator<T> iterator();
- Iterable interface is a super interface for all collection interfaces

34. Interator (I) vs Iterable (I)
    
    * Iterator (I)
    - Iterator is an interface present in java.util package
    - Iterator interface is used to iterate the collection objects
    - Iterator interface contains three methods
        - boolean hasNext();
        - E next();
        - default void remove();
    - we can get Iterator object by calling iterator() method of Iterable interface

    * Iterable (I)
    - Iterable is a marker interface present in java.lang package
    - we can use for-each loop to iterate the collection objects because for-each loop internally uses 
        iterator() method of Iterable interface
    - Iterable interface contains only one abstract method
        - Iterator<T> iterator();
    - Iterable interface is a super interface for all collection interfaces

35. Break vs Continue

    * Break
    - break statement is used to terminate the loop or switch statement
    - when break is used inside a loop, it immediately stops the loop and moves to the next statement after the loop
    - we can use break statement only inside the loop or switch statement
    ex:
        for(int i = 1; i <= 10; i++) {
            if(i == 5) {
                break;
            }
            System.out.println(i);
        }
        OP: 1 2 3 4

    * Continue
    - continue statement is used to skip the current iteration of the loop and move to the next iteration
    - when continue is used in a loop, it skips the rest of the code in that iteration and moves to the next loop cycle
    - we can use continue statement only inside the loop
    ex:
        for(int i = 1; i <= 10; i++) {
            if(i == 5) {
                continue;   // skip only current iteration
            }
            System.out.println(i);
        }
        OP: 1 2 3 4 6 7 8 9 10

36. Java source file structure
- Every Java source file is called a compilation unit.
- A source file can have only one public class, and its name must match the file name.
- If there is no public class, the file name can be anything.
- Public class must be top-level (not nested).
- You can have multiple non-public classes in the same file.    
    
37. import statement
- The import statement allows you to use classes and interfaces from other packages.
- Import statements are placed after the package statement (if any) and before any class definitions.
- To import a single class: import java.util.List;
- To import all classes from a package: import java.util.*;
- Static import allows access to static members without qualifying with the class name:
    - import static java.lang.Math.*;
    - import static java.lang.Math.PI;

    // Usage:
    // After importing static members, you can use them directly without class qualification.
    For example:
    double r = 2.0;
    double area = PI * pow(r, 2); // Instead of Math.PI and Math.pow
    System.out.println("Area: " + area);

    * explicit import
    - import java.util.List;

    * implicit import
    - import java.util.*;

