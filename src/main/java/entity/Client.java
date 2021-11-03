package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "client_trainer",
            joinColumns = {@JoinColumn(name = "idClient")},
            inverseJoinColumns = {@JoinColumn(name = "idTrainer")})
    private Set<Trainer> trainers;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "client_course",
            joinColumns = {@JoinColumn(name = "idClient")},
            inverseJoinColumns = {@JoinColumn(name = "idCourse")})
    private Set<Course> courses;

    private String password;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String phoneNumber;
    private String category;
    private Date birthDate;
    private Date subscriptionDate;


    public Client() {
    }

    public Set<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(Set<Trainer> trainers) {
        this.trainers = trainers;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdCourse(Integer idClient) {
        this.idClient = idClient;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setCourseName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", trainers=" + trainers +
                ", courses=" + courses +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", category='" + category + '\'' +
                ", birthDate=" + birthDate +
                ", subscriptionDate=" + subscriptionDate +
                '}';
    }
}