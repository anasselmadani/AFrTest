# AFrTest

to build project from sources : go to project directory launch mvn install then you will find a jar on target directory with name userManager-0.0.1-SNAPSHOT.jar go to directory and run: java -jar userManager-0.0.1-SNAPSHOT.jar or if you use IDE maven plugin run mvn spring-boot:run .

the application represent a Rest api for manipulate Users contain tow calls :

-get a user by his id by HTTP request GET /v1/user/{id}

-creat a user by HTTP request POST /v1/user/add with body Model { "name": "string", "birthDate": "2022-11-22", "country": "string", "gender": "MALE", "phoneNumber": "string" }

there are 3 type of gender : -MALE -FEMALE -OTHER
exemples of calls :
<img width="960" alt="ECC2" src="https://user-images.githubusercontent.com/54291213/203402411-e0296b3e-afe4-4513-9ee9-3774a86015a9.png">

<img width="960" alt="SSSSSSSSSSSSSSSSSSSSSSS" src="https://user-images.githubusercontent.com/54291213/203606090-696e1995-6723-4164-be22-45be5fa92096.png">


<img width="959" alt="ECCC1" src="https://user-images.githubusercontent.com/54291213/203402461-d93cbd54-f3e6-4f59-9558-eaade15036b0.png">

<img width="960" alt="LAST" src="https://user-images.githubusercontent.com/54291213/203402480-1f1eecad-3f24-46b9-9c86-ba0cd2cd26db.png">



you can test and more see details of the api by Swager localement by vesiting http://localhost:8080/swagger-ui.html.
