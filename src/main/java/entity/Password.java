package entity;

import javax.persistence.*;

@Entity
@Table(name = "passwords")
public class Password {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String email;
    //TODO: Vezi aici~!!!!
//    @OneToOne
//    @JoinColumn(name = "password")
    private String password;

    public Password() {
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Password{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
