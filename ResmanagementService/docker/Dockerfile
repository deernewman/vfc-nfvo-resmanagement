#
# This file was auto-generated by gen-all-dockerfiles.sh; do not modify manually.
#
# nfvo-resmanagement/target/Dockerfile
#

# 10-basebuild.txt

FROM centos:7

RUN sed -i 's/enabled=1/enabled=0/' /etc/yum/pluginconf.d/fastestmirror.conf
RUN sed -i 's|#baseurl=http://mirror.centos.org/centos|baseurl=http://mirrors.ocf.berkeley.edu/centos|' /etc/yum.repos.d/*.repo
RUN yum update -y

RUN yum install -y wget unzip socat java-1.8.0-openjdk-headless
RUN sed -i 's|#networkaddress.cache.ttl=-1|networkaddress.cache.ttl=10|' /usr/lib/jvm/jre/lib/security/java.security
ENV JAVA_HOME /usr/lib/jvm/jre

WORKDIR /service

# 20-mysq.txt

# Set up mysql
RUN wget -q http://repo.mysql.com/mysql-community-release-el7-5.noarch.rpm && rpm -ivh mysql-community-release-el7-5.noarch.rpm && rm -f mysql-community-release-el7-5.noarch.rpm
RUN yum -y update
RUN yum -y install -y mysql-server
RUN mysql_install_db --user=mysql --datadir=/var/lib/mysql

VOLUME /var/lib/mysql

COPY init-mysql.sh .

# 30-tomcat.txt - AUTOGENERATED, DO NOT MODIFY MANUALLY
# Set up tomcat
RUN wget -q https://archive.apache.org/dist/tomcat/tomcat-8/v8.5.30/bin/apache-tomcat-8.5.30.tar.gz && tar --strip-components=1 -xf apache-tomcat-8.5.30.tar.gz && rm -f apache-tomcat-8.5.30.tar.gz && rm -rf webapps && mkdir -p webapps/ROOT
RUN echo 'export CATALINA_OPTS="$CATALINA_OPTS -Xms64m -Xmx256m -XX:MaxPermSize=64m"' > /service/bin/setenv.sh
ENV CATALINA_HOME /service

# 50-microservice.txt - AUTOGENERATED, DO NOT MODIFY MANUALLY

# Set up microservice

RUN wget -q -O nfvo-resmanagement.zip "https://nexus.onap.org/service/local/artifact/maven/redirect?r=snapshots&g=org.onap.vfc.nfvo.resmanagement&a=vfc-nfvo-resmanagement-deployment&v=LATEST&e=zip" && unzip -q -o -B nfvo-resmanagement.zip && rm -f nfvo-resmanagement.zip
# Set permissions
RUN find . -type d -exec chmod o-w {} \;
RUN find . -name "*.sh" -exec chmod +x {} \;
EXPOSE 8480



# 90-entrypoint.txt

RUN yum clean all

COPY instance-config.sh .
COPY instance-init.sh .
COPY instance-run.sh .
COPY instance-workaround.sh .
COPY docker-entrypoint.sh .
ENTRYPOINT /service/docker-entrypoint.sh

COPY LICENSE ./ONAP_LICENSE
