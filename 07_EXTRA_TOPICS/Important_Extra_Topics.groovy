
1. Singleton class

- Singleton is a design pattern in that each class will have only one instance in entire application.

  * there are two ways to create singleton class

    i) Eager initialization

        ```
        class Singleton {
            private static final Singleton instance = new Singleton()
            private Singleton() {
                // private constructor
            }
            public static Singleton getInstance() {
                return instance
            }
        }
        ```
    ii) Lazy initialization
        ```
        class Singleton {
            private static Singleton instance = null
            private Singleton() {
                // private constructor
            }
            public static Singleton getInstance() {
                if (instance == null) {
                    instance = new Singleton()
                }
                return instance
            }
        }
        ```
2. How to break a singleton class?
    
    * there are several ways to break a singleton class
      i) Cloning
        ```
        class Singleton implements Cloneable {
            private static Singleton instance = null
            private Singleton() {
                // private constructor
            }
            public static Singleton getInstance() {
                if (instance == null) {
                    instance = new Singleton()
                }
                return instance
            }
        }

        public class Main {
            public static void main(String[] args) {
                Singleton instance1 = Singleton.getInstance()
                Singleton instance2 = (Singleton) instance1.clone()
                System.out.println(instance1 == instance2) // false
            }
        }
        ```
      ii) Serialization/Deserialization

        ```
        import java.io.*

        class Singleton implements Serializable {
            private static Singleton instance = null
            private Singleton() {
                // private constructor
            }
            public static Singleton getInstance() {
                if (instance == null) {
                    instance = new Singleton()
                }
                return instance
            }
        }

        public class Main {
            public static void main(String[] args) throws Exception {
                Singleton instance1 = Singleton.getInstance()

                // Serialize the singleton instance
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.ser"))
                oos.writeObject(instance1)
                oos.close()

                // Deserialize the singleton instance
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.ser"))
                Singleton instance2 = (Singleton) ois.readObject()
                ois.close()

                System.out.println(instance1 == instance2) // false
            }
        }
        ```
      
    
2. How to make a class immutable?


class SingletonDemo{
  private static SingletonDemo singletonDemo;

  private SingletonDemo() {
  }

  public static SingletonDemo getInstance(){
    if(singletonDemo == null)
    {
      singletonDemo = new SingletonDemo();
      return singletonDemo;
    } else {
      return singletonDemo;
    }
  }
}

final class Test_10{
  private String varName ;
  private Test_10(String varName)
  {
    this.varName = varName;
  }

  public Test_10 getInstance(String name){
    if (this.varName.equals(name)) {
      return this;
    } else {
      return new Test_10(name);
    }
  }

  public static void main(String[] args) {

    Test_10 test = new Test_10("Vivek");
    System.out.println(test.hashCode());

    Test_10 test2 = test.getInstance("Vivek");
    System.out.println(test2.hashCode());


    SingletonDemo demo1 = SingletonDemo.getInstance();
    System.out.println(demo1.hashCode());
    SingletonDemo demo2 = SingletonDemo.getInstance();
    System.out.println(demo2.hashCode());
  }
}


3. Prime Number and Armstrong


public class Test_11 {

  public static void main(String[] args) {

    int num = 12;
    boolean isPrime = true;

    for (int i = 2; i < num; i++) {
      if (num % i == 0) {
        isPrime = false;
        break;
      }
    }

    if (isPrime) {
      System.out.println(num + " is a Prime number.");
    } else {
      System.out.println(num + " is not a Prime number.");
    }

    System.out.println("----------------------------------");

    int num1 = 153;
    int original = num1;
    int sum = 0;

    while(num1 > 0)
    {
      int digit = num1 % 10;
      sum += digit * digit * digit;
      num1 = num1 / 10;
    }

    if(original == sum)
    {
      System.out.println("Armstrong Number");
    } else {
      System.out.println("Not Armstrong Number");
    }

  }
}
