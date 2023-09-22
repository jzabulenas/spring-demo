package lt.techin.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class PersonController {

    private final ArrayList<String> people = new ArrayList<>(Arrays.asList("Jurgis", "Antanas", "Aloyzas", "Martynas"));

    @GetMapping("/people")
    public List<String> getPeople() {
        return people;
    }

    @GetMapping("/people/{index}")
    public String getPerson(@PathVariable int index) {
        return people.get(index);
    }

    @PostMapping("/people")
    public void addPerson(@RequestBody String name) {
        people.add(name);
    }

    @PutMapping("/people/{index}")
    public void updatePerson(@PathVariable int index, @RequestBody String name) {
        people.set(index, name);
    }

    @DeleteMapping("/people/{index}")
    public void deletePerson(@PathVariable int index) {
        people.remove(index);
    }
}
