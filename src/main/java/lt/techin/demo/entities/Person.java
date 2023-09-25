package lt.techin.demo.entities;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
@Table(name = "People")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String firstName;
    private String lastName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
