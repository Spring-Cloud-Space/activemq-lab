//: yulikexuan.cloud.jms.activemqlab.sender.GreetingSender.java


package yulikexuan.cloud.jms.activemqlab.sender;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import yulikexuan.cloud.jms.activemqlab.config.JmsConfig;
import yulikexuan.cloud.jms.activemqlab.domain.model.HelloArtemisMessage;

import java.util.UUID;


@Slf4j
@Component
public class GreetingSender {

    private final JmsTemplate jmsTemplate;

    @Autowired
    public GreetingSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Scheduled(initialDelay = 5000L, fixedDelay = 60 * 60000L)
    public void sendMessage() {

        log.info(">>>>>>> Sending a greeting message to Artemis ... ... ");

        HelloArtemisMessage message = HelloArtemisMessage.builder()
                .id(UUID.randomUUID())
                .message("Hello Artemis!")
                .build();

        this.jmsTemplate.convertAndSend(JmsConfig.GREETING_QUEUE_NAME, message);

        log.info(">>>>>>> Greeting message was sent to Artemis.");
    }

}///:~