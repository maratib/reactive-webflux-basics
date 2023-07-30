# Spring Boot 3 Reactive Programming with Webflux Starter
Version : 3.0.6, Java : 11, JUnit : 5  

## Java 8
- Lambdas
- Completable Future
- Streams API

## Two programming paradigm :-

### Imperative Programming
- Synchronous and blocking
- Traditional Spring MVC model
- Thread per request model.
- No back pressure

![Reactive Programming](/img/reactive-pro1.png)
### Reactive Programming 
- Asynchronous and non blocking.
- Data flow as an Event/Message Driven stream.
- Functional Style Code.
- Back Pressure on data streams.


### Data flow as an Event Driven Stream.
- onNext(item) -> Data Stream Event.
- onComplete() -> Completion/Success Event.
- onError(Throwable t) -> Error Event.

### Functional Style Code
- Similar to Streams API.
- Easy to work with Lambdas.

### Back Pressure on Data Streams
Reactive programming supports Back Pressure, if the datasource producing  more data than we expected then there is a way for the application to provide the feedback to the datasource stating you need to slow down until I catch up. This option is handy when it comes to build stable systems using reactive programming.

### Reactive Stream Specification
It is four interfaces as bellow :-
- `Publisher`
    - Data producers (e.g Databases, External Services etc.)
    ```java
        public interface Publisher<T> {
            public void subscribe(Subscriber<? super T> s);
        }
    ```
- `Subscriber`
    - Data consumers 
    ```java
        public interface Subscriber<T> {
            public void onSubscribe(Subscription s);
            public void onNext(T t);
            public void onError(Throwable t);
            public void onComplete();
        }
    ```

- `Subscription`
    - Use to Subscribes to the Publisher
    ```java
        public interface Subscription {
            public void request(long n);
            public void cancel(T t);
        }
    ```
- Processor
    - This interface is nothing but a combination of Subscriber and Publisher.
    ```java
        public interface Processor<T, R> extends Subscriber<T>, Publisher<R> {

        }
    ```


All of these interfaces talk to each other in order for whole reactive stream to flow. 
React programming uses pub/sub model.

### Pubsher/Subscriber or Pub/Sub Event Flow
Lets say Publishers is a datasource and it has 100 records, after subscription you send request with value of 2 means return only 2 record hence doing Back Pressure management here.

![Pub/Sub Event Flow](/img/img2.png)
### Cancelling the subscription
Cancelling means to let the Publisher knows that it should not send the data to us.
![Pub/Sub Event Cancelling](/img/img3.png)


### Reactive Libraries
The libraries that implements the Reactive Streams Specifications (Publisher, Subscriber, Subscription and Processor) are called Reactive Libraries, a few commonly used libraries for this purpose are :-
- RxJava
- Reactor
- Flow class - JDK 9

### Reactor or `Project Reactor`
- Built and maintained by `Pivotal`.
- Recommended Library to work with Spring Boot, it comes by default in Spring Boot.
- We are going to explore the followings :-
    - reactor-core
    - reactor-test
    - reactor-netty
### Reactor Core
- 
## Resources : 

[Reactive Programming](https://youtu.be/IGekSCoJav0)
