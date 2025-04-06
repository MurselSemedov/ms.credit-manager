package com.mursalsamad.queue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mursalsamad.model.request.CustomerQueueRequest;
import com.mursalsamad.service.abstraction.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class CustomerListener {

    private final CustomerService customerService;
    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "customer")
    public void consume(String message) {
        try {
            var data = objectMapper.readValue(message, CustomerQueueRequest.class);
            customerService.testRabbitMQ(data);
        } catch (JsonProcessingException e) {
            log.error("Action Log : consume().error message invalid format : {}", message);
        }catch (Exception exception){
            throw new RuntimeException();
        }
    }
}
