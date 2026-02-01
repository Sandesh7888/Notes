# 1.6 Version Enhancements to Collections Framework

241. NavigableSet interface
    - it is a child interface of SortedSet
    - it provides methods to navigate the set in both ascending and descending order

    * methods of NavigableSet
        - lower(E e) : returns the greatest element less than e, or null if there is no such element
        - floor(E e) : returns the greatest element less than or equal to e, or null if there is no such element
        - ceiling(E e) : returns the least element greater than or equal to e, or null if there is no such element
        - higher(E e) : returns the least element greater than e, or null if there is no such element
        - pollFirst() : retrieves and removes the first (lowest) element, or returns null if this set is empty
        - pollLast() : retrieves and removes the last (highest) element, or returns null if this set is empty
        - descendingSet() : returns a reverse order view of the elements in this set
        - navigableIterator() : returns an iterator over the elements in this set in ascending order
        - descendingIterator() : returns an iterator over the elements in this set in descending order

    ex: 
    '''
    import java.util.NavigableSet;
    import java.util.TreeSet;
    public class Test {
          public static void main(String[] args) {
              NavigableSet<Integer> ns = new TreeSet<>();
              ns.add(10);
              ns.add(20);
              ns.add(30);
              ns.add(40);
              ns.add(50);
              System.out.println(ns); // [10, 20, 30, 40, 50]
              
              System.out.println(ns.lower(30)); // 20
              System.out.println(ns.floor(30)); // 30
              System.out.println(ns.ceiling(30)); // 30
              System.out.println(ns.higher(30)); // 40
              
              System.out.println(ns.pollFirst()); // 10
              System.out.println(ns); // [20, 30, 40, 50]
              
              System.out.println(ns.pollLast()); // 50
              System.out.println(ns); // [20, 30, 40]
              
              NavigableSet<Integer> descSet = ns.descendingSet();
              System.out.println(descSet); // [40, 30, 20]
              
              for (Integer num : ns) {
                  System.out.print(num + " "); // 20 30 40 
              }
              
              System.out.println();
              
              for (Integer num : descSet) {
                  System.out.print(num + " "); // 40 30 20 
              }
          }
      }
    '''

242. NavigableMap interface
    - it is a child interface of SortedMap
    - it provides methods to navigate the map in both ascending and descending order

    * methods of NavigableMap
        - lowerEntry(K key) : returns a key-value mapping associated with the greatest key less than the given key, or null if there is no such key
        - floorEntry(K key) : returns a key-value mapping associated with the greatest key less than or equal to the given key, or null if there is no such key
        - ceilingEntry(K key) : returns a key-value mapping associated with the least key greater than or equal to the given key, or null if there is no such key
        - higherEntry(K key) : returns a key-value mapping associated with the least key greater than the given key, or null if there is no such key
        - pollFirstEntry() : retrieves and removes the first (lowest) entry, or returns null if this map is empty
        - pollLastEntry() : retrieves and removes the last (highest) entry, or returns null if this map is empty
        - descendingMap() : returns a reverse order view of the mappings contained in this map
        - navigableKeySet() : returns a NavigableSet view of the keys contained in this map
        - descendingKeySet() : returns a reverse order NavigableSet view of the keys contained in this map

    ex:
    '''
    import java.util.NavigableMap;
    import java.util.TreeMap;
    import java.util.Map;
    public class Test {
          public static void main(String[] args) {
                NavigableMap<Integer, String> nm = new TreeMap<>();
                nm.put(10, "Ten");
                nm.put(20, "Twenty");
                nm.put(30, "Thirty");
                nm.put(40, "Forty");
                nm.put(50, "Fifty");
                System.out.println(nm); // {10=Ten, 20=Twenty, 30=Thirty, 40=Forty, 50=Fifty}

                System.out.println(nm.lowerEntry(30)); // 20=Twenty
                System.out.println(nm.floorEntry(30)); // 30=Thirty
                System.out.println(nm.ceilingEntry(30)); // 30=Thirty
                System.out.println(nm.higherEntry(30)); // 40=Forty
                System.out.println(nm.pollFirstEntry()); // 10=Ten
                System.out.println(nm); // {20=Twenty, 30=Thirty, 40=Forty, 50=Fifty}
                System.out.println(nm.pollLastEntry()); // 50=Fifty
                System.out.println(nm); // {20=Twenty, 30=Thirty, 40=Forty}

                NavigableMap<Integer, String> descMap = nm.descendingMap();
                System.out.println(descMap); // {40=Forty, 30=Thirty, 20=Twenty}

                for (Integer key : nm.navigableKeySet()) {
                    System.out.print(key + " "); // 20 30 40 
                }
                System.out.println();

                for (Integer key : nm.descendingKeySet()) {
                    System.out.print(key + " "); // 40 30 20 
                }
            }
        }
    '''


-------------------
# Utility Classes: 
-------------------

243. Collections

- Collections is a utility class that provides several static methods to perform operations on collections such as sorting, searching, reversing, etc.

    * some commonly used methods of Collections class
        - sort(List<T> list) : sorts the specified list into ascending order
        - sort(List<T> list, Comparator<? super T> c) : sorts the specified list according to the order induced by the specified comparator
        - binarySearch(List<? extends Comparable<? super T>> list, T key) : searches the specified list for the specified object using the binary search algorithm
        - binarySearch(List<? extends T> list, T key, Comparator<? super T> c) : searches the specified list for the specified object using the binary search algorithm and a comparator
        - reverse(List<?> list) : reverses the order of the elements in the specified list
        - shuffle(List<?> list) : randomly permutes the elements in the specified list
        - fill(List<? super T> list, T obj) : replaces all of the elements in the specified list with the specified element
        - copy(List<? super T> dest, List<? extends T> src) : copies all of the elements from one list into another
        ex:
        '''
        import java.util.*;
        public class Test {
          public static void main(String[] args) {
              List<Integer> list = new ArrayList<>();
              list.add(5);
              list.add(2);
              list.add(8);
              list.add(1);
              list.add(4);
              System.out.println("Original List: " + list); // [5, 2, 8, 1, 4]
              
              Collections.sort(list);
              System.out.println("Sorted List: " + list); // [1, 2, 4, 5, 8]
              
              int index = Collections.binarySearch(list, 4);
              System.out.println("Index of 4: " + index); // 2
              
              Collections.reverse(list);
              System.out.println("Reversed List: " + list); // [8, 5, 4, 2, 1]
              
              Collections.shuffle(list);
              System.out.println("Shuffled List: " + list); // e.g., [4, 1, 8, 2, 5]
              
              Collections.fill(list, 0);
              System.out.println("Filled List: " + list); // [0, 0, 0, 0, 0]

              List<Integer> dest = new ArrayList<>(Arrays.asList(new Integer[list.size()]));
              Collections.copy(dest, list);
              System.out.println("Copied List: " + dest); // [0, 0, 0, 0, 0]

              List<String> list = new ArrayList<>();
              list.add("Apple");
              list.add("Banana");
              list.add("Orange");
              list.add("Grapes");
              list.add("Pineapple");
              System.out.println("Original List: " + list); // [Apple, Banana, Orange, Grapes, Pineapple]   
              
              Collections.sort(list , new Comparator<String>() {
                  @Override
                  public int compare(String s1, String s2) {
                      return s1.length() - s2.length(); // sorting based on length of string
                  }
              });

              System.out.println("Sorted List by length: " + list); // [Apple, Banana, Grapes, Orange, Pineapple]
              int index = Collections.binarySearch(list, "Grapes", new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        return s1.length() - s2.length(); // searching based on length of string
                    }
              });
              System.out.println("Index of Grapes: " + index); // 2

            }
        }
        ''' 

    * Note: The Collections class is different from the Collection interface. 
            The Collection interface is the root interface in the collection hierarchy, while the Collections class is a utility 
            class that provides static methods for operating on collections.


244. Arrays
- Arrays is a utility class that provides various static methods to perform operations on arrays such as sorting, searching, comparing, etc.

    * some commonly used methods of Arrays class
        - sort(int[] a) : sorts the specified array into ascending numerical order
        - sort(T[] a, Comparator<? super T> c) : sorts the specified array according to the order induced by the specified comparator
        - binarySearch(int[] a, int key) : searches the specified array for the specified value using the binary search algorithm
        - binarySearch(T[] a, T key, Comparator<? super T> c) : searches the specified array for the specified value using the binary search algorithm and a comparator
        - equals(int[] a, int[] a2) : returns true if the two specified arrays are equal to one another
        - fill(int[] a, int val) : assigns the specified int value to each element of the specified array
        - copyOf(int[] original, int newLength) : copies the specified array, truncating or padding with zeros (if necessary) so the copy has the specified length
        ex:
        '''
        import java.util.*;
        public class Test {
          public static void main(String[] args) {
              int[] arr = {5, 2, 8, 1, 4};
              System.out.println("Original Array: " + Arrays.toString(arr)); // [5, 2, 8, 1, 4]
              
              Arrays.sort(arr);
              System.out.println("Sorted Array: " + Arrays.toString(arr)); // [1, 2, 4, 5, 8]
              
              int index = Arrays.binarySearch(arr, 4);
              System.out.println("Index of 4: " + index); // 2
              
              int[] arr2 = {1, 2, 4, 5, 8};
              boolean isEqual = Arrays.equals(arr, arr2);
              System.out.println("Arrays are equal: " + isEqual); // true
              
              Arrays.fill(arr, 0);
              System.out.println("Filled Array: " + Arrays.toString(arr)); // [0, 0, 0, 0, 0]
              
              int[] arr3 = Arrays.copyOf(arr2, 7);
              System.out.println("Copied Array: " + Arrays.toString(arr3)); // [1, 2, 4, 5, 8, 0, 0]

              String[] arr = {"Apple", "Banana", "Orange", "Grapes", "Pineapple"};

              System.out.println("Original Array: " + Arrays.toString(arr)); // [Apple, Banana, Orange, Grapes, Pineapple]

                Arrays.sort(arr, new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        return s1.length() - s2.length(); // sorting based on length of string
                    }
                });
                System.out.println("Sorted Array by length: " + Arrays.toString(arr)); // [Apple, Banana, Grapes, Orange, Pineapple]
                int index = Arrays.binarySearch(arr, "Grapes", new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        return s1.length() - s2.length(); // searching based on length of string
                    }
                });
                System.out.println("Index of Grapes: " + index); // 2
            }
        }
        '''

      *** conversion of array to list
        - asList(T... a) : returns a fixed-size list backed by the specified array
        ex:
        '''
        import java.util.*;
        public class Test {
          public static void main(String[] args) {
              String[] arr = {"Apple", "Banana", "Orange", "Grapes", "Pineapple"};
              List<String> list = Arrays.asList(arr);
              System.out.println("Array: " + Arrays.toString(arr)); // [Apple, Banana, Orange, Grapes, Pineapple]
              System.out.println("List: " + list); // [Apple, Banana, Orange, Grapes, Pineapple]
              
              // Modifying the list will also modify the array
              list.set(0, "Mango");
              System.out.println("Modified Array: " + Arrays.toString(arr)); // [Mango, Banana, Orange, Grapes, Pineapple]
              System.out.println("Modified List: " + list); // [Mango, Banana, Orange, Grapes, Pineapple]
              
              // However, you cannot add or remove elements from the list
              // list.add("Kiwi"); // This will throw UnsupportedOperationException
          }
        }
        '''  

         Note: by this method we are not creating new list we are just creating a view of array as list. 
                So any changes in list will reflect in array and vice versa.


--------------------------
# Concurrent Collections : 
--------------------------

245. Needs of concurrent collections
    - In a multi-threaded environment, multiple threads may access and modify a collection simultaneously, 
        leading to data inconsistency and unpredictable behavior.
    - already existing Thread-safe collections like Vector, Hashtable, and synchronized wrappers provided by Collections.synchronizedXXX() 
        methods like( Collections.synchronizedList(), Collections.synchronizedMap(), etc.)
        are not good in terms of performance because they lock the entire collection for every operation
    - To address these issues, Java provides concurrent collections that are designed to be thread-safe and 
        provide better performance in concurrent scenarios.

246. Treditional Collections vs Concurrent Collections
    * Traditional Collections
    - Not designed for concurrent access
    - May lead to data inconsistency and unpredictable behavior when accessed by multiple threads simultaneously
    - Use external synchronization (e.g., synchronized blocks) to make them thread-safe, which can lead to performance bottlenecks
    - Examples: ArrayList, HashMap, HashSet, etc.

    * Concurrent Collections
    - Designed for concurrent access
    - Provide built-in thread-safety and data consistency when accessed by multiple threads simultaneously
    - Use fine-grained locking or lock-free algorithms to achieve better performance in concurrent scenarios
    - Examples: ConcurrentHashMap, CopyOnWriteArrayList, ConcurrentSkipListMap, ConcurrentSkipListSet, etc.

247. Concurrent Collections in Java
    * ConcurrentHashMap
    - Thread-safe HashMap.
    - High concurrency for reads, partitioned locking for writes.
    - Iterators are weakly consistent.

    * CopyOnWriteArrayList
    - Thread-safe ArrayList.
    - Writes create a new copy of the array.
    - Efficient for read-heavy, write-light scenarios.
    - Iterators work on a snapshot.

    * ConcurrentSkipListMap
    - Concurrent, sorted, navigable map (like TreeMap).
    - Based on skip list (lock-free).
    - Maintains ascending key order.

    * ConcurrentSkipListSet
    - Thread-safe Set based on ConcurrentSkipListMap.
    - Sorted order like TreeSet.

    * BlockingQueue (Interface)
    - Thread-safe queue with blocking operations.
    - Producers block if full, consumers block if empty.
    - Implementations: ArrayBlockingQueue, LinkedBlockingQueue, PriorityBlockingQueue, DelayQueue, LinkedTransferQueue.

    * BlockingDeque (Interface)
    - Double-ended blocking queue.
    - Blocking operations at both ends.
    - Implementations: LinkedBlockingDeque, ArrayBlockingDeque (Java 7+).

    * ConcurrentLinkedQueue
    - Non-blocking, thread-safe queue.
    - Lock-free, CAS-based.
    - Good for highly concurrent producer-consumer.

    * ConcurrentLinkedDeque
    - Non-blocking, thread-safe double-ended queue.

    * SynchronousQueue
    - Queue with no capacity.
    - Each put waits for a take.
    - Used for direct handoff between threads.


248. ConcurrentHashMap
- It is a thread-safe variant of HashMap that allows concurrent access by multiple threads without any external synchronization.
- in concurrentHashMap, the map is divided into segments, and each segment(Bucket) can be locked independently, 
    allowing multiple threads to read and write to different segments simultaneously.
- It provides better performance in concurrent scenarios compared to synchronized HashMap or Hashtable.
- It does not allow null keys or null values.
- if operation is read then multiple threads can read the map simultaneously without any locking.
- if operation is write then only one thread can write to a segment at a time, while other threads can read from other segments.

    * Methods Provided by ConcurrentHashMap
      
      i) putIfAbsent(K key, V value)
        - It inserts the specified key-value pair into the map only if the key is not present in the map.
        - If the key is already present, it returns the existing value associated with the key.
        - If the key is not present, it inserts the new key-value pair and returns null.
        ex:
        '''
        import java.util.concurrent.ConcurrentHashMap;
        public class Test {
          public static void main(String[] args) {
              ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
              map.put(1, "One");
              map.put(2, "Two");
              System.out.println(map); // {1=One, 2=Two}
                String value = map.putIfAbsent(2, "Two Updated");
                System.out.println("Returned Value: " + value); // Returned Value: Two
                System.out.println(map); // {1=One, 2=Two}
                value = map.putIfAbsent(3, "Three");
                System.out.println("Returned Value: " + value); // Returned Value: null
                System.out.println(map); // {1=One, 2=Two, 3=Three}
            }
        }
        '''

        *****Note: in normal put() method if key is already present then it will update the value associated with the key 
                but in putIfAbsent() method if key is already present then it will not update the value associated with the key.

        ii) remove(Object key, Object value)
        - It removes the entry for the specified key only if it is currently mapped to the specified value.
        - If the key is present and mapped to the specified value, it removes the entry and returns true.
        - If the key is not present or not mapped to the specified value, it does nothing and returns false.
        ex:
        '''
        import java.util.concurrent.ConcurrentHashMap;
        public class Test {
          public static void main(String[] args) {
              ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
              map.put(1, "One");
              map.put(2, "Two");
              System.out.println(map); // {1=One, 2=Two}
                boolean isRemoved = map.remove(2, "Two Updated");
                System.out.println("Is Removed: " + isRemoved); // Is Removed: false
                System.out.println(map); // {1=One, 2=Two}
                isRemoved = map.remove(2, "Two");
                System.out.println("Is Removed: " + isRemoved); // Is Removed: true
                System.out.println(map); // {1=One}
            }
        }
        '''

        iii) replace(K key, V oldValue, V newValue)
        - It replaces the entry for the specified key only if it is currently mapped to the specified oldValue.
        - If the key is present and mapped to the specified oldValue, it replaces the value with newValue and returns true.
        - If the key is not present or not mapped to the specified oldValue, it does nothing and returns false.
        ex:
        '''
        import java.util.concurrent.ConcurrentHashMap;
        public class Test {
          public static void main(String[] args) {
              ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
              map.put(1, "One");
              map.put(2, "Two");
              System.out.println(map); // {1=One, 2=Two}
                boolean isReplaced = map.replace(2, "Two Updated", "Two New");
                System.out.println("Is Replaced: " + isReplaced); // Is Replaced: false
                System.out.println(map); // {1=One, 2=Two}
                isReplaced = map.replace(2, "Two", "Two New");
                System.out.println("Is Replaced: " + isReplaced); // Is Replaced: true
                System.out.println(map); // {1=One, 2=Two New}
            }
        }
        '''

249. Difference between HashMap, Hashtable and ConcurrentHashMap
    * HashMap
    - Not thread-safe.
    - Allows null keys and null values.
    - Uses a single lock for the entire map during write operations.
    - Better performance in single-threaded scenarios.
    - iterators are fail-fast so it throws ConcurrentModificationException if the map is modified while iterating.
    - version: since JDK 1.2

    * Hashtable
    - Thread-safe (synchronized).
    - Does not allow null keys or null values.
    - Uses a single lock for the entire map during write operations.
    - Generally slower due to synchronization overhead.
    - iterators are fail-fast so it throws ConcurrentModificationException if the map is modified while iterating.
    - version: since JDK 1.0

    * ConcurrentHashMap
    - Thread-safe (concurrent).
    - Does not allow null keys or null values.
    - Uses fine-grained locking (segment-level locking) for better concurrency during write operations.
    - Better performance in multi-threaded scenarios due to reduced contention.
    - Iterators are weakly consistent (not fail-fast) so it does not throw ConcurrentModificationException if the map is modified while iterating.
    - version: since JDK 1.5

250. CopyOnWriteArrayList
    - It is a thread-safe variant of ArrayList that creates a new copy of the underlying array
        whenever a modification operation (like add, set, or remove) is performed.
    - It is designed for scenarios where read operations are more frequent than write operations,
        making it suitable for read-heavy, write-light use cases.
    - Iterators of CopyOnWriteArrayList work on a snapshot of the array at the time the iterator was created,
        so they do not throw ConcurrentModificationException if the list is modified while iterating.

    * Constructors of CopyOnWriteArrayList
        - CopyOnWriteArrayList() : creates an empty list
        - CopyOnWriteArrayList(Collection<? extends E> c) : creates a list containing the elements of the specified collection
        - CopyOnWriteArrayList(E[] toCopyIn) : creates a list containing the elements of the specified array
    
    * Methods of CopyOnWriteArrayList
      
      i) boolean addAbsent(Object e)
      - the element is added to the list only if it is not present in the list.
      - If the element is already present, it does nothing and returns false.
      - If the element is not present, it adds the element to the list and returns true.

        ex:
        '''
        import java.util.concurrent.CopyOnWriteArrayList;
        public class Test {
            public static void main(String[] args) {
                CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
                list.add("Apple");
                list.add("Banana");
                System.out.println(list); // [Apple, Banana]
                
                boolean isAdded = list.addIfAbsent("Banana");
                System.out.println("Is Added: " + isAdded); // Is Added: false
                System.out.println(list); // [Apple, Banana]
                
                isAdded = list.addIfAbsent("Orange");
                System.out.println("Is Added: " + isAdded); // Is Added: true
                System.out.println(list); // [Apple, Banana, Orange]
            }
        }
        '''

        ii) void addAllAbsent(Collection<? extends E> c)
        - it adds all the elements from the specified collection to the list that are not already present in the list.
        - It returns the number of elements that were actually added to the list.
        ex:
        '''
        import java.util.concurrent.CopyOnWriteArrayList;
        import java.util.Arrays;
        import java.util.List;
        public class Test {
            public static void main(String[] args) {
                CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
                list.add("Apple");
                list.add("Banana");
                System.out.println(list); // [Apple, Banana]

                List<String> newFruits = Arrays.asList("Banana", "Orange", "Grapes");
                int addedCount = list.addAllAbsent(newFruits);
                System.out.println("Number of elements added: " + addedCount); // Number of elements added: 2
                System.out.println(list); // [Apple, Banana, Orange, Grapes]
            }
        }
        '''

251. Difference between ArrayList and CopyOnWriteArrayList

    * ArrayList
    - Not thread-safe.
    - Allows null elements.
    - Uses a single array for storage.
    - Modifications (add, set, remove) affect the original array.
    - Iterators are fail-fast, throwing ConcurrentModificationException if the list is modified while iterating.
    - Better performance in single-threaded scenarios.
    - version: since JDK 1.2

    * CopyOnWriteArrayList
    - Thread-safe.
    - Allows null elements.
    - Creates a new copy of the underlying array for each modification (add, set, remove).
    - Modifications do not affect the original array, allowing safe iteration.
    - Iterators are weakly consistent, not throwing ConcurrentModificationException if the list is modified while iterating.
    - Better performance in read-heavy, write-light scenarios.
    - version: since JDK 1.5

252. CopyOnWriteArraySet
    - It is a thread-safe variant of Set
    - It creates a new copy of the underlying array whenever a modification operation (like add or remove) is performed.
    - It is designed for scenarios where read operations are more frequent than write operations,
        making it suitable for read-heavy, write-light use cases.
    - Iterators of CopyOnWriteArraySet work on a snapshot of the array at the time the iterator was created,
        so they do not throw ConcurrentModificationException if the set is modified while iterating.

    * Constructors of CopyOnWriteArraySet
        - CopyOnWriteArraySet() : creates an empty set
        - CopyOnWriteArraySet(Collection<? extends E> c) : creates a set containing the elements of the specified collection

    * Methods of CopyOnWriteArraySet
        - boolean add(E e) : adds the specified element to the set if it is not already present
        - boolean remove(Object o) : removes the specified element from the set if it is present
        - boolean contains(Object o) : returns true if the set contains the specified element
        - int size() : returns the number of elements in the set
        - Iterator<E> iterator() : returns an iterator over the elements in the set

    ex:
    '''
    import java.util.concurrent.CopyOnWriteArraySet;
    public class Test {
        public static void main(String[] args) {
            CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
            set.add("Apple");
            set.add("Banana");
            System.out.println(set); // [Apple, Banana]
            boolean isAdded = set.add("Banana");
            System.out.println("Is Added: " + isAdded); // Is Added: false
            System.out.println(set); // [Apple, Banana]
            isAdded = set.add("Orange");
            System.out.println("Is Added: " + isAdded); // Is Added: true
            System.out.println(set); // [Apple, Banana, Orange]
        }
    }
    '''

------------
# Generics :
------------
- The main objective of generics is to provide type safety and to resolve the type casting issue.

253. Type Safety
    - Generics provide compile-time type safety by allowing you to specify the type of elements that a collection can hold.
    - This helps to catch type-related errors at compile time rather than at runtime, reducing the risk of ClassCastException.

    ex:
    '''
    import java.util.ArrayList;
    import java.util.List;
    public class Test {
        public static void main(String[] args) {
            // Without Generics
            List list = new ArrayList();
            list.add("Hello");
            list.add(123); // Adding an integer to a list of strings
            for (Object obj : list) {
                String str = (String) obj; // This will throw ClassCastException at runtime
                System.out.println(str);
            }

            // With Generics
            List<String> stringList = new ArrayList<>();
            stringList.add("Hello");
            // stringList.add(123); // Compile-time error: incompatible types
            for (String str : stringList) {
                System.out.println(str); // No need for casting, safe to use
            }
        }
    }
    '''

- enum is a special data type that enables a variable to be a set of predefined constants.
- It's meant to store a fixed set of constants.
  
  ex:
    '''
    enum Days
    {
        SUNDAY(1,"Sunday"),
        MONDAY(2,"Monday"),
        TUESDAY(3,"Tuesday"),
        WEDNESDAY(4,"Wednesday"),
        THURSDAY(5,"Thursday"),
        FRIDAY(6,"Friday"),
        SATURDAY(7,"Saturday");

        private final int id;
        private final String value;

        private Days(int id, String value)
        {
            this.id = id;
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public class Test {
        public static void main(String[] args) {
            Days d = Days.MONDAY;
            System.out.println(d);
        }
    }
    '''


-----------------------------
# Basic Architecture Of JVM :
-----------------------------
  - Java Virtual Machine (JVM)
  - Class Loader Subsystem
  - Types of Class Loaders
  - How Works Class Loader Subsystem
  - Need for custom class loader
  - Pseudo code for custom class loader
  - Various memory areas used by JVM
  - program to display heap memory statistics
  - How to set Maximum and Minimum heap size
  - Execution Engine
    i) Interpreter
    ii) Just-In-Time (JIT) Compiler
  - Java Native Interface (JNI)
  - Class File Structure

-------------------
# Virtual Machine :
-------------------

- It is a Software simulation of a mission which can perform operation like a physical machine.

  * there are two types of virtual machine

    i) Hard-ware Based / System Based Virtual Machine
      - it is designed to provide a complete system environment that can run multiple programs.
      - it allows multiple operating systems to run on a single physical machine.
      - ex: VMware, VirtualBox

    ii) Process Virtual Machine
      - it is designed to run a single program.
      - it allows the same program to run on different computers and operating systems without any changes.
      - ex: Java Virtual Machine (JVM), .NET Common Language Runtime (CLR)

     
- JVM is a part of JRE (Java Runtime Environment) and JRE is a part of JDK (Java Development Kit).
- JVM is a process virtual machine that allows a machine to run Java programs by executing Java bytecode.

    Note: Refer Basics_Structure_Of_JVM.jpeg file for JVM Architecture

256. Class Loader Subsystem
- it is a part of JVM that is responsible for loading class files into memory.
- it loads the class files from various sources like file system, network, etc.
  
  * there are three Activities of Class Loader Subsystem
    i) Loading
      - it is the process of loading the class file into memory.
      - it reads the class file and creates a Class object in memory.

    ii) Linking
      - it is the process of verifying, preparing and resolving the class file.
      - it ensures that the class file is valid and can be executed by JVM.

    iii) Initialization
      - it is the process of initializing the class variables and static blocks.
      - it executes the static blocks and initializes the static variables.

    
    I) Loading
        - Loading means Reading .class files and store corresponding binary data in method area.
        - for each class file JVM will Store corresponding Information in method area.
           ~ Fully qualified name of class or interface
           ~ fully qualified name of parent class
           ~ Methods Information
           ~ Variables Information
           ~ Constructors Information
           ~ Modifiers Information
           ~ Constant Pool Information

        - After loading .class file imidiately JVM will create corresponding Class object in heap memory 
            of type java.lang.Class
          Note : after creating a Class object it will not be class object , it will be Class class's object.

          ex: 
            '''
            public class Test {
                public static void main(String[] args) {
                    Student s = new Student();
                    Class c1 = s.getClass();

                    Teacher t = new Teacher();
                    Class c2 = t.getClass();

                    System.out.println(c1.hashCode()); // 366712642
                    System.out.println(c2.hashCode()); // 366712642

                    System.out.println(c1 == c2); // true
                }
            }
            '''


    II) Linking
        - linking means taking the binary data stored in method area and making it ready for execution.
        - it is divided into three steps
          i) Verification
              - it is the process of verifying the .class file to ensure that it is correct or not for execution for JVM.
              - intrnally Bytecode Verifier will verify the .class file.
          ii) Preparation
              - it is the process of allocating memory for class variables and initializing them with default values.
              - it allocates memory for static variables in method area and initializes them with default values.
          iii) Resolution
              - it is the process of replacing symbolic references with direct references.
              - it replaces the symbolic references in constant pool with direct references.
 
        
    
    III) Initialization
        - in this step all static variables are assigned with original values & Static blocks are executed
           from parent to child and top to bottom.
        
        **Note: While loading , linking & initialization if any error occures then we will get 
                  RE : java.lang.LinkageError
    

257. Types of Class Loaders
    - class loader sub system contains three types of class loaders
      i) Bootstrap Class Loader
      - Bootstrap class loader is responsible to load Core java API classes located in rt.jar file.
          rt.jar file is located in <JAVA_HOME>/jre/lib/rt.jar
      - It is by default present in JVM and it's developed in a native language. 

      ii) Extension Class Loader
      - It is a child class loader of the Bootstrap class loader.
      - Extension class loader is responsible for loading classes from extension directories which are located in *.jar files.
          By default, the extension directory is <JAVA_HOME>/jre/lib/ext/*.jar
      - It is developed in the Java language.
        
      iii) System/Application Class Loader
      - It is a child class loader of the Extension class loader.
      - System/Application class loader is responsible for loading classes from the classpath which is located in *.jar files.
          By default, the classpath is the current working directory(.).
      - It is developed in the Java language.

      ***Note: Refer Basics_Working_Class_Loader_Subsystem.jpeg file for Class Loader working


      * Explanation of Class loader working 
      - class loader follows delegation hierarchy.
        - when we run any java program, first system/application class loader will check whether the requested
            class is present in classpath or not.
        - if the requested class is not present in classpath then it will delegate the request to extension class loader.
        - if the requested class is not present in extension directory then it will delegate the request to bootstrap class loader.
        - if the requested class is not present in rt.jar file then it will throw ClassNotFoundException or NoClassDefFoundError.
        - if the requested class is present in rt.jar file then bootstrap class loader will load the class file and create
            corresponding Class object in heap memory.
        - if the requested class is present in extension directory then extension class loader will load the class file and create
            corresponding Class object in heap memory.
        - if the requested class is present in classpath then system/application class loader will load the class file and create
            corresponding Class object in heap memory.
        - after creating Class object in heap memory, it will be used by JVM to execute the program.
        

258. Various Memory Areas used by JVM
    - JVM uses various memory areas to store different types of data.
    - these memory areas are created when JVM starts and destroyed when JVM shuts down.
    
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
      - each entry in stack area is known as a stack frame.
      - the data stored in the stack is available only to the corresponding thread.
        
        ~ Local Variable Array
          - it is a part of stack area that is used to store local variables and method parameters.
          - it is created when a method is invoked and destroyed when the method completes.
          - it stores primitive data types and references to objects in the heap area.

    * Program Counter (PC) Register
      - it is a private memory area that is used to store the address of the currently executing instruction.
      - for every thread, a separate PC register is created at the time of thread creation.
      - after the completion of thread execution, the corresponding PC register will be destroyed.

    * Native Method Stack
      - it is a private memory area that is used to store the state of native methods (methods written in languages other than Java).
      - it is created by JVM at the time of thread creation.
      - each thread has its own native method stack.

259. Execution Engine
- this is the Central component of JVM that is responsible to execute the bytecode.
- Execution engine consists of two components
  i) Interpreter
    - it is responsible for reading Bytecode and interpreting it into machine code and executing it line by line.
    - it is slow because it interprets the bytecode line by line.
        ~ to overcome this issue, the JIT compiler was introduced.

  ii) Just-In-Time (JIT) Compiler
    - it is responsible for reading Bytecode and interpreting it into machine code and executing it line by line, which 
        improves the performance of a Java program.
    - internally, the JIT compiler maintains a count for each method.
    - when a particular method is called multiple times (default threshold is 10 times) then the JIT compiler will compile
        the bytecode of that method into machine code and store it in memory.
    - when the same method is called again, it will directly execute the machine code from memory instead of interpreting the bytecode again.

260. Java Native Interface (JNI)
- it is a framework that allows Java code to call and be called by native applications and libraries
    written in other languages like C, C++, etc.
- it is used to access platform-specific features and libraries that are not available in Java.
- it is also used to improve the performance of java program by using native code for performance-critical sections.
- it is also used to access legacy code that is written in other languages.


*****Note : Refer Basics_Architecture_Of_JVM.jpeg file for overall architecture of JVM


261. JDK VS JRE VS JVM
    * JDK (Java Development Kit)
    - it is a software development kit that is used to develop java applications.
    - it contains JRE, development tools (like javac, java, javadoc, etc.), and other libraries.
    - it is required for java developers to develop java applications.
    - version: since JDK 1.0

    * JRE (Java Runtime Environment)
    - it is a software package that is used to run java applications.
    - it contains JVM, core libraries, and other components required to run java applications.
    - it is required for end-users to run java applications.
    - version: since JDK 1.0

    * JVM (Java Virtual Machine)
    - it is a part of JRE that is responsible for executing java bytecode.
    - it provides a runtime environment for java applications to run.
    - it is platform-dependent and varies from one operating system to another.
    - version: since JDK 1.0