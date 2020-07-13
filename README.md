# Apache ActiveMQ Lab

## Development API

- ### Artemis Core API
  - [Artemis API](https://activemq.apache.org/components/artemis/documentation/javadocs/javadoc-latest/)
  - [artemis.core.config](https://access.redhat.com/webassets/avalon/d/red-hat-jboss-enterprise-application-platform/7.0.0/javadocs/org/apache/activemq/artemis/core/config/package-summary.html)
  - [artemis.core.server](https://access.redhat.com/webassets/avalon/d/red-hat-jboss-enterprise-application-platform/7.0.0/javadocs/org/apache/activemq/artemis/core/server/package-summary.html)

- ### Spring Configuration API
  - [SimpleAsyncTaskExecutor](https://docs.spring.io/spring/docs/current/javadoc-api/)
  - [MappingJackson2MessageConverter](https://docs.spring.io/spring/docs/current/javadoc-api/)

- ### Spring JMS API
  - [JmsTemplate](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/jms/core/JmsTemplate.html)
  - [JmsListener](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/jms/annotation/JmsListener.html)
  - [Payload](https://docs.spring.io/spring/docs/current/javadoc-api/)
  - [Headers](https://docs.spring.io/spring/docs/current/javadoc-api/)

## Local Artemis Docker Container Set UP

### Run Docker Container
- For Windows 10: 
  - ``` winpty docker run -it --rm -p 8161:8161 -p 61616:61616 vromero/activemq-artemis ```
- For Linux: 
  - ``` docker run -it --rm -p 8161:8161 -p 61616:61616 vromero/activemq-artemis ```

### Spring Boot Set Up for Artemis

- [activemq-artemis-docker](https://github.com/vromero/activemq-artemis-docker)
- [The Artemis Console](http://127.0.0.1:8161/)
- application.yml
    ``` 
    spring:
      artemis:
        user: artemis
        password: simetraehcapa
    ```