package entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
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

    public Integer getIdClient() { return idClient;}

    public void setIdCourse(Integer idClient) { this.idClient = idClient;}

    public String getFirstName() { return firstName;}

    public void setCourseName(String firstName) { this.firstName = firstName;}

    public String getLastName() { return lastName;}

    public void setLastName(String lastName) { this.lastName = lastName;}

    public Integer getAge() { return age;}

    public void setAge(Integer age) { this.age = age;}

    public String getEmail() { return email;}

    public void setEmail(String email) { this.email = email;}

    public String getPhoneNumber() { return phoneNumber;}

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber;}

    public String getCategory() { return category;}

    public void setCategory(String category) { this.category = category;}

    public Date getBirthDate() { return birthDate;}

    public void setBirthDate(Date birthDate) { this.birthDate = birthDate;}

    public Date getSubscriptionDate() { return subscriptionDate;}

    public void setSubscriptionDate(Date subscriptionDate) { this.subscriptionDate = subscriptionDate;}


    @Override
    public String toString() { return idClient + " First Name: " + firstName + " Last Name: " + lastName + " Age: " + age + " E-mail Address: " + email + " Phone Number: " + phoneNumber + " Category: " + category + " Birth Date: " + birthDate + " Subscription Date: " + subscriptionDate;}
}