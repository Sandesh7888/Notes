===============
Microservices
==============
++++++++++++++++++++++++++
What is Monolith Architecture
++++++++++++++++++++++++++
-> If we develop all the functionalities in single project then it is called as Monolith architecture based application
-> We will package our application as a jar/war to deploy into server
-> As monolith application contains all functionalities, it will become fat jar/war
+++++++++++++
Advantages
+++++++++++++
    1) Simple to develop
    2) Everything is available at once place
    3) Configuration required only once
++++++++++++++++
Dis-Advantages
+++++++++++++++
    1) Difficult to maintain
    2) Dependencies among the functionalities
    3) Single Point Of Failure
    4) Entire Project Deployment
****** To overcome the problems of Monolith, Microservices architecture came into market******
-> Microservices is not a programming language
-> Microservices is not a framework
-> Microservices is not an Specification API
-> Microservices is an architectural design pattern
-> Microservices suggests developing application functionalities with loose coupling
-> In Microservices architecture we don't develop all the functionalities in single project. We will divide project functionalities into several REST APIs
******************Note: One REST API is called as one Microservice************************
-> Microservices architecture based project means collection of REST APIs.
-> Microservices is not related to only java. Any programming language specific project can use Microservices Architecture.
++++++++++++
Advantages
+++++++++++++
    1) Loosely Coupling
    2) Easy To maintain
    3) Faster Development
    4) Quick Deployment
    5) Faster Releases
    6) Less Downtime
    7) Technology Independence

++++++++++++++
Dis-Advantages
++++++++++++++

    1) Bounded Context (Deciding no.of Services to Be Created)
    2) Lot of configurations
    3) Visibility
    4) Pack of cards

++++++++++++++++++++++++++
Microservices Architecture
++++++++++++++++++++++++++

-> We don't have any fixed architecture for Microservices
-> People are customizing microservices architecture according to their requirement
-> Most of the projects will use below components in Microservices Architecture
    1) Service Registry (Eureka Server)
    2) Services (REST APIs)
    3) Interservice Communication (FeignClient)
    4) API Gateway (Zuul Proxy)
    5) Admin Server
    6) Sleuth & Zipkin Server


++++++++++++++++
Service Registry
++++++++++++++++
-> Service Registry acts as DB of services available in the project
-> It provides the details of all the services which are registered with Service Registry
-> We can identify how many services available in the project
-> We can identify how many instances available for each service
-> We can use "Eureka Server" as service registry
-> Eureka Server provided by "Spring Cloud Netflix" library

+++++++++
Services
+++++++++
-> Services means REST APIs / Microservices
-> Services contains backend business logic
-> In the project, some services will interact with DB
-> In the project, some services will interact with third party REST API ( external communication )
-> In the project, some services will interact with another services with in the project ( inter-service communication )
-> For inter-service communication we will use feign-client
-> To distribute the load, we can run one service with Multiple Instances (Load Balancing)


Note: We will register every service with Service Registry
+++++++++++
API Gateway
+++++++++++
-> API Gateway is used to manage our backend apis of the project
-> API Gateway acts as mediator between end users and backend apis
-> API Gateway can filter logic to decide request processing
-> API Gateway will contain Routing logic (which request should go to which REST API)
-> API Gateway also will be registered with Service Registry
-> Spring Cloud Gateway we can use as API Gateway


++++++++++++
Admin Server 
++++++++++++

-> Admin Server is used to manage all backend apis actuator endpoints in one place
-> our backend apis will be registered with Admin Server
-> Admin Sever will provide User Interface to monitor actuator endpoints 


+++++++++++++
Zipkin Server 
+++++++++++++

-> Zipkin Server is used for Distributed log Tracing
-> Using this we can Monitor Which API Is taking more time to process our request


-------------------
Filter And Routing 
-------------------

    * Filter : Filter is used to execute some logic before request processing and after request processing
    * Routing : Routing is used to tell which request should go to which REST API


++++++++++++++++++++++++++++++++++++++++++++++++++++++
Mini Project Implementation using Microservices Architecture
++++++++++++++++++++++++++++++++++++++++++++++++++++
    1) Service Registry (Eureka Server)
    2) Spring Boot Admin Server (To monitor & manage boot applications)
    3) Zipkin Server (Distributed Log Tracing) (https://zipkin.io/pages/quickstart.html)
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
Steps to develop Service Registry Application (Eureka Server)
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    1) Create Service Registry application with below dependency
        a) EurekaServer (spring-cloud-starter-netflix-eureka-server)
        b) web-starter
        c) devtools


    2) Configure @EnableEurekaServer annotation in boot start class
    3) Configure below properties in application.yml file server:

server:
    port: 8761
eureka:
    client:
        register-with-eureka: false

Note: If Service-Registry project port is 8761 then clients can discover service-registry and will register automatically with service-registry. 
    If service-registry project running on any other port number then we have to register clients with service-registry manually.


    4) Once application started we can access Eureka Dashboard using below URL URL : http://localhost:8761/

++++++++++++++++++++++++++++++++++++++++++++++++
Steps to develop Spring Boot Admin Server Project
+++++++++++++++++++++++++++++++++++++++++++++++++
    1) Create Boot application with below dependencies
        a) web-starter
        b) devtools
        c) admin-server (codecentric)
    2) Configure @EnableAdminServer annotation at boot start class
    3) Configure the port number and run the application (port : 1111)
    4) After application started, access Admin Server UI using app-url URL : http://localhost:1111/

++++++++++++++++++++++++++++++++
Steps to work with Zipkin Server
++++++++++++++++++++++++++++++++
    1) Download Zipkin server jar from website
URL : https://zipkin.io/pages/quickstart.html
    2) Run the zipkin server jar from command prompt Cmd : java -jar <jar-file-name>
Note: Zipkin server will run on 9411 port number
    3) Access Zipkin server dashboard in browser URL : http://localhost:9411/

                
+++++++++++++++++++++++++++
Steps to develop GREET-API
++++++++++++++++++++++++++++
    1) Create Spring Boot application with below dependencies
        ◦ eureka-discovery-client
        ◦ starter-web
        ◦ devtools
        ◦ actuator
        ◦ sleuth
        ◦ zipkin
        ◦ admin-client


    2) Configure @EnableDiscoveryClient annotation at start class
    3) Create RestController with required method
    4) Configure below properties in application.yml file
-----------------------------------application.yml-----------------------------------------
server:
    port: 9090

spring:
    application:
        name: GREET-API
    boot:
        admin:
            client:
                url: http://localhost:8080/
    eureka:
        client:
            serviceUrl:
                defaultZone: http://localhost:8761/eureka

management:
    endpoints:
        web:
            exposure:
                include: "*"


    5) Run the application and check in Eureka Dashboard (It should display in eureka dashboard)
    6) Check Admin Server Dashboard (It should display) (we can access application details from here) Ex: Beans, loggers, heap dump, thread dump, metrics, mappings etc...
    7) Send Request to REST API method
    8) Check Zipkin Server UI and click on Run Query button (it will display trace-id with details)
+++++++++++++++++++++++++++++
Steps To Develop WELCOME-API
+++++++++++++++++++++++++++++
    1) Create Spring Boot application with below dependencies
        ◦ web-starter
        ◦ devtools
        ◦ eureka-discovery-client
        ◦ feign-client
        ◦ admin-client
        ◦ zipkin-client
        ◦ sleuth
        ◦ actuator
    2) Configure @EnableDiscoveryClient & @EnableFeignClients annotations at boot start class
    3) Create FeignClient to access GREET-API


@FeignClient(name = "GREET-API") public interface GreetApiClient {

@GetMapping("/greet") public String invokeGreetApi();
}
    4) Create RestController with required method
Note: In Rest Controller we should have logic to access another REST API (GREET-API)


-> For Interservice Communication we will use FeignClient
-> Using FeignClient we can make rest call to another service using name of the service (no need of url)
-> FeignClient will get service URL from service-registry based on service-name


@RestController
public class WelcomeRestController {
private Logger logger = LoggerFactory.getLogger(WelcomeRestController.class);


@Autowired
private GreetApiClient greetClient;


@GetMapping("/welcome") public String welcomeMsg() {

logger.info("welcomeMsg() execution - start");


String welcomeMsg = "Welcome to Ashok IT..!!";


String greetMsg = greetClient.invokeGreetApi();


logger.info("welcomeMsg() execution - end ");


return greetMsg + ", " + welcomeMsg;
}
}
    5) Configure below properties in application.yml file
server:
    port: 9091
spring:
    application:
        name: WELCOME-API
    boot:
        admin:
            client:
                url: http://localhost:1111/
management:
    endpoints:
        web:
            exposure:
                include: "*"


    6) Run WELCOME-API project (it should register in Eureka and Admin server)
    7) Send Request to welcome-api (it should final response)


    8) Verify Zipkin Server Dashboard for log tracing
++++++++++++++++++++++++++++++++++++++++++++++++++++++
-> We are running Service Registry project with Eureka Server on 8761 port number
-> Eureka Discovery Client applications are auto-registering with Eureka Server when port is 8761   
-> If we change Eureka Server port number then we have to register Eureka Client application with Eureka Server using below property 
    in application.yml file

eureka:
    client:
        serviceUrl:
            defaultZone: http://localhost:9090/eureka

Note: We should configure this property in eureka client application yml file
++++++++++++++++++++++++++++++++++++++++++++++++++++++ GREET API URL : DESKTOP-BDG00U7:GREET-API:9090/

WELCOME API URL : DESKTOP-BDG00U7:WELCOME-API:9091/


==================
Load Balancer 
==================
 Note : when we run application on single server then it may not handle huge load 

-> when many requests are coming to application then server may crash or application may go down.
-> to avoid these problems we can use load Balancer for application execution
-> Load Balancer is used to distribute application load to multiple servers to reduce burden 

 Note : Insted of running our application in single server, we will run our application in multiple server to handle load 
 Note : When application is running in multiple servers then we will call them as Instances.

 



==================
API Gateway
==================
-> API Gateway will act as mediator between client requests & backend apis
-> API Gateway will provide single entrypoint to access our backend apis
-> In Api Gateway we will write mainley below 2 types of logics
    1) Filters
    2) Routing
-> Filters are used to execute some logic before request processing and after request processing
-> Routing is used to tell which request should go to which REST API 
-> In Spring Cloud, we have 2 options to create API Gateway
        1) Zuul Proxy (old approach)
        2) Spring Cloud Gateway (latest approach) Note: Zuul Proxy is not supported by latest versions of spring boot
        
++++++++++++++++++++++++++++++++++++++++
Working with Spring Cloud API Gateway
++++++++++++++++++++++++++++++++++++++++
    1) Create Spring boot application with below dependencies
-> web-stater
-> eureka-client
-> cloud-gateway
-> devtools

* below two Dependencies are also fine to build API Gateway (Without web starter)
implementation 'org.springframework.cloud:spring-cloud-starter-gateway'
implementation 'org.springframework.cloud:spring-cloud-starter-netflix-eureka-client'


    2) Configure @EnableDiscoveryClient annotation at boot start class
    3) Configure API Gateway Routings in application.yml file like below

application.yml file

spring:
  application:
    name: API_Gateway
  cloud:
    gateway:
      discovery:
        locator:
          enabled: true
          lower-case-service-id: false
      routes:
        - id: welcome
          uri: lb://WELCOMEAPI
          predicates:
            - Path=/welcome
        - id: greet
          uri: lb://GREETAPI
          predicates:
            - Path=/greet
server:
  port: 3333



In API gateway we will have 3 types of logics
    1) Route
    2) Predicate
    3) Filters
-> Routing is used to defined which request should be processed by which REST API in backend. Routes will be configured using Predicate
-> Predicate : This is a Java 8 Function Predicate. The input type is a Spring Framework ServerWebExchange. This lets you match on anything from the HTTP request, such as headers or parameters.
-> Filters are used to manipulate incoming request and outgoing response of our application
Note: Using Filters we can implement security also for our application.


@Component
public class GlobalLoggingFilter implements GlobalFilter {

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    System.out.println("Incoming request: " + exchange.getRequest().getURI());

    ServerHttpRequest request = exchange.getRequest();
    HttpHeaders headers = request.getHeaders(); Set<String> keySet = headers.keySet();

    keySet.forEach(key -> {
      List<String> values = headers.get(key); System.out.println(key +" :: "+values);
    });

    return chain.filter(exchange);
  }
}

++++++++++++++++++++++++++++++++++++++++++++++++++++++
-> We can validate client given token in the request using Filter for security purpose
-> We can write request and response tracking logic in Filter
-> Filters are used to manipulate request & response of our application
-> Any cross-cutting logics like security, logging, monitoring can be implemented using Filters

====================
Sleuth & Zipkin
===================
-> Microservices application means several REST APIs will be available
-> As part of application execution one Rest API can communicate with another REST API
-> When we send request from UI, it will process by Multiple REST APIs with Interservice communication


*** How we can understand which rest api is taking more time to process our request ? ***
-> If we add Sleuth dependency in REST API then it will add span-id and trace-id for log messages
-> For every request once trace-id will be generated by Sleuth
-> If one request is processing multiple REST API then Sleuth will use same span-id for REST APIs to generate log message
-> Trace-id is specific to one REST API
-> By using span-id and trace-id we can understand which REST api has taken more time process request
-> To monitor span-id and trace-id details we will use ZipKin server
-> Zipkin server is providing user interface (UI) to monitor all the details


Note: The REST APIs which are having sleuth dependency should register with Zipkin server


Note: By using Sleuth and Zipkin we achieve Distributed Log Tracing


======================================
Steps to work with Sleuth and Zipkin
======================================


    1) Add below dependency in welcome-api and greet-api projects pom.xml


<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-starter-sleuth</artifactId>
</dependency>


<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-sleuth-zipkin</artifactId>
</dependency>


    2) Download zipkin-server jar file (https://zipkin.io/pages/quickstart)
    3) Run zipkin-server using "java -jar <zipkin-jar-filename" Note: Zipkin server runs on 9411 port
    4) Run spring boot applications and send a request to rest controller method
    5) Verify boot application logs display in console (span-id and trace-id will be attached to logs)
    6) Go to Zipkin server dashboard and monitor event details ( URL : http://localhost:9411 )

++++++++++++++++++++++++++++++++++++++++++++++++++++++


    1) What is Monolith Architecture ?
    2) Pros and Cons of Monolith Architecture
    3) Microservies Introduction
    4) Pros and Cons of Microservices
    5) Microservices Architecture
    6) Service Registry (Eureka)
    7) Admin Server (Monitor & Manager actuators)
    8) Zipkin Server with Sleuth
    9) Backend Apis Development
    10) Inter-service communication (Feign Client)
    11) Load Balancing with Ribbon
    12) Api Gateway (Front end gate of all backend apis)
    13) Filters & Routings in API Gateway
=====================
Cloud Config Server
====================
=> As of now we are configuring properties in application.properties or application.yml file
Ex: DB Props, SMTP props, Kafka Props, Messages etc...
=> application.properties or application.yml file will be packaged along with our application.
=> If we want to make any changes to properties then we have to re-package our application
=> To externalize properties from the application we can use Cloud Config Server
==================
Config Server App
===================
    1) Create Git Repository and keep ymls files required for projects
Note: We should keep file name as application app name : greet then file name : greet.yml
app name : welcome then file name : welcome.yml


### Git Repo : https://github.com/ashokitschool/configuration_properties


    2) Create Spring Starter application with below dependency
<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-config-server</artifactId>
</dependency>


    3) Write @EnableConfigServer annotation at boot start class


@SpringBootApplication @EnableConfigServer public class Application {
public static void main(String[] args) {
SpringApplication.run(Application.class, args);	}	}
    4) Configure below properties in application.yml file spring:
cloud:
config:
server:
git:
uri: https://github.com/ashokitschool/configuration_properties clone-on-start: true
management:
security:
enabled: false


    5) Run Config Server application


=================================
Config Server Client Development
=================================
    1) Create Spring Boot application with below dependencies
        a) web-starter
        b) config-client
        c) dev-tools


<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-starter-config</artifactId>
</dependency>


    2) Create Rest Controller with Required methods
@RestController @RefreshScope
public class WelcomeRestController {


@Value("${msg}") private String msg;

@GetMapping("/")
public String getWelcomeMsg() { return msg;
}
}


    3) Configure ConfigServer url in application.yml file like below


server:
port: 9090 spring:
config:
import: optional:configserver:http://localhost:8080 application:
name: greet


    4) Run the application and test it.
==================================================================================
=================================
Circuit Breaker
=================================
-> Circuit Breaker is a design pattern in Microservices
-> Circuit Breaker is used to implement fault-tolerance systems
-> Fault-tolerance systems are also called as resillence systems
-> Fault-tolerance system means when main logic is failed to execute then we should execute fallback logic to process client request
===========
Usecase
===========
=> Get data from redis, if redis logic is failing then we should get data from database


Note: If redis logic is failing for 3 requests continuosly then execute db logic for 30 mins. After 30 mins re-try for redis logic execution if it is working then execute redis logic only. If 3 re-try executions failed with redis then execute db logic for next 30 mins.


-> To implement circuit-breaker we should add below dependency in pom.xml file
<dependency>
<groupId>io.pivotal.spring.cloud</groupId>
<artifactId>spring-cloud-services-starter-circuit-breaker</artifactId>
</dependency>


-> Write @EnableHystrix annotation at boot start class




@RestController
public class DataRestController {


@GetMapping("/data") @HystrixCommand(
fallbackMethod = "getDataFromDB",
commandProperties = {
@HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="3"), @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="10000"),
@HystrixProperty(name="circuitBreaker.enabled",
value="true")
}
)
public String getDataFromRedis() {
System.out.println("**getDataFromRedis() method called**"); if (new Random().nextInt(10) <= 10) {
throw new RuntimeException("Redis Server Is Down");
}
// logic to access data from redis
return "data accessed from redis (main logic)	";
}


public String getDataFromDB() {
System.out.println("**getDataFromDB() method called**");
// logic to access data from db
return "data accessed from database (fall back logic)	";
}
}
==================================================================================
===================
Spring Security
===================


How to secure REST APIs using Spring Boot
============================================
-> Security is very important for every web application
-> To protect our application & application data we need to implement security logic
-> Spring Security concept we can use to secure our web applications / REST APIs
-> To secure our spring boot application we need to add below starter in pom.xml file
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-security</artifactId>
</dependency>


Note: When we add this dependency in pom.xml file then by default our application will be secured with basic authentication. It will generate random password to access our application.


Note: Generated Random Password will be printed on console.
-> We need to use below credentials to access our application
Username : user
Password : <copy the pwd from console>


-> When we access our application url in browser then it will display "Login Form" to authenticate our request.
-> To access secured REST API from postman, we need to set Auth values in POSTMAN to send the request
Auth : Basic Auth Username : user
Password : <copy-from-console>
=====================================================
How to override Spring Security Default Credentials
=====================================================
-> To override Default credentials we can configre security credentials in application.properties file or application.yml file like below
spring.security.user.name=ashokit
spring.security.user.password=ashokit@123
-> After configuring credentials like above, we need to give above credentials to access our application
/ api.


=====================================
How to secure specific URL Patterns
=====================================
-> When we add 'security-starter' in pom.xml then it will apply security filter for all the HTTP methods of our application.
-> But in reality we need to secure only few methods not all methods in our application.


For Example
/ login-page --> security not required
/ transfer ---> security required
/ balance ---> security required
/about-us ---> security not required


-> In order to achieve above requirement we need to Customize Security Configuration in our project like below
@Configuration @EnableWebSecurity
public class SecurityConfigurer {


@Bean
public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception{


http.authorizeHttpRequests((request) -> request
.antMatchers("/","/login","/about", "/swagger-ui.html").permitAll()
.anyRequest().authenticated()
).formLogin();


return http.build();
}
}


==============================================
Spring Boot Security with JDBC Authentication
==============================================
Step-1 ) Setup Database tables with required data
-- users table structure


CREATE TABLE `users` (
`username` VARCHAR(50) NOT NULL,
`password` VARCHAR(120) NOT NULL,
`enabled` TINYINT(1) NOT NULL, PRIMARY KEY (`username`)
);


-- authorities table structure
CREATE TABLE `authorities` (
`username` VARCHAR(50) NOT NULL,
`authority` VARCHAR(50) NOT NULL, KEY `username` (`username`),
CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
);




================ Online Encrypt : https://bcrypt-generator.com/ =====================
-- insert records into table


insertintousersvalues('admin',
'$2a$12$e9oIZjBeSJDryJ/P5p1Ep.WPzJ3f4.C2vHC/as1E22R25XXGpPYyG', 1); insertintousersvalues('user',
'$2a$12$JQiGAJhdSOoTXAzIpbDxpemXcYHCmxYOnodLNBeNORH8J4FLxHGvK',  1);


insert into authorities values ('admin', 'ROLE_ADMIN'); insert into authorities values ('admin', 'ROLE_USER'); insert into authorities values ('user', 'ROLE_USER');

Step-2) Create Boot application with below dependencies
    a) web-starter
    b) security-starter
    c) data-jdbc
    d) mysql-connector
    e) lombok
    f) devtools


Step-3 ) Configure Data source properties in application.yml file
spring:
datasource:
driver-class-name: com.mysql.cj.jdbc.Driver password: AshokIT@123
url: jdbc:mysql://localhost:3306/sbms27 username: ashokit
jpa:
show-sql: true


Step-4) Create Rest Controller with Required methods


@RestController
public class UserRestController {


@GetMapping(value = "/admin") public String admin() {
return "<h3>Welcome Admin :)</h3>";
}


@GetMapping(value = "/user") public String user() {
return "<h3>Hello User :)</h3>";
}


@GetMapping(value = "/") public String welcome() {
return "<h3>Welcome :)</h3>";
}


}
Step-5) Create Security Configuration class like below with Jdbc Authentication Manager package in.ashokit;
@Configuration @EnableWebSecurity
public class SecurityConfiguration {
private static final String ADMIN = "ADMIN"; private static final String USER = "USER";

@Autowired
private DataSource dataSource;


@Autowired
public void authManager(AuthenticationManagerBuilder auth) throws Exception { auth.jdbcAuthentication()
.dataSource(dataSource)
.passwordEncoder(new BCryptPasswordEncoder())
.usersByUsernameQuery("select username,password,enabled from users where
username=?")
.authoritiesByUsernameQuery("select username,authority from authorities where
username=?");
}
@Bean
public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception { http.authorizeHttpRequests( (req) -> req
.antMatchers("/admin").hasRole(ADMIN)
.antMatchers("/user").hasAnyRole(ADMIN,USER)
.antMatchers("/").permitAll()
.anyRequest().authenticated()
).formLogin();
return http.build();
}
}
===========
OAuth 2.0
===========
    1) Create Spring Boot application with below dependencies
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-oauth2-client</artifactId>
</dependency>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-web</artifactId>
</dependency>


    2) Create OAuth app in Github.com
(Login --> Settings --> Developer Settings --> OAuth Apps --> Create App --> Copy Client ID & Client Secret)


    3) Configure GitHub OAuth App client id & client secret in application.yml file like below spring:
security: oauth2:
client:
registration: github: clientId:
clientSecret:
    4) Create Rest Controller with method @RestController
public class WelcomeRestController {


@GetMapping("/") public String welcome() {
return "Welcome to Ashok IT";
}
}
    5) Run the application and test it.
=====================
Spring Boot with JWT
=====================
-> JWT stands for JSON Web Tokens
-> JSON Web Tokens are an open, industry standard RFC 7519 method for representing claims securely between two parties.
-> JWT official Website : https://jwt.io/
-> Below is the sample JWT Token


token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG 9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c


-> JWT contains below 3 parts
        1) Header
        2) Payload
        3) Signature
Note: JWT 3 parts will be seperated by using dot(.)
=========================================================
    1) Create Spring Boot application with below dependencies
=========================================================
<dependencies>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-web</artifactId>
</dependency>


<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-devtools</artifactId>
<scope>runtime</scope>
<optional>true</optional>
</dependency>
<dependency>
<groupId>org.projectlombok</groupId>
<artifactId>lombok</artifactId>
<optional>true</optional>
</dependency>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-tomcat</artifactId>
<scope>provided</scope>
</dependency>


<dependency>
<groupId>io.jsonwebtoken</groupId>
<artifactId>jjwt</artifactId>
<version>0.9.1</version>
</dependency>
<dependency>
<groupId>javax.xml.bind</groupId>
<artifactId>jaxb-api</artifactId>
</dependency>


<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-test</artifactId>
<scope>test</scope>
<exclusions>
<exclusion>
<groupId>org.junit.vintage</groupId>
<artifactId>junit-vintage-engine</artifactId>
</exclusion>
</exclusions>
</dependency>
<dependency>
<groupId>org.springframework.security</groupId>
<artifactId>spring-security-test</artifactId>
<scope>test</scope>
</dependency>
</dependencies>
===================================================
    2) Create Request and Response Binding Classes
===================================================
@Data
public class AuthenticationRequest implements Serializable { private String username;
private String password;
}
public class AuthenticationResponse implements Serializable { private final String jwt;
public AuthenticationResponse(String jwt) { this.jwt = jwt;
}
public String getJwt() { return jwt;
}
}
=============================================================
    3) Create UserDetailsService for credentials configuration
=============================================================
@Service
public class MyUserDetailsService implements UserDetailsService { @Override
public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
return	new	User("admin", "$2a$12$e9oIZjBeSJDryJ/P5p1Ep.WPzJ3f4.C2vHC/as1E22R25XXGpPYyG", new ArrayList<>());
}
}
===================================================
    4) Create JwtUtils class
===================================================
@Service
public class JwtUtil {
private String SECRET_KEY = "secret";


public String extractUsername(String token) {
return extractClaim(token, Claims::getSubject);
}


public Date extractExpiration(String token) {
return extractClaim(token, Claims::getExpiration);
}


public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) { final Claims claims = extractAllClaims(token);
return claimsResolver.apply(claims);
}
private Claims extractAllClaims(String token) {
return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
}


private Boolean isTokenExpired(String token) {
return extractExpiration(token).before(new Date());
}


public String generateToken(UserDetails userDetails) { Map<String, Object> claims = new HashMap<>();
return createToken(claims, userDetails.getUsername());
}
private String createToken(Map<String, Object> claims, String subject) {


return Jwts.builder()
.setClaims(claims)
.setSubject(subject)
.setIssuedAt(new Date(System.currentTimeMillis()))
.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
.signWith(SignatureAlgorithm.HS256, SECRET_KEY)
.compact();
}


public Boolean validateToken(String token, UserDetails userDetails) { final String username = extractUsername(token);
return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
}
}


===================================================
    5) Create Filter class
===================================================
@Component
public class JwtRequestFilter extends OncePerRequestFilter {


@Autowired
private MyUserDetailsService userDetailsService;


@Autowired
private JwtUtil jwtUtil;
@Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
throws ServletException, IOException {


final String authorizationHeader = request.getHeader("Authorization");


String username = null; String jwt = null;

if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) { jwt = authorizationHeader.substring(7);
username = jwtUtil.extractUsername(jwt);
}
if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {


UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);


if (jwtUtil.validateToken(jwt, userDetails)) {


UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
userDetails, null, userDetails.getAuthorities()); usernamePasswordAuthenticationToken
.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
}
}
chain.doFilter(request, response);
}
}
====================================
    6) Create WebSecurity Config class
====================================
package com.ashokit.security; @Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter { @Autowired
private UserDetailsService myUserDetailsService; @Autowired
private JwtRequestFilter jwtRequestFilter; @Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { auth.userDetailsService(myUserDetailsService);
}
@Bean
public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder();
}
@Override @Bean
public AuthenticationManager authenticationManagerBean() throws Exception { return super.authenticationManagerBean();
}
@Override
protected void configure(HttpSecurity httpSecurity) throws Exception { httpSecurity.csrf()
.disable()
.authorizeRequests()
.antMatchers("/authenticate")
.permitAll()
.anyRequest()
.authenticated()
.and()
.exceptionHandling()
.and()
.sessionManagement()
.sessionCreationPolicy(SessionCreationPolicy.STATELESS);


httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
}
}


==================================
    7) create Rest Controller class
===================================
package com.ashokit.rest; @RestController
public class HelloRestController { @Autowired
private AuthenticationManager authenticationManager; @Autowired
private JwtUtil jwtTokenUtil; @Autowired
private MyUserDetailsService userDetailsService; @RequestMapping({ "/hello" })
public String firstPage() {
return "Hello World";
}


@RequestMapping(value = "/authenticate", method =
RequestMethod.POST)
public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
throws Exception {


try {
authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
authenticationRequest.getUsername(),
authenticationRequest.getPassword()));
} catch (BadCredentialsException e) {
throw new Exception("Incorrect username or password", e);
}


final	UserDetails	userDetails	= userDetailsService.loadUserByUsername(authenticationRequest.getUsername());


final String jwt = jwtTokenUtil.generateToken(userDetails);


return ResponseEntity.ok(new AuthenticationResponse(jwt));
}
}


==================================
    8) Run the application and Test it
===================================
=========================================
Spring Boot with Redis Cache Integration
=========================================
==============
Introduction
==============
-> Every application will interact with database to store and retrieve data
-> In DB we will maintain data in tables (Rows & Columns)
-> DB tables are divided into 2 types
        1) Transactional Tables
        2) Non-Transactional Tables
-> If our application is perfoming INSERT / UPDATE / DELETE operations in table then it is called as Transactional Table.
-> If our application is performing only SELECT operation in the table then it is called as Non- Transactional table.


Examples :


-> When student register, then our application will insert student details into STUDENT_DTLS table (This is Transactional Table)


-> When student open 'Register For Demo' pop-up it will display COUNTRY Name with Country Code to enter Mobile number. Here our application will read the data from COUNTRY_MASTER table. In our application we don't insert / update / delete data in COUNTRY_MASTER table (This is Non- Transactional table)


-> If we retrieve contries data from table for multiple times also the data will be same and un- necessarily multiple queries will execute and it reduces our application performance.
-> When we have this kind of scenario then its better to go for Cache Memory.
-> Static tables data we should retrieve only one time and store into Cache memory.
-> When our application needs that static data we can retrieve from Cache instead of Retrieving from DB.
-> Cache will be created in JVM and our application is also running in same JVM hence retrieval will be faster where as DB calls are costly
===============
What is Cache ?
===============
-> Cache is a memory which is used to store the data in key-value format.
-> If our application having a requirement to use static data then it is highly recommended to use Cache in that application.
-> Using cache data we can reduce no.of db calls and we can improve performance of the application.
-> If we want to use cache in one application then we will go for Local cache. Local cache means we will implement with in our application.
-> If we want to use cache data in several applications then we will go for Global Cache.
======================
How to implement cache
=======================
-> Once application got started take data from db and store that into cache in the form of key-value pair.
-> When application needs that data take it from cache memory instead of making db call.
-> By using cache memory we can reduce no.of db calls hence application performance will be improved.
==============================================
Q) What is Local cache & What is distributed cache ?
==============================================
-> If we implement cache with in one application then it called as local cache.
-> If we want to use cache data in multiple applications then we should go for distributed cache (Ex: Redis cache)
=======================
Q) What is Redis?
=======================
-> Redis is an open source cache which is used to store the data in the form key-value pair.
-> Multiple applications can connect to Redis cache to access the data.
=======================
Redis Environment Setup
=======================
    1) Download redis-server software
    2) Extract downloaded zip file
    3) Double click on redis-server.exe file (redis server will start)
    4) Double click on redis-cli.exe file
    5) Type ping in client cmd it will respond with PONG. Note : With this redis server setup is ready.
Note: In realtime, redis-server will be installed in remote machine and they will share redis-server details (url, uname, pwd and port)


==============================================
Spring Boot Application with Redis Integration
==============================================
    1) Create Spring Boot application with below dependencies
        1) spring-boot-starter-web
        2) spring-boot-starter-redis
        3) project lombok
        4) devtools
        5) swagger & swagger-ui


    2) Configure JedisConnectionFactory bean with Redis Server details & inject JedisConnectionFactory bean into RedisTemplate bean


    3) Create Binding class class


    4) Create Service Class with required methods. Inject RedisTemplate into Repository bean and get HashOperations object to perform redis operations.


    5) Create Rest Controller with required methods
    6) Run the application and test it.
===================================================================
Spring Boot with Redis Integration Project Git repo :
https://github.com/ashokitschool/Springboot_Redis_App
===================================================================
==============
Apache Kafka
==============
=> Apache Kafka is a distributed streaming platform
=> Apache Kafka is called as Message Broker
=> Apache Kafka is used to process real time data feeds with high throughput and low latency Ex : flights data, sensors data, stocks data, news data, social media etc....
=> Kafka works based on Publisher and Subscriber model
===================
Kafka Terminology
===================
Zookeeper Kafka Server Kafka Topic Message Publisher Subscriber

===========
Kafka APIs
===========
Connector API Publisher API Subscriber API Streams API
========================================
Spring Boot + Apache Kafka Application
=======================================
Step-1 : Download Zookeeper from below URL
URL : http://mirrors.estointernet.in/apache/zookeeper/stable/


Step-2 : Download Apache Kafka from below URL URL : http://mirrors.estointernet.in/apache/kafka/

Step-3 : Set Path to ZOOKEEPER in Environment variables upto bin folder


### Note: zookeeper.properties file will be available in kafka/config folder. You can copy zookeeper.properties and server.properties files from kafka/config folder to kafka/bin/windows folder. ###


Step-4 : Start Zookeeper server using below command from kafka/bin/windows folder Command : zookeeper-server-start.bat zookeeper.properties

Step-5: Start Kafka Server using below command from Kakfa folder Command : kafka-server-start.bat server.properties

Step-6 : Create Kakfa Topic using below command from kafka/bin/windows folder
Command : kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 -- partitions 1 --topic amazon_orders_topic


Step-7 : View created Topics using below command
Command : kafka-topics.bat --list --bootstrap-server localhost:9092
##############################
Kafka Producer App Development
##############################


=============================
    1) Add below dependencies
================================
<dependencies>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-web</artifactId>
</dependency>


<dependency>
<groupId>org.apache.kafka</groupId>
<artifactId>kafka-streams</artifactId>
</dependency>
<dependency>
<groupId>org.springframework.kafka</groupId>
<artifactId>spring-kafka</artifactId>
</dependency>


<dependency>
<groupId>com.fasterxml.jackson.core</groupId>
<artifactId>jackson-databind</artifactId>
</dependency>


<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-test</artifactId>
<scope>test</scope>
</dependency>
<dependency>
<groupId>org.springframework.kafka</groupId>
<artifactId>spring-kafka-test</artifactId>
<scope>test</scope>
</dependency>
</dependencies>
========================================
    2) Create Kafka Constants class
========================================
public class AppConstants {


public static final String TOPIC = "ashokit_order_topic"; public static final String HOST = "localhost:9092";

}
=======================================
    3) Create Model class to represent data
=======================================
@Data
public class Order {
private String id;
private Double price; private String email;
}
=======================================
    4) Create Kafka Producer Config class
=======================================


@Configuration
public class KafkaProduceConfig { @Bean
public ProducerFactory<String, Order> producerFactory() {


Map<String, Object> configProps = new HashMap<>();


configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstants.HOST);
configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);


return new DefaultKafkaProducerFactory<>(configProps);
}


@Bean
public KafkaTemplate<String, Order> kafkaTemplate() { return new KafkaTemplate<>(producerFactory());
}


}
==============================
    4) Create Service Class
============================
@Service
public class OrderService {


@Autowired
private KafkaTemplate<String, Order> kafkaTemplate;


public String addMsg(Order order) {


// publish msg to kafka topic
kafkaTemplate.send(AppConstants.TOPIC, order);


return "Msg Published To Kafka Topic";
}
}


=================================
    5) Create RestController classs
==============================
@RestController
public class OrderRestController { @Autowired
private OrderService service; @PostMapping("/order")
public String createOrder(@RequestBody Order order) { String msg = service.addMsg(order);
return msg;
}
}
====================================
    6) Run the application and test it
====================================
{
"id" : "OD101",
"price" : 200.00,
"email" : "smith@gmail.com"
}


#################################
Kafka Subscriber App Dvelopment
#################################
==========================
    1) Add below dependencies
==========================
<dependencies>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-web</artifactId>
</dependency>


<dependency>
<groupId>org.apache.kafka</groupId>
<artifactId>kafka-streams</artifactId>
</dependency>
<dependency>
<groupId>org.springframework.kafka</groupId>
<artifactId>spring-kafka</artifactId>
</dependency>


<dependency>
<groupId>com.fasterxml.jackson.core</groupId>
<artifactId>jackson-databind</artifactId>
</dependency>


<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-test</artifactId>
<scope>test</scope>
</dependency>
<dependency>
<groupId>org.springframework.kafka</groupId>
<artifactId>spring-kafka-test</artifactId>
<scope>test</scope>
</dependency>
</dependencies>
==========================
    2) Create Constants class
=========================
public class KafkaConstants {
public static final String TOPIC = "ashokit_order_topic"; public static final String HOST = "localhost:9092";
}
===============================
    3) Create Model class
===============================
@Data
public class Order {
private String id;
private Double price; private String email;
}
===================================
    4) Create Consumer Config
===================================
@Configuration
public class KafkaConsumerConfig { @Bean
public ConsumerFactory<String, Order> consumerFactory() {


Map<String, Object> configProps = new HashMap<String, Object>();


configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstants.HOST);
configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);


return new DefaultKafkaConsumerFactory<>(configProps, new StringDeserializer(), new JsonDeserializer<>());


}
@Bean
public ConcurrentKafkaListenerContainerFactory<String, Order> kafkaListenerFactory() {


ConcurrentKafkaListenerContainerFactory<String, Order> factory = new ConcurrentKafkaListenerContainerFactory<>();

factory.setConsumerFactory(consumerFactory());


return factory;
}
}
==================================================
    5) Add below method in boot app start class
====================================================


@KafkaListener(topics = AppConstants.TOPIC, groupId="group_ashokit_order") public void subscribeMsg(String order) {
System.out.print("*** Msg Received From Kafka *** :: "); System.out.println(order);
//logic
}
=======================================
    6) Run the application
=======================================


####### 7) Send Request to Producer app and observer Subscriber app console ############
==============
Spring Batch
==============
=> Spring Batch is a lightweight, comprehensive batch framework designed to enable the development of robust batch applications.
============================
What is Batch Application ?
============================
-> The application which will process bulk of records is called as Batch application. Ex :
    1) Sending Monthly Salaries to all employees in company
    2) Generating Monthly Payslips for employees
    3) Sending Monthly Bank Account statement to acc holders
    4) Sending Monthly credit card bill statement to card holders
    5) Sending Festival Greetings to all customers
    6) Sending Notices on daily/weekly/monthly/yearly basis...


Process process CSV File ==========> Database =========> CSV File
=========================
Spring Batch Terminology
=========================
    1) JobLauncher
    2) Job
    3) Step
    4) ItemReader
    5) ItemProcessor
    6) ItemWriter
    7) JobRepository
===============================
Spring Boot with Batch Example
===============================
Requirement : Read Customers Data From CSV file and write into Database table


    1) Create Spring Starter project with below dependencies
        a) web-starter
        b) batch
        c) data-jpa
        d) mysql-driver
        e) lombok


    2) Configure Datasource properites in application.yml file
    3) Keep Source File under src/main/resources folder (customers.csv)
    4) Create Entity class & Repository interface
    5) Create Batch Configuration class
    6) Create RestController and launch job


#### Git Hub Repo URL : https://github.com/ashokitschool/sringboot_batch_app.git ####
====================
Reactive Programming
====================
    1) Synchronus based execution ( Blocking Thread )
    2) Asynchronus based execution ( Non Blocking Thread )


=> Spring 5.x introduced Reactive Programming
=> In Spring 5.x 'starter-webflux' introduced
==================
Old Approach
==================
@RestController
public class WelcomeRestController{


@GetMapping("/msg") public String getMsg(){
return "Hello";
}
}
===============
New Approach
===============
@Component
public class MessageRequestHandler{
public Mono<ServerResponse> handle(ServletRequest request){ return new ServerResponse.ok()

.contentType(MediaType.APPLICATION_JSON)

.body(BodyInserters.fromValue(data));
}
}
@Configuration public MsgRouter {

@Bean
public RouterFunction<ServerResponse> route(MessageRequestHandler requestHandler)
{
return RouterFunctions.route(GET("/hello"))

.and(accept(MediaType.APPLICATION_JSON), MessageRequestHandler::handle);


}
}


=============================
SprinBoot Reactive Example
============================
    1) Create Boot application with 'Reactive Web' dependency
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-webflux</artifactId>
</dependency>


Note: Reactive Web dependency means 'starter-webflux' dependency. It will provide 'Netty' as default embedded container.


    2) Create Binding class to response @Data
@AllArgsConstructor @NoArgsConstructor public class Greeting {
private String msg;
}
    3) Create Request Handler class like below @Component
public class GreetingHandler {


public Mono<ServerResponse> hello(ServerRequest request){


return ServerResponse.ok()
.contentType(MediaType.APPLICATION_JSON)
.body(BodyInserters.fromValue(new	Greeting("Hello
World")));
}
}


    4) Create Router class @Configuration
public class GreetingRouter {


@Bean
public RouterFunction<ServerResponse> route(GreetingHandler greeting){ return RouterFunctions
.route(GET("/hello")
.and(accept(MediaType.APPLICATION_JSON)), greeting::hello);
}
}




    5) Run the application and test it.
============
ELK Stack
============
=> ELK is the combination of 3 open source products


    1) Elastic Search : It is used to store and process logs


    2) Logstash : It is used to collect application logs and store in Elastic Search


    3) Kibana : It will provide user interface to monitor application logs


=> By using the above 3 products we can implement Log Aggregation and Logs Monitoring


===========
ELK Setup
===========
    1) Download ELK Softwares


=> Elastic Search : https://www.elastic.co/downloads/elasticsearch


=> Kibana : https://www.elastic.co/downloads/kibana


=> Logstash : https://www.elastic.co/downloads/logstash


    2) Extract all zip files


    3) Run elasticsearch using elasticsearch.bat file (make sure all security settings disable in elasticsearch.yml before running)
$ elasticsearch.bat


    4) Check Elastic Search Running or not (URL : http://localhost:9200/ )
    5) Run kibana using kibana.bat file (before running kibana, enable elasticsearch url in kibana.yml file)


$ kibana.bat


    6) Check Kibana running or not ( URL : http://localhost:5601/app/home )


    7) Run Spring Boot Application and generate log file with log messages


    8) create logstash.conf file like below


# Sample Logstash configuration for creating a simple # Beats -> Logstash -> Elasticsearch pipeline.

input { file {
path => "C:/Users/ashok/classes/22-JRTP/workspace/SpringBoot_REST_API/app.log" start_position => "beginning"
}
}
output {
elasticsearch {
hosts => ["http://localhost:9200"]
}
}
    9) Run logstash server using below command


$ logstash -f logstash-sample.conf


    10) Check logstash server is running or not ( http://localhost:9600 )


    11) Check application logs in Kibana dashboard
