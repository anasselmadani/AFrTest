# AirFranceTest

to build project from sources : go to project directory launch mvn install then you will find a jar on target directory with name userManager-0.0.1-SNAPSHOT.jar go to directory and run: java -jar userManager-0.0.1-SNAPSHOT.jar or if you use IDE maven plugin run mvn spring-boot:run .

the application represent a Rest api for manipulate Users contain tow calls :

-get a user by his id by HTTP request GET /v1/user/{id}

-creat a user by HTTP request POST /v1/user/add with body Model { "name": "string", "birthDate": "2022-11-22", "country": "string", "gender": "MALE", "phoneNumber": "string" }

there are 3 type of gender : -MALE -FEMALE -OTHER

you can test and more see details of the api by Swager localement by vesiting http://localhost:8080/swagger-ui.html.
