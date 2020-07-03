//: yulikexuan.cloud.jms.activemqlab.domain.model.HelloArtemisMessage.java


package yulikexuan.cloud.jms.activemqlab.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;


@Data
@NoArgsConstructor
@Builder @AllArgsConstructor
public class HelloArtemisMessage implements Serializable {

    static final long serialVersionUID = -6703826490277916847L;

    private UUID id;
    private String message;

}///:~