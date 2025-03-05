package com.MyGreetingApp.backend.controller;

import com.MyGreetingApp.backend.model.Greeting;
import com.MyGreetingApp.backend.model.User;
import com.MyGreetingApp.backend.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/greetings")
public class GreetingController {

    @Autowired
    private IGreetingService greetingService;

    @GetMapping
    public String getAllGreetings(){
        return "List of all the greetings";
    }

    @PostMapping("/add")
    public String createNewGreeting(){
        return "Creating new Greeting...";
    }

    @GetMapping("g/id/{myId}")
    public String getGreetingById(@PathVariable long myId){
        return "greeting  id: "+myId;
    }

    @PutMapping("u/id/{myId}")
    public String updateGreetingById(@PathVariable long myId){
        return "Greeting updated with id: "+myId;
    }

    @DeleteMapping("d/id/{myId}")
    public String removeGreetingById(@PathVariable long myId){
        return "Remove Greeting with id :"+myId;
    }

    @GetMapping("/hello")
    public String sayHello(){
        return greetingService.sayHello();
    }

    @GetMapping("/greet")
    public ResponseEntity<Greeting> greet(
            @RequestParam(value = "firstName", defaultValue = "") String firstName,
            @RequestParam(value = "lastName", defaultValue = "") String lastName) {

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);

        return ResponseEntity.ok(greetingService.addGreeting(user));
    }

    
}
