@Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return id == student.id && age == student.age && Objects.equals(name, student.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, age);
  }


* Enumeration

  ex:
    ```Vector<String> vector = new Vector<>();
    vector.add("A");
    vector.add("B");
    vector.add("C");
    Enumeration<String> enumeration = vector.elements();
    while(enumeration.hasMoreElements()) {
        System.out.println(enumeration.nextElement());
    }```

    * Enumeration interface defines following methods
    - boolean hasMoreElements(): Returns true if the enumeration has more elements
    - E nextElement(): Returns the next element in the enumeration


* Iterator
    ex:
    ```List<String> list = new ArrayList<>();
    list.add("A");
    list.add("B");
    list.add("C");
    Iterator<String> iterator = list.iterator();
    while(iterator.hasNext()) {
        System.out.println(iterator.next());
    }```


    * Iterator interface defines following methods
    - boolean hasNext(): Returns true if the iteration has more elements
    - E next(): Returns the next element in the iteration
    - void remove(): Removes from the underlying collection the last element returned by this iterator

* ListIterator
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
    }
    ```



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


* Comparable interface

 - only one method compareTo() 

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


* Comparator interface

  - two methods compare() and equals()

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
                      | null value)         | null value)         | TreeSet is empty (From 1.7 it's not allowed)

Duplicate elements    | Not allowed         | Not allowed         | Not allowed

Heterogeneous         | Allowed             | Allowed             | Not allowed



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

Duplicate elements    | Not allowed for     | Not allowed for
                      | keys                | keys

Heterogeneous         | Allowed             | Allowed

methods               | Not synchronized    | Synchronized
                      | (not thread-safe)   | (thread-safe)

version               | Introduced in       | Introduced in
                      | JDK 1.2             | JDK 1.0

performance           | Faster              | Slower




* Various Memory Areas used by JVM

    1. Method Area ( class variables, static variables, method information, constructors information, constant pool)
    2. Heap Memory ( objects, instance variables)
    3. Stack Memory (method invocations, local variables)
    4. Program Counter Register (instruction address of currently executing JVM instruction)
    5. Native Method Stack (used for native methods written in other languages like C, C++)


    * Method Area
      - it is a shared memory area that is used to store class level data like class variables, static variables, 
          method information, constructors information, constant pool information, etc.
      - it is created by JVM at the time of class loading.
      - it is also known as Non-Heap memory area.
      - it is shared among all threads.

    * Heap Area
      - it is a shared memory area that is used to store object level data like instance variables, objects, etc.
      - it is created by JVM at the time of JVM startup.
      - it is also known as Runtime Data Area (RDA).
      - it is shared among all threads.
      - all the objects are created in heap area using new keyword.

    * Stack Area
      - it is a private memory area that is used to store method level data like local variables, method parameters, return addresses, etc.
      - for every thread JVM will create a separate stack area at the time of thread creation.
      - after the completion of thread or method execution, the corresponding stack area will be destroyed.
      - each entry in stack area is known as stack frame.
      - the data stored in the stack is available only to the corresponding thread.