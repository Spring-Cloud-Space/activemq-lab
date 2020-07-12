//: yulikexuan.cloud.jms.activemqlab.bootstrap.ActiveMQServerBootstrap.java


package yulikexuan.cloud.jms.activemqlab.bootstrap;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;


@Slf4j
public class ActiveMQServerBootstrap implements CommandLineRunner {

//    static final Supplier<Configuration> CONFIG_SUPPLIER =
//            ActiveMQServerBootstrap::configActiveMQServer;

    @Override
    public void run(String... args) throws Exception {

//        ActiveMQServer server = ActiveMQServers.newActiveMQServer(
//                CONFIG_SUPPLIER.get());
//
//        server.start();
    }

//    private static Configuration configActiveMQServer() {
//
//        Configuration config = null;
//
//        try {
//            config = new ConfigurationImpl()
//                    .setPersistenceEnabled(false)
//                    .setJournalDirectory("target/data/journal")
//                    .setSecurityEnabled(false)
//                    .addAcceptorConfiguration("invm", "vm://0");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//        return config;
//    }

}///:~