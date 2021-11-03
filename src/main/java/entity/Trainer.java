package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "trainers")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTrainer;

    @ManyToMany(mappedBy = "trainers", cascade = CascadeType.ALL)
    private Set<Client> clients;

    @ManyToMany(mappedBy = "trainers", cascade = CascadeType.ALL)
    private Set<Course> courses;

    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date birthDate;

    public Trainer() {

    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Integer getIdTrainer() {
        return idTrainer;
    }

    public void setIdTrainer(Integer idTrainer) {
        this.idTrainer = idTrainer;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "idTrainer=" + idTrainer +
                ", clients=" + clients +
                ", courses=" + courses +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
