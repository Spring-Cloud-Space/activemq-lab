//: yulikexuan.cloud.jms.activemqlab.listenser.GreetingMessageListener.java


package yulikexuan.cloud.jms.activemqlab.listenser;


import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import yulikexuan.cloud.jms.activemqlab.config.JmsConfig;
import yulikexuan.cloud.jms.activemqlab.domain.model.HelloArtemisMessage;

import javax.jms.Message;


@Slf4j
@Component
public class GreetingMessageListener {

    @JmsListener(destination = JmsConfig.GREETING_QUEUE_NAME)
    public void listen(@Payload HelloArtemisMessage helloArtemisMessage,
                       @Headers MessageHeaders headers, Message message) {

        log.info("------- Message Received ------- ");
        log.info("\t>>>>>>> Message: {}", helloArtemisMessage);

        // throw new RuntimeException(">>>>>>> For testing redelivery ... ");
    }

}///:~