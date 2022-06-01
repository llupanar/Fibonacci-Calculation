package com.example.fibonacci.collections;
import com.example.fibonacci.InfoClass;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class FibonacciNumbersCash {
    private final Map<InfoClass,Long> hashMap = new HashMap<>();
    public boolean checkAvailability(InfoClass key) {
        return hashMap.containsKey(key);
    }
    public void mapInput(InfoClass key, Long value){
        hashMap.put(key,value);
    }
    public Long mapOutput(InfoClass key){
        return hashMap.get(key);
    }
}
