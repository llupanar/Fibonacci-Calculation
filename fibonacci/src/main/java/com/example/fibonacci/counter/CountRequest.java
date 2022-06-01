package com.example.fibonacci.counter;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class CountRequest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountRequest.class);
    static private int temp = 0;
    synchronized public void incrementTemp () {
        temp++;
    }
    @GetMapping ("/count")
    synchronized public int getTemp () {
        LOGGER.info("Сount: " + temp);
        return temp;
    }
}
