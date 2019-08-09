Setup:

    Build Gradle:
        ex. gradle build

    Start Tomcat:
        ex. gradle bootrun

    Use:
       GET localhost:8070/users or localhost:8070/users/ or localhost:8070/users/{ID} ex.  localhost:8070/users/2
       POST localhost:8070/users/ with JSON body {"ID":2, "firstName":"Zeta", "lastName":"Smith"}
       DELETE localhost:8070/users/{ID} ex. localhost:8070/users/2


Port number is 8070
    Configure port number in src/main/resources/application.properties