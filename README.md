# cinema-project

### Description:

An example of a REST WebServer developed using Spring Framework (MVC and Security).

This application represents shop, where users can buy tickets for the available movies.

- Main idea to create application is to show knowledge of Spring Core, Security and MVC, 
- Hibernate, Java Core, as well as REST architectural style.
- Application implements 3 layer architecture with controller, service and DAO layers.
- Each user need to login in order to access application.
- It implements Authentication using an existing DataSource configuration. Database used is MySQL.
- Each user has list of roles that define list of resources accessible for this user.
- JSON format is used to transmit data in a web application.

### Technologies:
- Java (JDK version 11)
- MySQL database
- Tomcat - web-server (ver 9.0.55)
- Hibernate
- Spring (Spring Core, Spring Security, Spring Web)
- JSON
- Maven

### To run this app locally:
- Fork this project to your repository
- Clone project locally and open it in IntelliJ IDEA
- Configure Tomcat
- Create a schema in DB
- Change properties for the following line in db.properties file:

1. db.driver=YOUR_DRIVER
2. db.url=YOUR_URL
3. db.user=YOUR_NAME
4. db.password=YOUR_PASSWORD

- And finally run application on your computer. 
- You could use Postman API to send Get, Post, Delete, Put requests to the webserver.
