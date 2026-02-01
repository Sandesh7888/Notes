
---------------------
SpringBoot Actuator :
---------------------

- SpringBoot Actuator provides production-ready features to help you monitor and manage your application.
- It includes endpoints for health checks, metrics(memory usage, CPU usage, and request statistics), info, and more.
- SpringBoot Actuator provides a 'spring-boot-starter-actuator' library to autoconfigure Actuator endpoints.

    i) {baseUrl}/actuator/info : This endpoint provides general information about the application, such as version, description, and build details. 
            You can customize the information by adding properties to the application.properties or application.yml file.

        ex: application.properties
            info.app.name=MyApp
            info.app.version=1.0.0
            info.app.description=This is a sample Spring Boot application.

    ii) {baseUrl}/actuator/health : This endpoint provides information about the health of the application. 
                    It can include details about database connectivity, disk space, and other custom health indicators.

        ex: application.properties
            management.endpoint.health.show-details=always

    iii) {baseUrl}/actuator/metrics : This endpoint provides various metrics about the application, such as memory usage, CPU usage, 
            and request statistics.
        ex: application.properties
            management.endpoint.metrics.enabled=true

    iv) {baseUrl}/actuator/loggers : This endpoint allows you to view and modify the logging levels of the application at runtime.
        ex: application.properties
            management.endpoint.loggers.enabled=true

    v) {baseUrl}/actuator/env : This endpoint provides information about the application's environment properties, 
                including system properties and environment variables.
    
        ex: application.properties
            management.endpoint.env.enabled=true

    vi) {baseUrl}/actuator/beans : This endpoint provides information about the Spring beans in the application context.
        ex: application.properties
            management.endpoint.beans.enabled=true

    vii) {baseUrl}/actuator/mappings : This endpoint provides information about the request mappings in the application.
        ex: application.properties
            management.endpoint.mappings.enabled=true
        
    viii) {baseUrl}/actuator/configprops : This endpoint provides information about the configuration properties in the application.
        ex: application.properties
            management.endpoint.configprops.enabled=true
    
    ix) {baseUrl}/actuator/shutdown : This endpoint allows you to gracefully shut down the application.
        ex: application.properties
            management.endpoint.shutdown.enabled=true



-----------
# Git Hub : 
-----------

1. GitBash Configuration :
   
     i) git config --global user.name "Vivek Mate"
     ii) git config --global user.email "vivekmate0002@gmail.com"

    * To check the configuration :
     i) git config --list
     ii) git config --global --list

2. Git Architecture :

    * git clone : to clone an existing repository
      
      $ git clone <repository-url>

    * git init : to initialize a new git repository
      
      $ git init
    
    * git add : to add files to the staging area
      
      $ git add <file-name> 
      $ git add . (to add all files)

    * git commit : to commit the changes to the local repository

      $ git commit -m "commit message"

    * git push : to push the changes to the remote repository
      
      $ git push origin <branch-name>

    * git pull : to pull the changes from the remote repository

      $ git pull origin <branch-name>

    * git restore : to discard changes in the working directory

      $ git restore <file-name>

    * git reset : to unstage a file

      $ git reset <file-name>
      $ git reset --hard (to unstage all files and discard changes)

    * git revert : to revert a commit

      $ git revert <commit-id>

    * git log : to view the commit history

      $ git log

    * git rm : to remove a file from the staging area and working directory

      $ git rm <file-name>


3. Git Stash

    - Git Stash is a feature that allows you to temporarily save changes in your working directory that you are not ready to commit yet.
    
    * git stash : to stash the changes in the working directory

      $ git stash

    * git stash list : to view the list of stashed changes

      $ git stash list

    * git stash apply : to apply the stashed changes

      $ git stash apply <stash-id>

    * git stash drop : to drop a stashed change

      $ git stash drop <stash-id>

    * git stash pop : to apply and drop the stashed change

      $ git stash pop <stash-id>


4. Git Branching

    - Git Branching is a feature that allows you to create multiple branches in your repository to work on different features or bug fixes without affecting the main codebase.

    * git branch : to view the list of branches

      $ git branch

    * git branch <branch-name> : to create a new branch

      $ git branch <branch-name>

    * git checkout <branch-name> : to switch to a different branch

      $ git checkout <branch-name>

    * git merge <branch-name> : to merge a branch into the current branch

      $ git merge <branch-name>

    * git branch -d <branch-name> : to delete a branch

      $ git branch -d <branch-name>

    * git checkout -b <branch-name> : to create and switch to a new branch

      $ git checkout -b <branch-name>

    * git branch -r : to view the list of remote branches

      $ git branch -r

    * git branch -a : to view the list of all branches (local and remote)

      $ git branch -a