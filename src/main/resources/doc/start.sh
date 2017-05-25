#!/bin/bash
#chown 555 -R /export/home/tomcat/domains/
export CATALINA_HOME=/export/servers/tomcat-8.0.43
export CATALINA_BASE=/export/home/tomcat/domains/warestock.jd.com/server1
###JAVA
export JAVA_HOME=/export/servers/jdk1.8.0_121
export JAVA_BIN=/export/servers/jdk1.8.0_121/bin
export PATH=/usr/kerberos/sbin:/usr/kerberos/bin:/usr/local/sbin:/usr/local/bin:/sbin:/bin:/usr/sbin:/usr/bin:/root/bin:/bin
export CLASSPATH=.:/lib/dt.jar:/lib/tools.jar
export DEBUG="-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=9449"
export  JAVA_OPTS="-Djava.library.path=/usr/local/lib -server -Xms1024m -Xmx1024m -XX:MaxPermSize=256m -Djava.awt.headless=true -Dsun.net.client.defaultConnectTimeout=60000 -Dsun.net.client.defaultReadTimeout=60000 -Djmagick.systemclassloader=no -Dnetworkaddress.cache.ttl=300 -Dsun.net.inetaddr.ttl=300"
export JAVA_OPTS="$JAVA_OPTS $DEBUG"
export JAVA_HOME JAVA_BIN PATH CLASSPATH JAVA_OPTS
$CATALINA_HOME/bin/startup.sh -config $CATALINA_BASE/conf/server.xml