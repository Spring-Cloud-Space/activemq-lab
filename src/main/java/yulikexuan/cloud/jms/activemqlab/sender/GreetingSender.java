//: yulikexuan.cloud.jms.activemqlab.sender.GreetingSender.java


package yulikexuan.cloud.jms.activemqlab.sender;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import yulikexuan.cloud.jms.activemqlab.config.JmsConfig;
import yulikexuan.cloud.jms.activemqlab.domain.model.HelloArtemisMessage;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.UUID;


@Slf4j
@Component
public class GreetingSender {

    private final JmsTemplate jmsTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public GreetingSender(JmsTemplate jmsTemplate, ObjectMapper objectMapper) {
        this.jmsTemplate = jmsTemplate;
        this.objectMapper = objectMapper;
    }

    @Scheduled(initialDelay = 60000L * 60L, fixedDelay = 60000L * 60L)
    public void sendMessage() {

        // log.info(">>>>>>> Sending a greeting message to Artemis ... ... ");

        HelloArtemisMessage message = HelloArtemisMessage.builder()
                .id(UUID.randomUUID())
                .message("Hello Artemis!")
                .build();

        this.jmsTemplate.convertAndSend(JmsConfig.GREETING_QUEUE_NAME, message);

        // log.info(">>>>>>> Greeting message was sent to Artemis.");
    }

    @Scheduled(initialDelay = 7000L, fixedDelay = 10000L)
    public void sendAndReceiveMessage() throws JMSException {

        final HelloArtemisMessage greetingMessage = HelloArtemisMessage.builder()
                .id(UUID.randomUUID())
                .message("Hello ??? ???")
                .build();

        Message receivedMsg = this.jmsTemplate.sendAndReceive(
                JmsConfig.GREETING_REPLYABLE_QUEUE_NAME,
                session -> {
                        try {
                            log.info("\r\n>>>>>>> Sending a greeting message to Artemis ... ... \r\n");
                            Message message = session.createTextMessage(
                                    objectMapper.writeValueAsString(greetingMessage));
                            message.setStringProperty("_type",
                                    HelloArtemisMessage.class.getName());
                            return message;
                        } catch (JsonProcessingException e) {
                            throw new JMSException(e.getMessage());
                        }});

        log.info("\r\n\t<<<<<<< Receiving reply message from Artemis: {}\r\n",
                receivedMsg.getBody(String.class));
    }

}///:~