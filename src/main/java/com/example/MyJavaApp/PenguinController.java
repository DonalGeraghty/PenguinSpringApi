package com.example.MyJavaApp;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PenguinController {

    @RequestMapping("/")
    public String index() {

        System.out.println("GET");

        return "Greetings from Spring Boot!";
    }

    @GetMapping("/penguins")
    List<Penguin> getPenguins(){

        List<Penguin> penguins = new ArrayList<>();
        penguins.add(new Penguin("pingu"));
        penguins.add(new Penguin("pinga"));
        penguins.add(new Penguin("pingi"));

        System.out.println("GET/penguins: " + penguins);

        return penguins;
    }

    @GetMapping("/penguin")
    Penguin getPenguin(){

        Penguin penguin = new Penguin("pingu");

        System.out.println("GET/penguin: " + penguin);

        return penguin;
    }

    @PostMapping("/penguin/{name}")
    String postPenguin(@PathVariable String name){

        Penguin penguin = new Penguin(name);

        System.out.println("POST/penguin/: " + penguin);

        return "POST\t" + penguin;
    }

    @DeleteMapping("/penguin/{name}")
    String deletePenguin(@PathVariable String name){

        Penguin penguin = new Penguin(name);

        System.out.println("DELETE/penguin/: " + penguin);

        return "DELETE\t" + penguin;
    }
}