package lt.techin.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "People")
public class Person {

    @Id
    private int id;
    private String firstName;
    private String lastName;
}
