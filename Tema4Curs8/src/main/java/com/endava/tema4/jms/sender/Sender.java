package com.endava.tema4.jms.sender;

import com.endava.tema4.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${activemq.queue}")
    private String queue;

    public void send(Movie movie) {
        jmsTemplate.convertAndSend(queue, movie);
    }
}
