package com.example.fibonacci.dataProcessing;

import com.example.fibonacci.InfoClass;
import com.example.fibonacci.exception.RequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.fibonacci.collections.FibonacciNumbersCash;

import java.util.List;

@Component
public class FibonacciSearch {
    private FibonacciNumbersCash hashMap;
    private Logger logger = LoggerFactory.getLogger(FibonacciSearch.class);
    @Autowired
    public void setHashMap(FibonacciNumbersCash hashMap){
        this.hashMap = hashMap;
    }
    public long fibonacciNumber(InfoClass uData) throws RequestException {
        long previousNumber = 0;
        if(hashMap.checkAvailability(uData)){
            previousNumber = hashMap.mapOutput(uData);
            logger.info("Get result from Map");
        }
        else {
            long nextNumber = 1;
            int ordinal_number = Integer.parseInt(uData.getNumber());
            if (ordinal_number < 1) {
                throw new RequestException("Incorrect param");
            }
            if (ordinal_number == 1) {
                return 0;
            }
            for (int i = 1; i < ordinal_number; i++) {
                long sum = previousNumber + nextNumber;
                previousNumber = nextNumber;
                nextNumber = sum;
            }
            hashMap.mapInput(uData, previousNumber);
            logger.info("Input result to Map");
        }
        return previousNumber;
    }
    public long searchMaxNumber(List<Long> uList){
        long max = 0;
        if(!uList.isEmpty()){
            max = uList.stream().mapToLong(Long::longValue).max().getAsLong();
        }
        return max;
    }
    public long searchMinNumber(List<Long> uList){
        long min = 0;
        if(!uList.isEmpty()){
            min = uList.stream().mapToLong(Long::longValue).min().getAsLong();
        }
        return min;
    }
    public double averageValue(List<Long> uList){
        double average = 0;
        if(!uList.isEmpty()){
            average = uList.stream().mapToLong(Long::longValue).average().getAsDouble();
        }
        return average;
    }
}

