Library Management Portal Part 2: Using JavaEE service layer , introduction of security layer to the application layer by integrating JPA model with service layer.
Project Summary:
The purpose of this project is to get experience on JavaEE service layer , introduction of security layer to the application layer by integrating JPA model with service layer.This assignment consists of 1 Maven Web Application project using the Glassfish application server, and incorporates malinkil-mp3 domain model as the persistence layer using the EclipseLink JPA implementation and MySQL database connectivity. This project demonstrates the security authorization and authentication part related to library management. The project consists of four packages entity, security, security.ejb and servlet. The web package consists of the servlets which handles the url pattern to display the appropriate page. The DatabasePopulator uses instance of service class through EJB to create entities.The roles for different users are:
Customer:can view list of books he has taken ,the return and taken day and how many days are due
Vendor: can view the list of books ordered
 
Design:
This assignment consists of 1 Maven Web Application project using the Glassfish application server, and incorporates malinkil-mp3 domain model as the persistence layer using the EclipseLink JPA implementation and MySQL database connectivity. This project demonstrates the security authorization and authentication part related to library management. The project consists of four packages entity, security, security.ejb and servlet. I have not used two different tables but rather I have implemented a single table user_info which itself has links for user and roles.The web package consists of the servlets which handles the url pattern to display the appropriate page.The home page consists of login credentials , if the user enters the appropriate credentials the relevant page appears that is either vendor or customer or else with wrong credential will display invalid username or password.
Development Insights:
This project gave a good understanding and experience  to explore security layer with entities. There were some difficulty in creating the glassfish security realm and also in building some dependencies ie commons codec.Creating security constraints in web.xml was completely new to me and gave a good experience in understanding the security roles.
Requirements:
 Import the project malinkil-mp4
 goto servers-> right click glassfish server -> Domain Admin Console–>Goto security-Realm create itmd4515->add following  :

 

Snapshots:Outputs
HashPassword Generation:
 





Basic Portal web page:
Login Credentials: Customer : Username: Mithun Password: Mithun
                                   Vendor : Username :Mith  Password:Mith
 
 
User:Customer
 
Logout : Redirect to status page followed by home page once you click on login link.
 
User : Vendor
 
 
 
 
