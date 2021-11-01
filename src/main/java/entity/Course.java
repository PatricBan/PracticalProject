package entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCourse;
    private String courseName;
    private String courseDescription;

    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    private Set<Client> clients;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "trainer_course",
            joinColumns = { @JoinColumn(name = "idCourse") },
            inverseJoinColumns = { @JoinColumn(name = "idTrainer")})
    private Set<Trainer> trainers;


    public Course(){
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    @Override
    public String toString() {
        return idCourse + " Cursul " + courseName + " - " + courseDescription;
    }
}
