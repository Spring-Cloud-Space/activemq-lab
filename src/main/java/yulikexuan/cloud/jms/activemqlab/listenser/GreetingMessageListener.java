//: yulikexuan.cloud.jms.activemqlab.listenser.GreetingMessageListener.java


package yulikexuan.cloud.jms.activemqlab.listenser;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import yulikexuan.cloud.jms.activemqlab.config.JmsConfig;
import yulikexuan.cloud.jms.activemqlab.domain.model.HelloArtemisMessage;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import java.util.UUID;


@Slf4j
@Component
@AllArgsConstructor
public class GreetingMessageListener {

    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.GREETING_QUEUE_NAME)
    public void listen(@Payload HelloArtemisMessage helloArtemisMessage,
                       @Headers MessageHeaders headers, Message message) {

//        log.info("------- Message Received ------- ");
//        log.info("\t>>>>>>> Message: {}", helloArtemisMessage);
//
//        // throw new RuntimeException(">>>>>>> For testing redelivery ... ");
    }

    @JmsListener(destination = JmsConfig.GREETING_REPLYABLE_QUEUE_NAME)
    public void listenForHello(
            @Payload HelloArtemisMessage helloArtemisMessage,
            @Headers MessageHeaders headers,
            Message message,
            org.springframework.messaging.Message springMessage) throws JMSException {

        log.info("\r\n------- Message Received ------- \r\n\t>>>>>>> " +
                "Message: {}\r\n", helloArtemisMessage);

        HelloArtemisMessage replyMsg = HelloArtemisMessage.builder()
                .id(UUID.randomUUID())
                .message("Artemis!")
                .build();

        jmsTemplate.convertAndSend(
                (Destination) springMessage.getHeaders().get("jms_replyTo"),
                "got it!");

        // this.jmsTemplate.convertAndSend(message.getJMSReplyTo(), replyMsg);

        // throw new RuntimeException(">>>>>>> For testing redelivery ... ");
    }

}///:~