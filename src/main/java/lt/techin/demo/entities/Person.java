package lt.techin.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import javax.annotation.processing.Generated;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "People")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @NotEmpty
    private String firstName;
    @NotNull
    @NotEmpty
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Person_id", nullable = false)
    @NotNull
    @NotEmpty
    private List<PhoneNumber> phoneNumbers;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "People_groups",
            joinColumns = @JoinColumn(name = "Person_id"),
            inverseJoinColumns = @JoinColumn(name = "Group_id")
    )
    private List<Group> groups;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
