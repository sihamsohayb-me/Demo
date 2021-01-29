package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping(value = "/getUser/{id}")
    public User user(@PathVariable String id){
        RestTemplate restTemplate = new RestTemplate();
        final String uri = "https://jsonplaceholder.typicode.com/todos/" + id;
        return restTemplate.getForObject(uri, User.class);
    }

    @GetMapping(value = "/getUserB/{id}")
    public List<User> users(@PathVariable String id){
        RestTemplate restTemplate = new RestTemplate();
        final String uri = "https://jsonplaceholder.typicode.com/todos/";
        User[] usersList = restTemplate.getForObject(uri, User[].class);
      //  List<User> users = Arrays.asList(usersList);
        Stream<User> usersStream =  Arrays.asList(usersList).stream();
        List<User> users = usersStream.filter(u -> u.getId() == Integer.parseInt(id)).collect(Collectors.toList());
        return users;
    }

    @GetMapping(value = "/getUserIDs")
    public List<User> usersId(){
        RestTemplate restTemplate = new RestTemplate();
        final String uri = "https://jsonplaceholder.typicode.com/todos/";
        User[] usersList = restTemplate.getForObject(uri, User[].class);
         List<User> users = Arrays.asList(usersList);
      //  Stream<User> usersStream =  Arrays.asList(usersList).stream();
      //  List<Integer> users = usersStream.map(User::getId).collect(Collectors.toList());
        return users;
    }
}
