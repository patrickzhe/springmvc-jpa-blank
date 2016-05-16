**This project is obsolete!**
JPA : (Java Persistence API)

Definition:
    Wrapped Hibernate/JDO/ ... .
    Support Mysql/Oracle/Postgres ...
    Total Object relational

Example:
    POJO denfinition , annotation based, include (@Column, @Entity, @Table ... ) and mapped object
    Repository denfinition extends JpaRepository

    Naming Search
        by field
            support and, or , isnull, notnull, like
            support range(between), ge, le ... first , top
            support page, sort
            support related objects search

    by @Query
        support hsql  using object
        support native sql
    @Trsactional
        trsaction management support, naturly support

    Dynamic Search
        using specification (critira build)
        using EntityManager create query

QueryDsl integration .....

Web App Example Using Spring MVC & Spring Data JPA

for MySQL(default)

$ mvn clean test -P mysql
$ mvn clean eclipse:clean eclipse:eclipse -P mysql

for PostgreSQL

$ mvn clean test -P postgresql
$ mvn clean eclipse:clean eclipse:eclipse -P postgresql

for H2

$ mvn clean test -P h2
$ mvn clean eclipse:clean eclipse:eclipse -P h2

for HSQLDB

$ mvn clean test -P hsqldb
$ mvn clean eclipse:clean eclipse:eclipse -P hsqldb

tested only on Tomcat7 (not use JTA)

$ mvn clean tomcat7:run -P h2
access http://localhost:8080/springmvc-jpa-blank

