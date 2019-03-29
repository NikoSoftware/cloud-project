package net.xiaomotou.user.mq;

import net.xiaomotou.user.service.impl.CustomerLoginServiceImpl;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemListener {

    @Autowired
    CustomerLoginServiceImpl customerLoginService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "net.xiaomotou",durable = "true"),
            exchange = @Exchange(
                    value = "net.xiaomotou.cloud-project",
                    type = ExchangeTypes.TOPIC
            ),
            key = {"#.#"}))
    private void removeUser(String message){
        customerLoginService.removeUser(message);
    }
}
