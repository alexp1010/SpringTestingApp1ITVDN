# SpringDataApp1ITVDN
Spring Data Application form ITVDN Course

------
To check dependency tree conflicts use command "maven dependency:tree -Dverbose"

------
To run tomcat create a batch file:

set CATALINA_HOME="C:\env\apache-tomcat-9.0.31"
set JAVA_HOME="C:\Progra~1\Java\jdk-13.0.1"

set CATALINA_OPTS="-agentlib:jdwp=transport=dt_socket,address=1043,server=y,suspend=n"

%CATALINA_HOME%\bin\startup.bat

------
To debug in Intellij Idea create a remote configuration with port 1043.
"# SpringTestingApp1ITVDN" 
