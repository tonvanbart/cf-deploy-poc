### POC deployment project

This project uses the Maven PCF plugin.
To use, you will need to log in. This can be done by specifying username/password on the command line, 
like this:

    mvn cf:apps -Dcf.username=myuser -Dcf.password=mypass
    
Username and password could also be configured inside pom.xml, or in settings.xml for this server. 
Consult the Maven documentation.