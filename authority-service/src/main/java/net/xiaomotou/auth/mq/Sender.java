package net.xiaomotou.auth.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class Sender {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void send(String userName) {
        String message =  userName;
        System.out.println("Sender  " + message);
        rabbitTemplate.convertAndSend( "net.xiaomotou.cloud-project","net.xiaomotou", message);
    }

}
