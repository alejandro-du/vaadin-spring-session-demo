# vaadin-spring-session-demo
A Spring Boot application with a Vaadin front-end that shows how to use Spring Session to replace the standard HttpSession with Redis.

## Running the demo

1. [Download, install, and start Redis](http://redis.io/download) (this demo uses the default configuration).
2. `git clone https://github.com/alejandro-du/vaadin-spring-session-demo.git`
3. `cd vaadin-spring-session-demo`
4. `mvn package spring-boot:run`
5. Browse <http://localhost:8080>

Spring Session with Redis doesn't work out-of-the-box with Vaadin. The issue is that the objects in the session are sent to Redis before the `VaadinSession` instance has been fully configured which causes an old version of the instance to be persisted in Redis. The problem resides in the `RedisOperationsSessionRepository` class which unfortunatelly doesn't have enough extension options to fix the problem with inheritance for example.

In order to overcome this, I found [this project](https://github.com/khauser/microservices4vaadin) that included a "dirty hack" that fixes the issue. The hack requires you to use a [modified version](https://raw.githubusercontent.com/khauser/microservices4vaadin/master/microservices/frontend/src/main/java/org/springframework/session/data/redis/RedisOperationsSessionRepository.java) of the `RedisOperationsSessionRepository` class placed in the same package as the original one.

This "hack", inspired the [spring-session-redis](https://vaadin.com/directory#!addon/spring-session-redis) Vaadin add-on that includes a filter that does the trick without having to replace any class from Spring Session.

Thanks to [Karsten Ludwig Hauser](https://github.com/khauser) for the original idea!
