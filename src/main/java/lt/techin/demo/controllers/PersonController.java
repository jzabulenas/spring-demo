package lt.techin.demo.controllers;

import lt.techin.demo.entities.Person;
import lt.techin.demo.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/people")
    public List<Person> getPeople() {
        return personRepository.findAll();
    }

    @GetMapping("/people/{id}")
    public Person getPerson(@PathVariable int id) {
        return personRepository.findById(id).get();
    }

    @PostMapping("/people")
    public void addPerson(@RequestBody Person person) {
        personRepository.save(person);
    }

//    @PutMapping("/people/{index}")
//    public void updatePerson(@PathVariable int index, @RequestBody String name) {
//        people.set(index, name);
//    }
//
//    @DeleteMapping("/people/{index}")
//    public void deletePerson(@PathVariable int index) {
//        people.remove(index);
//    }
}
