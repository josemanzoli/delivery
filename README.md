# README #

### What is this repository for? ###

* delivery
========
REST API that receives a simple Map with directions between points and gives you the shortest way calculating the price based on autonomy and price of gas
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
  zehdamoto
* Other community or team contact
  Well, it`s just me for now!

### How can I use the Rest API? ###

* Using an app plugin for Chrome called PostMan, follow the screenshots!
![saveMap](https://github.com/zehdamoto/delivery/blob/master/saveMap.png)

![FindByState](https://github.com/zehdamoto/delivery/blob/master/findByState.png)

![getShortestPath](https://github.com/zehdamoto/delivery/blob/master/getShortestPath.png)

*If you want to clean up the database use this
![removeCities](https://github.com/zehdamoto/delivery/blob/master/removeCities.png)
