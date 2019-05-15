package com.endava.tema4.jms.receiver;

import com.endava.tema4.model.Movie;
import com.endava.tema4.model.MovieMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @Autowired
    private MovieMessage movieMessage;

    @JmsListener(destination = "${activemq.queue}", containerFactory = "jmsListenerContainerFactory")
    public void receive(Movie movie) {
        System.out.println("Received Message: " + movie);
        movieMessage.addMovie(movie);
    }
}
