package com.mursalsamad.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    private final String customerQueue;
    private final String customerExchange;
    private final String customerRoutingKey;
    private final String customerDLQueue;
    private final String customerDLExchange;
    private final String customerDLRoutingKey;


    public RabbitMQConfig(@Value("${rabbitmq.queue.customer}") String customerQueue,
                          @Value("${rabbitmq.queue.customer-dl}") String customerDLQueue){
        this.customerQueue = customerQueue;
        this.customerExchange = customerQueue + "_exchange";
        this.customerRoutingKey = customerQueue + "_key";
        this.customerDLQueue = customerDLQueue;
        this.customerDLExchange = customerDLQueue + "_exchange";
        this.customerDLRoutingKey = customerDLQueue + "_key";
    }

    @Bean
    public Queue customerQueue(){
        return QueueBuilder.durable(customerQueue)
                .deadLetterExchange(customerDLExchange)
                .deadLetterRoutingKey(customerDLRoutingKey)
                .build();
    }

    @Bean
    public Queue customerDLQueue(){
        return QueueBuilder.durable(customerDLQueue).build();
    }

    @Bean
    public DirectExchange customerExchange(){
        return new DirectExchange(customerExchange);
    }

    @Bean
    public DirectExchange customerDLExchange(){
        return new DirectExchange(customerDLExchange);
    }

    @Bean
    public Binding customerRoutingKey(){
        return BindingBuilder.bind(customerQueue()).to(customerExchange()).with(customerRoutingKey);
    }

    @Bean
    public Binding customerDLRoutingKey(){
        return BindingBuilder.bind(customerDLQueue()).to(customerDLExchange()).with(customerDLRoutingKey);
    }

}
