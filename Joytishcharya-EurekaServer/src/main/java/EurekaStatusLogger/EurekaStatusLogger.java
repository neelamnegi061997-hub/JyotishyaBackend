package EurekaStatusLogger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EurekaStatusLogger {

    private static final Logger log = LoggerFactory.getLogger(EurekaStatusLogger.class);

    @EventListener
    public void handleInstanceCanceled(EurekaInstanceCanceledEvent event) {
        log.error("SERVICE DOWN ❌ : {} - {}",
                event.getAppName(), event.getServerId());
    }

    @EventListener
    public void handleInstanceRegistered(EurekaInstanceRegisteredEvent event) {
        log.info("SERVICE UP ✅ : {}",
                event.getInstanceInfo().getAppName());
    }
}
