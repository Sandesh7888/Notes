
-----------
Hibernate : 
-----------

- Hibernate is a  Java framework that simplifies the development of Java applications to interact with a database.
- Hibernate is a ORM (Object Relational Mapping) tool that maps Java classes to database tables.
- Hibernate is an open-source and lightweight framework that is developed and maintained by Red Hat.
- Hibernate is a loosely coupled framework, which means it won't force the programmer to extend or implement any class or interface.
- It deals with Java objects and database tables.

01. How to configure Hibernate in a Java application?
  - add Dependencies
    - hibernate-core (ORM engine)
    - hibernate-entitymanager (JPA support if we use JPA annotations)
    - hibernate-validator (bean validations like @NotNull, @Size)
    - hibernate-c3p0 (connection pool with Hibernate)
    - mysql-connector-java (or any other database connector)
  - There are two ways to configure Hibernate in a Java application.
    i) XML Configuration
    ii) Annotation Configuration

    i) XML Configuration:
      - In XML configuration, we need to create a configuration file named hibernate.cfg.xml in the classpath(src/main/resources).
      - This file contains the database connection details and Hibernate properties.
      - We also need to create a mapping entry for each entity class in the mapping section of the configuration file (hibernate.cfg.xml).
      
        ex: hibernate.cfg.xml
        ```
        <?xml version="1.0" encoding="utf-8"?>
        <!DOCTYPE hibernate-configuration PUBLIC
                "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
                "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
        <hibernate-configuration>
            <session-factory>
                <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
                <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
                <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/your_database</property>
                <property name="hibernate.connection.username">your_username</property>
                <property name="hibernate.connection.password">your_password</property>
                <property name="hibernate.hbm2ddl.auto">update</property>
                <property name="hibernate.show_sql">true</property>
                <mapping class="com.example.Student"/>
            </session-factory>
        </hibernate-configuration>
        ```
        ex: Student.java
        ```
        @Entity
        @Table(name = "students")
        public class Student {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name = "id")
            private Long id;
            @Column(name = "name")
            private String name;
            @Column(name = "email")
            private String emailId;
            // getters and setters
            public String toString() {
                return "Student [id=" + id + ", name=" + name + ", emailId=" + emailId + "]";
            }
        }
        ```
        ex: MainConfigurationApp.java
        ```
        public class MainConfigurationApp {
            public static void main(String[] args) {
                // Create SessionFactory
                SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
                // Create Session
                Session session = sessionFactory.openSession();

                // Create a new Student object
                Student student = new Student();
                student.setName("Vivek Mate");
                student.setEmailId("vivekmate0002@gmail.com");

                // Begin Transaction
                Transaction transaction = session.beginTransaction();
                // Save the Student object
                session.save(student);
                // Commit the transaction
                transaction.commit();

                // get the saved student object by get()
                Student getSavedStudent = session.get(Student.class, student.getId());
                System.out.println("Saved Student: " + getSavedStudent);

                // get the saved student object by load()
                Student loadSavedStudent =session.load(Student.class, student.getId());
                System.out.println("Loaded Student: " + loadSavedStudent);

                // get the saved student object by HQL
                List<Student> students = session.createQuery("from Student", Student.class).list();
                for (Student s : students) {
                    System.out.println("HQL Student: " + s);
                }

                // Close the session
                session.close();
                sessionFactory.close();
            }
        }
        ```
    
    ii) Annotation Configuration:
        - In Annotation configuration, we use JPA annotations to map the entity classes to database tables.
        - We need to create a configuration file named persistence.xml in the classpath (src/main/resources/META-INF).
        - This file contains the database connection details and Hibernate properties.
        
            ex: persistence.xml
            ```
            <?xml version="1.0" encoding="UTF-8"?>
            <persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence" version="2.1">
                <persistence-unit name="my-persistence-unit">
                    <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
                    <class>com.example.Student</class>
                    <properties>
                        <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
                        <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/your_database"/>
                        <property name="javax.persistence.jdbc.user" value="your_username"/>
                        <property name="javax.persistence.jdbc.password" value="your_password"/>
                        <property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect"/>
                        <property name="hibernate.hbm2ddl.auto" value="update"/>
                        <property name="hibernate.show_sql" value="true"/>
                    </properties>
                </persistence-unit>
            </persistence>
            ```
            ex: MainAnnotationApp.java
            ```
            public class MainAnnotationApp {
                public static void main(String[] args) {
                    // Create EntityManagerFactory
                    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
                    // Create EntityManager
                    EntityManager entityManager = entityManagerFactory.createEntityManager();
    
                    // Create a new Student object
                    Student student = new Student();
                    student.setName("Vivek Mate");
                    student.setEmailId("vivekmate0002@gmail.com");

                    // Begin Transaction
                    EntityTransaction transaction = entityManager.getTransaction();
                    transaction.begin();
                    // Save the Student object
                    entityManager.save(student);
                    // Commit the transaction
                    transaction.commit();

                    // Close the EntityManager
                    entityManager.close();
                    entityManagerFactory.close();
                }
            }
            ```

    

02. Commonly used Hibernate Annotations:
  - @Entity: This annotation is used to mark a class as an entity that will be mapped to a database table.
  - @Table: This annotation is used to specify the name of the database table that the entity will be mapped to.
  - @Id: This annotation is used to mark a field as the primary key of the entity.
  - @GeneratedValue: This annotation is used to specify how the primary key value will be generated (e.g., auto-increment).
  - @Column: This annotation is used to specify the name of the database column that a field will be mapped to.
  - @OneToOne: This annotation is used to define a one-to-one relationship between two entities.
  - @OneToMany: This annotation is used to define a one-to-many relationship between two entities.
  - @ManyToOne: This annotation is used to define a many-to-one relationship between two entities.
  - @ManyToMany: This annotation is used to define a many-to-many relationship between two entities.
  - @JoinColumn: This annotation is used to specify the foreign key column in a relationship mapping.
  - @JoinTable: This annotation is used to specify the join table for many-to-many relationships.
  - @Transient: This annotation is used to mark a field that should not be persisted in the database.
  - @Temporal: This annotation is used to specify the temporal type (DATE, TIME, TIMESTAMP) of a date field.
  - @Lob: This annotation is used to mark a field as a large object (e.g., BLOB or CLOB).

    ex: Student.java
    ```
    @Entity
    @Table(name = "students")
    public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "name")
        private String name;

        @Column(name = "email")
        private String emailId;

        @Transient
        private int age; // This field will not be persisted in the database

        @Temporal(TemporalType.DATE)
        @Column(name = "dob")
        private Date dateOfBirth;

        @Lob
        @Column(name = "profile_picture")
        private byte[] profilePicture;

        // getters and setters
        public String toString() {
            return "Student [id=" + id + ", name=" + name + ", emailId=" + emailId + "]";
        }
    }
    ```

03. get() vs load() in Hibernate:
  - get():
    - The get() method is used to retrieve an entity by its primary key.
    - It returns null if the entity is not found in the database.
    - It immediately hits the database to fetch the entity.
    - It returns a fully initialized entity object.
    - It is a non-lazy operation.
    - we can use get() method when we are not sure if the entity exists in the database or not.

  - load():
    - The load() method is also used to retrieve an entity by its primary key.
    - It throws an ObjectNotFoundException if the entity is not found in the database.
    - It may return a proxy object instead of hitting the database immediately.
    - The actual database query is executed only when a property of the entity is accessed (lazy loading).
    - It is a lazy operation.
    - we can use load() method when we are sure that the entity exists in the database.

  ex: MainConfigurationApp.java
  ```
  // get the saved student object by get()
  Student getSavedStudent = session.get(Student.class, student.getId());
  System.out.println("Saved Student: " + getSavedStudent);

  // get the saved student object by load()
  Student loadSavedStudent =session.load(Student.class, student.getId());
  System.out.println("Loaded Student: " + loadSavedStudent);
  ```

04. Hibernate Embeddable and Embedded Objects:
  
    @Embeddable: This annotation is used to mark a class as being an embeddable object. 
       This means that the properties of the class can be used as part of another class/entity,
       rather than storing it in a separate table.
 
      ***Note: An embeddable class is typically used as a component of a composite primary key or as a value type in an entity.

    @Embedded: This annotation is used to mark a field in an entity class as being an embedded object.
       This means that the properties of the embeddable class will be mapped to columns in the same table as the entity.

      ex: Address.java
        ```
        @Embeddable
        public class Address {
            @Column(name = "street")
            private String street;

            @Column(name = "city")
            private String city;  

            @Column(name = "state")
            private String state;  

            // getters and setters
            public String toString() {
                return "Address [street=" + street + ", city=" + city + ", state=" + state + "]";
            }
        }
        ```
        ex: Student.java
        ```
        @Entity
        @Table(name = "students")
        public class Student {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name = "id")
            private Long id;

            @Column(name = "name")
            private String name;
            
            @Column(name = "email")
            private String emailId;

            @Embedded
            private Address address;  // Embeddable object

            // getters and setters
            public String toString() {
                return "Student [id=" + id + ", name=" + name + ", emailId=" + emailId + ", address=" + address + "]";
            }
        }
        ```
        ex: MainConfigurationApp.java
        ```
        public class MainConfigurationApp {
            public static void main(String[] args) {
                // Create SessionFactory
                SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
                // Create Session
                Session session = sessionFactory.openSession();

                // Create a new Student object
                Student student = new Student();
                student.setName("Vivek Mate");
                student.setEmailId("vivekmate0002@gmail.com");

                Address address = new Address();
                address.setStreet("Nagar-Sambhajinagar highway");
                address.setCity("Nagar");
                address.setState("Maharashtra");
                student.setAddress(address); // Set the embeddable object

                // Begin Transaction
                Transaction transaction = session.beginTransaction();
                // Save the Student object
                session.save(student);
                // Commit the transaction
                transaction.commit();

                // get the saved student object by get()
                Student getSavedStudent = session.get(Student.class, student.getId());
                System.out.println("Saved Student: " + getSavedStudent);


                // Close the session
                session.close();
                sessionFactory.close();
            }
        }
        ```

05. @OneToOne
  - The @OneToOne annotation is used to define a one-to-one relationship between two entities in Hibernate.

  ex:
    ex: Address.java
    ```
    @Entity
    @Table(name = "addresses")
    public class Address {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "street")
        private String street;

        @Column(name = "city")
        private String city;  

        @Column(name = "state")
        private String state;  

        // getters and setters
        public String toString() {
            return "Address [id=" + id + ", street=" + street + ", city=" + city + ", state=" + state + "]";
        }
    }
    ```
    ex: Student.java
    ```
    @Entity
    @Table(name = "students")
    public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "name")
        private String name;
        
        @Column(name = "email")
        private String emailId;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "address_id", referencedColumnName = "id")
        private Address address;  // One-to-One relationship

        // getters and setters
        public String toString() {
            return "Student [id=" + id + ", name=" + name + ", emailId=" + emailId + ", address=" + address + "]";
        }
    }
    ```
    ex: MainConfigurationApp.java
    ```
    public class MainConfigurationApp {
        public static void main(String[] args) {
            // Create SessionFactory
            SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            // Create Session
            Session session = sessionFactory.openSession();

            // Create a new Student object
            Student student = new Student();
            student.setName("Vivek Mate");
            student.setEmailId("vivekmate0002@gmail.com");
            Address address = new Address();

            address.setStreet("nagar-sambhajinagar highway");
            address.setCity("nagar");
            address.setState("Maharashtra");

            student.setAddress(address); // Set the one-to-one relationship

            // Begin Transaction
            Transaction transaction = session.beginTransaction();
            // Save the Student object
            session.save(student);
            // Commit the transaction
            transaction.commit();

            // get the saved student object by get()
            Student getSavedStudent = session.get(Student.class, student.getId());
            System.out.println("Saved Student: " + getSavedStudent);

            // Close the session
            session.close();
            sessionFactory.close();
        }
    }
    ```

06. @OneToMany and @ManyToOne
  - The @OneToMany and @ManyToOne annotations are used to define a one-to-many relationship between two entities in Hibernate.

  ex:
    ex: Course.java
    ```
    @Entity
    @Table(name = "courses")
    public class Course {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "title")
        private String title;

        @ManyToOne
        @JoinColumn(name = "student_id", referencedColumnName = "id")
        private Student student; // Many-to-One relationship

        // getters and setters
        public String toString() {
            return "Course [id=" + id + ", title=" + title + "]";
        }
    }
    ```
    ex: Student.java
    ```
    @Entity
    @Table(name = "students")
    public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "name")
        private String name;
        
        @Column(name = "email")
        private String emailId;

        @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
        private List<Course> courses; // One-to-Many relationship

        // getters and setters
        public String toString() {
            return "Student [id=" + id + ", name=" + name + ", emailId=" + emailId + ", courses=" + courses + "]";
        }
    }
    ```
    ex: MainConfigurationApp.java
    ```
    public class MainConfigurationApp {
        public static void main(String[] args) {
            // Create SessionFactory
            SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            // Create Session
            Session session = sessionFactory.openSession();

            // Create a new Student object
            Student student = new Student();
            student.setName("Vivek Mate");
            student.setEmailId("vivekmate0002@gmail.com");

            Course course1 = new Course();
            course1.setTitle("Java Basics");
            course1.setStudent(student); // Set the Many-to-One relationship

            Course course2 = new Course();
            course2.setTitle("Hibernate Basics");
            course2.setStudent(student); // Set the Many-to-One relationship

            List<Course> courses = new ArrayList<>();
            courses.add(course1);
            courses.add(course2);
            student.setCourses(courses); // Set the One-to-Many relationship

            // Begin Transaction
            Transaction transaction = session.beginTransaction();
            // Save the Student object
            session.save(student);
            // Commit the transaction
            transaction.commit();

            // get the saved student object by get()
            Student getSavedStudent = session.get(Student.class, student.getId());
            System.out.println("Saved Student: " + getSavedStudent);

            // Close the session
            session.close();
            sessionFactory.close();
        }
    }
    ```

07. @ManyToMany
  - The @ManyToMany annotations are used to define a many-to-many relationship between two entities in Hibernate.

  ex:
    ex: Course.java
    ```
    @Entity
    @Table(name = "courses")
    public class Course {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "title")
        private String title;

        @ManyToMany(mappedBy = "courses")
        private List<Student> students; // Many-to-Many relationship

        // getters and setters
        public String toString() {
            return "Course [id=" + id + ", title=" + title + "]";
        }
    }
    ```
    ex: Student.java
    ```
    @Entity
    @Table(name = "students")
    public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "name")
        private String name;
        
        @Column(name = "email")
        private String emailId;

        @ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(
            name = "student_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
        )
        private List<Course> courses; // Many-to-Many relationship

        // getters and setters
        public String toString() {
            return "Student [id=" + id + ", name=" + name + ", emailId=" + emailId + ", courses=" + courses + "]";
        }
    }
    ```
    ex: MainConfigurationApp.java
    ```
    public class MainConfigurationApp {
        public static void main(String[] args) {
            // Create SessionFactory
            SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            // Create Session
            Session session = sessionFactory.openSession();

            // Create a new Student object
            Student student1 = new Student();
            student1.setName("Vivek Mate");
            student1.setEmailId("vivekmate0002@gmail.com");

            Student student2 = new Student();
            student2.setName("Tushar Tawale");
            student2.setEmailId("tushartawale01@gmail.com");

            Course course1 = new Course();
            course1.setTitle("Java Basics");

            Course course2 = new Course();
            course2.setTitle("Hibernate Basics");

            List<Course> coursesForStudent1 = new ArrayList<>();
            coursesForStudent1.add(course1);
            coursesForStudent1.add(course2);

            List<Course> coursesForStudent2 = new ArrayList<>();
            coursesForStudent2.add(course1);
            coursesForStudent2.add(course2);

            student1.setCourses(coursesForStudent1); // Set the Many-to-Many relationship
            student2.setCourses(coursesForStudent2); // Set the Many-to-Many relationship

            List<Student> studentsForCourse1 = new ArrayList<>();
            studentsForCourse1.add(student1);
            studentsForCourse1.add(student2);

            List<Student> studentsForCourse2 = new ArrayList<>();
            studentsForCourse2.add(student1);
            studentsForCourse2.add(student2);

            course1.setStudents(studentsForCourse1); // Set the Many-to-Many relationship
            course2.setStudents(studentsForCourse2); // Set the Many-to-Many relationship

            // Begin Transaction
            Transaction transaction = session.beginTransaction();

            // Save the Student objects
            session.save(student1);
            session.save(student2);
            // no need to store course objects because of CascadeType.ALL


            // Commit the transaction
            transaction.commit();

            // get the saved student object by get()
            Student getSavedStudent = session.get(Student.class, student1.getId());
            System.out.println("Saved Student: " + getSavedStudent);
            Student getSavedStudent2 = session.get(Student.class, student2.getId());
            System.out.println("Saved Student: " + getSavedStudent2);

            // Close the session
            session.close();
            sessionFactory.close();

        }
    }
    ```

08. Fetch Types in Hibernate:
  - Fetch types in Hibernate define how associated entities are loaded from the database.
  - There are two main fetch types in Hibernate:
    i) EAGER Fetching
    ii) LAZY Fetching

    i) EAGER Fetching:
      - In EAGER fetching, related entities are loaded immediately along with the parent entity.
      - This means that when you load a parent entity, all its related entities are also loaded from the database.
      - EAGER fetching can lead to performance issues if there are many related entities, as it may result in multiple database queries.

      ex: 
        @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        private List<Course> courses; // One-to-Many relationship with EAGER fetching

    ii) LAZY Fetching:
      - In LAZY fetching, related entities are loaded only when they are accessed for the first time.
      - This means that when you load a parent entity, its related entities are not loaded until you explicitly access them.
      - LAZY fetching can improve performance by reducing the number of database queries, especially when there are many related entities.

      ex:
        @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<Course> courses; // One-to-Many relationship with LAZY fetching

  ***Note: By default, @OneToMany and @ManyToMany relationships use LAZY fetching, while @OneToOne and @ManyToOne relationships use EAGER fetching.

09. Hibernate / Persistence Life Cycle:
  - The Hibernate Life Cycle defines the different states that an entity can be in during its lifetime in a Hibernate application.
  - There are four main states in the Hibernate Life Cycle:
    i) Transient State
    ii) Persistent State
    iii) Detached State
    iv) Removed State

    i) Transient State:
      - An entity is in the transient state when it is created using the new operator but is not yet associated with a Hibernate session.
      - In this state, the entity does not have a corresponding record in the database.
      - Example: 
        Student student = new Student(); // Transient state

    ii) Persistent State:
      - An entity is in the persistent state when it is associated with a Hibernate session and has a corresponding record in the database.
      - In this state, any changes made to the entity are automatically synchronized with the database when the session is flushed or committed.
      - Example:
        session.save(student); // Persistent state

    iii) Detached State:
      - An entity is in the detached state when it was previously in the persistent state but is no longer associated with a Hibernate session.
      - In this state, changes made to the entity are not automatically synchronized with the database.
      - Example:
        session.close(); // Detached state

    iv) Removed State:
      - An entity is in the removed state when it has been marked for deletion from the database but has not yet been deleted.
      - In this state, the entity will be deleted from the database when the session is flushed or committed.
      - Example:
        session.delete(student); // Removed state

  ***Note: The transition between these states is managed by Hibernate and can be controlled using various methods provided by the Hibernate API.


10. HQL (Hibernate Query Language):
  - HQL is an object-oriented query language that is used to query the database in Hibernate.
  - HQL is similar to SQL but it operates on the entity objects and their properties rather than on database tables and columns.
  - HQL supports various features such as joins, subqueries, aggregation functions, and more.

  ex:
    // HQL query to fetch all students
    List<Student> students = session.createQuery("from Student", Student.class).list();
    for (Student s : students) {
        System.out.println("HQL Student: " + s);
    }

    // HQL query with a where clause
    List<Student> studentsNamedVivek = session.createQuery("from Student where name = :name", Student.class)
                                               .setParameter("name", "Vivek Mate")
                                               .list();

    for (Student s : studentsNamedVivek) {
        System.out.println("HQL Student Named Vivek: " + s);
    }

    // HQL query with join
    List<Object[]> results = session.createQuery("select s.name, c.title from Student s join s.courses c").list();
    for (Object[] row : results) {
        String studentName = (String) row[0];
        String courseTitle = (String) row[1];
        System.out.println("Student: " + studentName + ", Course: " + courseTitle);
    }

    // Delete a record using HQL
    Transaction transaction = session.beginTransaction();
    int deletedCount = session.createQuery("delete from Student where name = :name")
                              .setParameter("name", "Tushar Tawale")
                              .executeUpdate();
    System.out.println("Number of records deleted: " + deletedCount);
    transaction.commit();

    // Update a record using HQL
    Transaction transaction = session.beginTransaction();
    int updatedCount = session.createQuery("update Student set emailId = :email where name = :name")
                              .setParameter("email", "vivekmate0002@gmail.com")
                              .setParameter("name", "Vivek Mate")
                              .executeUpdate();
    System.out.println("Number of records updated: " + updatedCount);
    transaction.commit();


    // Execute Join query using HQL
    List<Object[]> results = session.createQuery("select s.name, c.title from Student s INNER JOIN s.courses c").list();
    for (Object[] row : results) {
        String studentName = (String) row[0];
        String courseTitle = (String) row[1];
        System.out.println("Student: " + studentName + ", Course: " + courseTitle);
    }


11. Pagination
- Pagination is a technique used to divide a large set of data into smaller, more manageable chunks or pages.
- In Hibernate, pagination can be achieved using the setFirstResult() and setMaxResults() methods of the Query interface.
- The setFirstResult() method is used to specify the index of the first result to be retrieved, 
    while the setMaxResults() method is used to specify the maximum number of results to be retrieved.

    ex:
    ```
    class MainPaginationApp {
        public static void main(String[] args) {
            // Create SessionFactory
            SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            // Create Session
            Session session = sessionFactory.openSession();

            // HQL query to fetch all students with pagination
            int pageNumber = 1; // Page number (starting from 1)
            int pageSize = 2;   // Number of records per page

            List<Student> students = session.createQuery("from Student", Student.class)
                                            .setFirstResult((pageNumber - 1) * pageSize) // Calculate the starting index
                                            .setMaxResults(pageSize) // Set the maximum number of results
                                            .list();

            for (Student s : students) {
                System.out.println("Paginated Student: " + s);
            }

            // Close the session
            session.close();
            sessionFactory.close();
        }
    }
    ```

12. Native SQL Query in Hibernate:
  - Native SQL queries are written in the native SQL dialect of the underlying database.
  - In Hibernate, native SQL queries can be executed using the `createNativeQuery()` method of the Session interface.
  - Native SQL queries can be used to perform complex queries that may not be easily expressed using HQL.

    ex:
    ```
    class MainNativeSQLApp {
        public static void main(String[] args) {
            // Create SessionFactory
            SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            // Create Session
            Session session = sessionFactory.openSession();

            // Native SQL query to fetch all students
            List<Student> students = session.createNativeQuery("SELECT * FROM students", Student.class).list();
            for (Student s : students) {
                System.out.println("Native SQL Student: " + s);
            }

            // Native SQL query with a where clause
            List<Student> studentsNamedVivek = session.createNativeQuery("SELECT * FROM students WHERE name = :name", Student.class)
                                                      .setParameter("name", "Vivek Mate")
                                                      .list();

            for (Student s : studentsNamedVivek) {
                System.out.println("Native SQL Student Named Vivek: " + s);
            }

            // Close the session
            session.close();
            sessionFactory.close();
        }
    }
    ```

13. Hibernate Cascading: 
      i.e., when we are saving, updating, or deleting a parent entity, the same operation can be automatically applied to its child entities 
            based on the cascade type specified.
        ***Note: It also increases the performance of the application but can be risky if not used properly.

    - There are several cascade types in Hibernate:
        i) CascadeType.PERSIST: When the parent entity is persisted (saved), the associated child entities are also persisted.
        ii) CascadeType.MERGE: When the parent entity is merged (updated), the associated child entities are also merged.
        iii) CascadeType.REMOVE: When the parent entity is removed (deleted), the associated child entities are also removed.
        iv) CascadeType.REFRESH: When the parent entity is refreshed, the associated child entities are also refreshed
        v) CascadeType.DETACH: When the parent entity is detached from the session, the associated child entities are also detached.
            ie. the entity is no longer associated with the session.
        vi) CascadeType.ALL: This is a shorthand for specifying all of the above cascade types

14. Caching in Hibernate:
    - Caching is a technique used to improve the performance of database operations by storing frequently accessed data in memory.
    - Hibernate provides several caching mechanisms to optimize data retrieval and reduce database access.
    - There are two main types of caching in Hibernate:
        i) First-Level Cache (Session Cache)
        ii) Second-Level Cache
    
        i) First-Level Cache (Session Cache):
        - The first-level cache is associated with the Hibernate session and is enabled by default.
        - It stores entities that are loaded or saved within the same session.
        - When an entity is requested, Hibernate first checks the first-level cache before querying the database.
        - The first-level cache is cleared when the session is closed or cleared.
    
        ii) Second-Level Cache:
        - The second-level cache is a shared cache that can be used across multiple sessions.
        - It is not enabled by default and requires additional configuration.
        - The second-level cache can store entities, collections, and query results.
        - Popular second-level cache providers include Ehcache, Infinispan, and Hazelcast.
    
    ex: Enabling Second-Level Cache with Ehcache
        1. Add Ehcache dependency to your project (e.g., in Maven pom.xml):
            ```
            <dependency>
                <groupId>org.ehcache</groupId>
                <artifactId>ehcache</artifactId>
                <version>3.9.7</version>
            </dependency>
            <dependency>
                <groupId>org.hibernate</groupId>
                <artifactId>hibernate-ehcache</artifactId>
                <version>5.4.32.Final</version>
            </dependency>
            ```

            ex: build.gradle
            ```
            implementation 'org.ehcache:ehcache:3.9.7'
            implementation 'org.hibernate:hibernate-ehcache:5.4.32.Final'
            ```
    
        2. Configure Hibernate to use the second-level cache in hibernate.cfg.xml :
            ex: hibernate.cfg.xml
            ```
            <?xml version="1.0" encoding="utf-8"?>
            <!DOCTYPE hibernate-configuration PUBLIC
                    "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
                    "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
            <hibernate-configuration>
                <session-factory>
                    <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
                    <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
                    <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/your_database</property>
                    <property name="hibernate.connection.username">your_username</property>
                    <property name="hibernate.connection.password">your_password</property>
                    <property name="hibernate.hbm2ddl.auto">update</property>
                    <property name="hibernate.show_sql">true</property>
                    <property name="hibernate.format_sql">true</property>
                    <property name="hibernate.use_sql_comments">true</property>
                    <property name="hibernate.cache.use_second_level_cache">true</property>
                    <property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory</property>
                    <property name="hibernate.cache.use_query_cache">true</property>
                </session-factory>
            </hibernate-configuration>
            ```
        
            ex: Student.java
            ```
            @Entity
            @Table(name = "students")
            @Cacheable
            @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
            public class Student {
                @Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                @Column(name = "id")
                private Long id;

                @Column(name = "name")
                private String name;

                @Column(name = "email")
                private String emailId;

                // getters and setters
                public String toString() {
                    return "Student [id=" + id + ", name=" + name + ", emailId=" + emailId + "]";
                }
            }
            ```
            
            ex: MainCacheApp.java
            ```
            public class MainCacheApp {
                public static void main(String[] args) {
                    // Create SessionFactory
                    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
                    // Create Session
                    Session session1 = sessionFactory.openSession();
                    Session session2 = sessionFactory.openSession();

                    // First session: Load student with ID 1
                    Student student1 = session1.get(Student.class, 1L);
                    System.out.println("First Session Student: " + student1);
                    session1.close();

                    // Second session: Load student with ID 1 again
                    Student student2 = session2.get(Student.class, 1L);
                    System.out.println("Second Session Student: " + student2);
                    session2.close();
                    
                    // Close the SessionFactory
                    sessionFactory.close();
                }
            }
            ```

15. @Cacheable and @Cache Annotations in Hibernate:
  - The @Cacheable annotation is used to mark an entity as cacheable, 
        indicating that instances of the entity can be stored in the second-level cache.
  - The @Cache annotation is used to specify the caching strategy for the entity, such as read-only, read-write, or non-strict read-write.

  ex: Student.java
    ```
    @Entity
    @Table(name = "students")
    @Cacheable
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "name")
        private String name;
        
        @Column(name = "email")
        private String emailId;

        @Transient
        private String temporaryData;

        // getters and setters
        public String toString() {
            return "Student [id=" + id + ", name=" + name + ", emailId=" + emailId + "]";
        }
    }
    ```
    - In the above example, the Student entity is marked as cacheable using the @Cacheable annotation.
    - The caching strategy is set to READ_WRITE using the @Cache annotation, which allows both read and write operations on the cached entity.

16. Hibernate Criteria API:
  - The Hibernate Criteria API is a powerful and flexible way to build queries programmatically in Hibernate.
  - It allows you to create queries using a fluent API, making it easier to construct complex queries without writing HQL or SQL directly.
  - The Criteria API supports various features such as filtering, sorting, pagination, and projections.

  ex:
    ```
    class MainCriteriaApp {
        public static void main(String[] args) {
            // Create SessionFactory
            SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            // Create Session
            Session session = sessionFactory.openSession();

            // Create CriteriaBuilder
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

            // Create CriteriaQuery
            CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);

            // Define the root of the query (from clause)
            Root<Student> root = criteriaQuery.from(Student.class);

            // Define the select clause
            criteriaQuery.select(root);

            // Define the where clause (filtering)
            criteriaQuery.where(criteriaBuilder.equal(root.get("name"), "Vivek Mate"));

            // Create the query
            Query<Student> query = session.createQuery(criteriaQuery);

            // Execute the query and get the results
            List<Student> students = query.getResultList();
            for (Student s : students) {
                System.out.println("Criteria API Student: " + s);
            }

            // Close the session
            session.close();
            sessionFactory.close();
        }
    }
    ```

17. Connection Pooling in Hibernate:
  - Connection pooling is a technique used to manage and reuse database connections efficiently.
  - In Hibernate, connection pooling can be configured using various connection pool providers such as HikariCP, C3P0, and Apache DBCP.
  - Connection pooling helps improve the performance of database operations by reducing the overhead of creating and closing connections frequently.

  ex: Configuring HikariCP Connection Pool in hibernate.cfg.xml
    ```
    <?xml version="1.0" encoding="utf-8"?>
    <!DOCTYPE hibernate-configuration PUBLIC
            "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
            "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
    <hibernate-configuration>
        <session-factory>
            <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
            <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
            <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/your_database</property>
            <property name="hibernate.connection.username">your_username</property>
            <property name="hibernate.connection.password">your_password</property>
            <property name="hibernate.hbm2ddl.auto">update</property>
            <property name="hibernate.show_sql">true</property>
            <property name="hibernate.format_sql">true</property>
            <property name="hibernate.use_sql_comments">true</property>

            <!-- HikariCP Connection Pool Configuration -->
            <property name="hibernate.hikari.minimumIdle">5</property>
            <property name="hibernate.hikari.maximumPoolSize">20</property>
            <property name="hibernate.hikari.idleTimeout">30000</property>
            <property name="hibernate.hikari.poolName">MyHikariCP</property>
            <property name="hibernate.hikari.connectionTimeout">20000</property>
            <property name="hibernate.hikari.maxLifetime">1800000</property>

        </session-factory>
    </hibernate-configuration>
    ```

18. How to increase the pool size in HikariCP?
  - To increase the pool size in HikariCP, you can modify the `maximumPoolSize` property in the Hibernate configuration file (hibernate.cfg.xml).
  - The `maximumPoolSize` property defines the maximum number of connections that can be allocated from the connection pool at any given time.

  ex: Increasing the pool size in hibernate.cfg.xml
    ```
    <?xml version="1.0" encoding="utf-8"?>
    <!DOCTYPE hibernate-configuration PUBLIC
            "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
            "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
    <hibernate-configuration>
        <session-factory>
            <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
            <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
            <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/your_database</property>
            <property name="hibernate.connection.username">your_username</property>
            <property name="hibernate.connection.password">your_password</property>
            <property name="hibernate.hbm2ddl.auto">update</property>
            <property name="hibernate.show_sql">true</property>
            <property name="hibernate.format_sql">true</property>
            <property name="hibernate.use_sql_comments">true</property>

            <!-- HikariCP Connection Pool Configuration -->
            <property name="hibernate.hikari.minimumIdle">5</property>
            <property name="hibernate.hikari.maximumPoolSize">50</property> <!-- Increased pool size -->
            <property name="hibernate.hikari.idleTimeout">30000</property>
            <property name="hibernate.hikari.poolName">MyHikariCP</property>
            <property name="hibernate.hikari.connectionTimeout">20000</property>
            <property name="hibernate.hikari.maxLifetime">1800000</property>

        </session-factory>
    </hibernate-configuration>
    ```
  - In the above example, the `maximumPoolSize` property has been increased to 50, 
        allowing up to 50 connections to be allocated from the connection pool simultaneously.