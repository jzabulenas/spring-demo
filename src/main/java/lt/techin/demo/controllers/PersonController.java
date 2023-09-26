package lt.techin.demo.controllers;

import lt.techin.demo.entities.Person;
import lt.techin.demo.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

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

    @PutMapping("/people/{id}")
    public Person updatePerson(@PathVariable int id, @RequestBody Person updatedPerson) {
        Optional<Person> personFromDb = personRepository.findById(id);

        if (personFromDb.isPresent()) {
            Person person = personFromDb.get();

            if (updatedPerson.getFirstName() != null) {
                person.setFirstName(updatedPerson.getFirstName());
            }

            if (updatedPerson.getLastName() != null) {
                person.setLastName(updatedPerson.getLastName());
            }

            return personRepository.save(person);
        }

        return personRepository.save(updatedPerson);
    }

    @DeleteMapping("/people/{id}")
    public void deletePerson(@PathVariable int id) {
        personRepository.deleteById(id);
    }
}
