//: yulikexuan.cloud.jms.activemqlab.bootstrap.ActiveMQServerBootstrap.java


package yulikexuan.cloud.jms.activemqlab.bootstrap;


import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.artemis.core.config.Configuration;
import org.apache.activemq.artemis.core.config.impl.ConfigurationImpl;
import org.apache.activemq.artemis.core.server.ActiveMQServer;
import org.apache.activemq.artemis.core.server.ActiveMQServers;
import org.springframework.boot.CommandLineRunner;

import java.util.function.Supplier;


@Slf4j
public class ActiveMQServerBootstrap implements CommandLineRunner {

    static final Supplier<Configuration> CONFIG_SUPPLIER =
            ActiveMQServerBootstrap::configActiveMQServer;

    @Override
    public void run(String... args) throws Exception {

        ActiveMQServer server = ActiveMQServers.newActiveMQServer(
                CONFIG_SUPPLIER.get());

        server.start();
    }

    private static Configuration configActiveMQServer() {

        Configuration config = null;

        try {
            config = new ConfigurationImpl()
                    .setPersistenceEnabled(false)
                    .setJournalDirectory("target/data/journal")
                    .setSecurityEnabled(false)
                    .addAcceptorConfiguration("invm", "vm://0");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return config;
    }

}///:~