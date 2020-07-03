//: yulikexuan.cloud.jms.activemqlab.config.JmsConfig.java


package yulikexuan.cloud.jms.activemqlab.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;


@Configuration
public class JmsConfig {

    @Bean
    public MessageConverter messageConverter() {

        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();

        converter.setTargetType(MessageType.TEXT);
        // This property needs to be set in order to allow for converting from
        // an incoming message to a Java object.
        converter.setTypeIdPropertyName("_type");

        return converter;
    }

//    private ObjectMapper JsonObjectMapperSupplier() {
//
//        ObjectMapper objMapper = new ObjectMapper();
//
//        objMapper.registerModule(new JavaTimeModule());
//        objMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//        objMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
//        objMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
//        objMapper.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
//
//        return objMapper;
//    }

}///:~