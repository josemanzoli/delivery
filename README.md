# README #

### What is this repository for? ###

* delivery
========
REST API that receives a simple Map with directions between points and gives you the shortest way calculating the price based on autonomy and price of gas

* Why Neo4j, SpringData and Jetty?
  Because the easy horizontal scalability of these frameworks and Neo4j fits in the routing problem like a charm! 

* 1.0

### How do I get set up? ###

* Summary of set up - 
  You will need a Java7, Maven 3, Eclipse
* Dependencies - 
  It is all inside the pom.xml, feel free to look at!
* Database configuration - 
  It is build with a embbeded database. Next step here is to put a RestGraphDatabase Server in some cloud around the world
* How to run tests - 
  mvn clean install
* Deployment instructions - 
  mvn jetty:run

### Contribution guidelines ###

* Writing tests - 
  Feel free to contribute
* Code review - 
  Feel free to contribute
* Other guidelines - 
  Feel free to help with guidelines

### Who do I talk to? ###

* Repo owner or admin
  josemanzoli
* Other community or team contact
  Well, it`s just me for now!

### How can I use the Rest API? ###

#### Using curl to Triangle Service ####

* Curl example: curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" -d '{"sideOne":2,"sideTwo":2,"sideThree":4}' http://localhost:8080/triangleService/classifyTriangle


#### Using curl to Delivery Service ####

First, save the Map
* **Curl example:**  curl -X PUT -H "Content-Type: application/json" -H "Accept: application/json" -d '{"stateName": "SP", "routes": [{"from" : "A", "to":"B", "distance":10.0},{"from" : "B", "to":"D", "distance":15.0},{"from" : "A", "to":"C", "distance":20.0},{"from" : "C", "to":"D", "distance":30.0},{"from" : "B", "to":"E", "distance":50.0},{"from" : "D", "to":"E", "distance":30.0}]}' http://localhost:8080/deliveryService/saveMap

Then see if the Map is saved
* **Curl example:** curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/deliveryService/findByState?state=SP

and the last thing and most important, get your shortest path
* **Curl example:** curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET 'http://localhost:8080/deliveryService/shortestPath?mapName=SP&sourceName=A&destinationName=D&price=2.5&autonomy=10.0' Using an app plugin for Chrome called PostMan, follow the screenshots!

If you want to clean up the database use this
* **Curl example:** curl -i -H "Accept: application/json" -X DELETE http://localhost:8080/deliveryService/removeCities


#### Using an app plugin for Chrome called PostMan, follow the screenshots! ####

* classify the Triangle
![classifyTriangleService](https://github.com/josemanzoli/delivery/blob/master/classifyTriangleService.png)


* Delivery services

* First, save the Map
![saveMap](https://github.com/josemanzoli/delivery/blob/master/saveMap.png)

* Then see if the Map is saved
![FindByState](https://github.com/josemanzoli/delivery/blob/master/findByState.png)

* and the last thing and most important, get your shortest path
![getShortestPath](https://github.com/josemanzoli/delivery/blob/master/getShortestPath.png)

* If you want to clean up the database use this
![removeCities](https://github.com/josemanzoli/delivery/blob/master/removeCities.png)
