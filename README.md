# spring-boot-hystrix
This is an application which is used to develop using Spring Boot Hystrix and Feign libraries.

---------------------------------------------------------------------------------------------------------------------------------------
What is Fault Tolerance ?
-------------------------

=> What tollerent of your system have for a perticuler fault, i.e called fault Tolerance. (How many types of fault tolerate)

What is Resilience ?
--------------------

=> How many fault your system tolerate, i.e called Resilience. (How many fault tolerate)

Refresh is not the soluation of slow network. So please don't do this again and again

: With out Circuit Breaker How to work webserver ? OR What happend if we are not used Circuit Breaker ? 
-------------------------------------------------------------------------------------------------------

=> In our microservice architecture we have collection of loosely coupled services. 
The microservices are communicate One to others through Resttemplate Or Feign call in Spring Boot architecture.

Souppose I have three microservices Like : 

movies-service : It's content all movies informations.
user-service : It's content all users informations.
rating-service : It's content movies rating informations, which are given by users.

Now we find movies list base on user rating and contents :
So our movies-service call two services user-service & rating-service.

In this senario if rating-service is down then our total application will be slow or down, If we are not used Circuit Breaker here.

Becouse when users send multiple request to movies-service webserver created seperated Thread of every request. movies-service internally called rating-service but rating-service is down so requestes are not process and Thread are closed. 
Every webserver(& JVM) have Thread pull size(We can manully change the size), If the Thread pull size is cross then our application will be slow and the outhers normal services waithing for release the Threads to process user request.

That's problem we can handle using Circuit Breaker. When multiple request came from users to movies-service. movies-service check rating-service working or not (2-3 times, we can also define the numbers), If it's not working then it's break the circuit to avoid to create unnecessary Threads.

Note : Resttemplate time out functionality is not handle this type of senario.

----------------------------------------------------------------
: What are the Circuit Breaker Parameters :
----------------------------------------------------------------
=> What does the circuit trip ?
1) Last n requests to consider for the decision.
2) How many of those should fail ?
3) Timeout duration.

When does the circuit un-trip or normal ?
-----------------------------------------
1) How long after a circuit trip to try again ?

Example :
---------

Last n requests to consider for the decision : 5
How many of those should fail : 3
Timeout duration : 2s
How long to wait (Sleep window): 10s
----------------------------------------------------------------

:	What is Hystrix ? 
-------------------
=> 
1) Hystrix is an Open Source library originally created by Netflix
2) Implements circuit breaker pattern so you don't have to write Networking/Thread Programming
3) Give it the configuration params and it does the work.
4) Works well with Spring Boot.

Note : At this movement it's not developed for Reactive Programming.

: Hystrix Parameters :
----------------------

  @HystrixCommand(fallbackMethod = "getMovieRatingsFallback", commandProperties = {
    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")	
  })

@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")

=> Wait for 2 seconds if doesn't get response then break the circuit.

@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "6")

=> Get last 6 request to calculate to failed percentages.

@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")

=> Break the circuit if failed percentage above 50%

@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")	

=> It's mean how long our circuit breaker is sleep. Here waiting 5 second after that it's send the request again.

---------------------------------------------------------------------------------------------------------------------------
<img src="https://github.com/90rajibgarai/doc-important-links/blob/master/Architectures/Hystrix/circuit_breaker.png">

---------------------------------------------------------------------------------------------------------------------------
OUT PUT :
---------
<img src="https://github.com/90rajibgarai/doc-important-links/blob/master/Architectures/Hystrix/Output_1.png">
<img src="https://github.com/90rajibgarai/doc-important-links/blob/master/Architectures/Hystrix/Output_2.png">

