package com.example.fibonacci;
import com.example.fibonacci.dataProcessing.FibonacciSearch;

import com.example.fibonacci.exception.RequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import com.example.fibonacci.counter.CountRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@RestController
public class Controller {
    private CountRequest countTemp = new CountRequest();
    private FibonacciSearch states;
    private static final Logger ErrorLogger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    public void setter(FibonacciSearch newService){this.states = newService;}
    private static final String resultMessage = "Fibonaccy[%s] is %d";
    private static final String resultListMessage = "Fibonaccy[%s] is %d\n";

    @GetMapping("/fibon")
    public String get( @RequestParam(value = "number") String number) throws RequestException{
        if(Objects.equals(number, null)){
            throw new RequestException("Incorrect param");
        }
        countTemp.incrementTemp();
        countTemp.getTemp();
        InfoClass uData = new InfoClass(number);
        return String.format(resultMessage,uData.getNumber(),states.fibonacciNumber(uData));
    }

    @PostMapping("/post")
    public ResponseEntity<?> post(@RequestBody List<InfoClass> list){
        List<Long> res = new ArrayList<>();
        List<String> res_output = new ArrayList<>();
        list.forEach((element)->{
            res_output.add(String.format(resultListMessage,element.getNumber(),states.fibonacciNumber(element)));
            res.add(states.fibonacciNumber(element));
        });
        double OVERAGE = states.averageValue(res);
        long MAX = states.searchMaxNumber(res);
        long MIN = states.searchMinNumber(res);
        return new ResponseEntity<>(res_output + "\nMax = "+MAX + "\nMin = "+ MIN+"\nOverage = "+ OVERAGE, HttpStatus.OK);
    }

}