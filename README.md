# Difference between JDK8 and JDK11 handling URLs

Run the project using JDK 8 and JDK 11 and you will see differences in the output:

JDK8
```
parseURL, url=jarjar:, spec=jarjar:file:webapp.war^/lib.jar
creating classloader
getting resource as stream
parseURL, url=jarjar:, spec=jarjar:file:webapp.war^/lib.jar
url for connection: jar:file:webapp.war!/lib.jar
url for connection: jar:file:webapp.war!/lib.jar
Exception in thread "main" java.lang.IllegalStateException: Didn't resolve resource
	at com.acme.Main.main(Main.java:23)```
```

JDK11
```
parseURL, url=jarjar:, spec=jarjar:file:webapp.war^/lib.jar
creating classloader
getting resource as stream
parseURL, url=jarjar:, spec=jarjar:file:webapp.war^/lib.jar
parseURL, url=jarjar:, spec=jarjar:jar:file:webapp.war
Exception in thread "main" java.lang.IllegalStateException: Didn't resolve resource
	at com.acme.Main.main(Main.java:23)
```

For JDK11 you can see that there is no attempt to open a url, whereas in JDK 8 it correctly attempts to open `jar:file:webapp.war!/lib.jar` 
