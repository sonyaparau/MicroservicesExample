package com.example.microservice.service;


import com.example.microservice.utils.MessageSender;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Greeting service
 */
@Service
@Transactional
@AllArgsConstructor(onConstructor_ = @Autowired)
public class GreetingService {

    /**
     * Greets the user politely and sends the event to the queue.
     *
     * @param name of the user
     * @return Hi + name
     */
    public String sayHi(@NonNull final String name) {
        String greeting = "Hi " + name;
        MessageSender.sendMessage(greeting);
        return greeting;
    }
}
