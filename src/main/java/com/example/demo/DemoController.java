package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping(value = "/getUser/{id}")
    public User user(@PathVariable String id){
        RestTemplate res = new RestTemplate();
        String uri = "https://jsonplaceholder.typicode.com/todos/" + id;
        return res.getForObject(uri, User.class);
    }

    @GetMapping(value = "/getUserB/{id}")
    public List<User> users(@PathVariable String id){
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://jsonplaceholder.typicode.com/todos/";
        User[] usersList = restTemplate.getForObject(uri, User[].class);
       // List<User> users = usersStream.filter(u -> u.ge == Integer.parseInt(id)).collect(Collectors.toList());
        return Arrays.asList(usersList);
    }

   @GetMapping(value = "/getUserIDs")
    public List<User> usersId(){
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://jsonplaceholder.typicode.com/todos/";
        User[] usersList = restTemplate.getForObject(uri, User[].class);
        List<User> users = Arrays.asList(usersList);
        Stream<User> usersStream =  Arrays.asList(usersList).stream();
      //  List<Integer> users = usersStream.map(User::getId).collect(Collectors.toList());
        return users;
    }

    @GetMapping(value = "/getVessel")
    public List<Vessel> getVessel(){
        RestTemplate restTemplate = new RestTemplate();
        String uri = "http://localhost:3002/vessel";
        Vessel[] vesselArray = restTemplate.getForObject(uri, Vessel[].class);
        List<Vessel> vesselList = Arrays.asList(vesselArray);
       // Stream<User> usersStream =  Arrays.asList(usersList).stream();
        //  List<Integer> users = usersStream.map(User::getId).collect(Collectors.toList());
        return vesselList;
    }
//    @PostMapping(
//            value = "/updatePerson", consumes = "application/json", produces = "application/json")
//    public Person updatePerson(@RequestBody Person person, HttpServletResponse response) {
//        response.setHeader("Location", ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/findPerson/" + person.getId()).toUriString());
//
//        return personService.saveUpdatePerson(person);
//    }

    @PostMapping(value = "/createVessel", consumes = "application/json", produces = "application/json")
    public @ResponseBody Vessel createVessel(@RequestBody VesselRequest vessel){
        final String uri = "http://localhost:3002/vessel";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(uri, vessel, Vessel.class);
    }

    @PutMapping(value="/updateVessel/{id}", consumes = "application/json", produces = "application/json")
    public @ResponseBody String updateVessel(@RequestBody VesselRequest vessel,@PathVariable String id) {
        final String uri = "http://localhost:3002/vessel/" + id;
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("id", Integer.parseInt(id));
        restTemplate.put(uri,vessel, params);
        return "Updated";
    }
}
