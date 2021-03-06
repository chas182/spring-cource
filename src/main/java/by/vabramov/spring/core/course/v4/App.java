package by.vabramov.spring.core.course.v4;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private Client client;
    private EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public void logEvent(Event event) {
        event.setMsg(client.getFullName() + " checked this event");
        eventLogger.logEvent(event);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springV4.xml");

        App app = context.getBean(App.class);
        Event event = context.getBean(Event.class);
        app.logEvent(event);

        event = context.getBean(Event.class);
        app.logEvent(event);
        event = context.getBean(Event.class);
        app.logEvent(event);
        event = context.getBean(Event.class);
        app.logEvent(event);
        event = context.getBean(Event.class);
        app.logEvent(event);
        event = context.getBean(Event.class);
        app.logEvent(event);

        context.close();
    }
}
