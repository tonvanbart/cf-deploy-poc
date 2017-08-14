### POC deployment project

This project uses the Maven PCF plugin.
To use, you will need to log in. This can be done by specifying username/password on the command line, 
like this:

    mvn cf:login -Dcf.username=myuser -Dcf.password=mypass
    
Username and password could also be configured inside pom.xml, or in settings.xml for this server.
In the latter case it is advised to use the Maven password encryption feature; consult the Maven 
documentation.

From Maven 3.3.1 up, it is possible to push one single application by specifying a specific execution
ID as follows:

    mvn cf:push@minesweep-deploy
    
The project uses the Maven dependency plugin to pick up the project to deploy from a local or
remote repository. To pick up and deploy a fresh copy:

    mvn dependency:copy cf:push@minesweep-deploy
    
This requires the demo project to at least be installed in the local M2 repository.