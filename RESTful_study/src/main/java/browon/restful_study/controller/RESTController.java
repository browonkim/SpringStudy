package browon.restful_study.controller;

import browon.restful_study.domain.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RESTController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam HashMap<String, String> paraMap){
        ArrayList<String> a = new ArrayList<>(paraMap.values());
        String allString = "";
        for(String i: a){
            allString += i;
        }
        return new Greeting(counter.incrementAndGet(), String.format(template, allString));
    }
}
