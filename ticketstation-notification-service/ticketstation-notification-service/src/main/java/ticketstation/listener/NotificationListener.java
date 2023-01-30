package ticketstation.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ticketstation.model.User;

@Component
public class NotificationListener {

    public NotificationListener() {
    }

    @RabbitListener(queues = "ticketstation.notification")
    public void notificationListener(User user){
        System.out.println("user:" + user.getEmail());
    }


}
