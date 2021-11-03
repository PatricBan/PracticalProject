package dao;


import entity.Client;
import entity.Course;
import org.hibernate.Transaction;
import util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {

    public boolean checkCourseName(String courseName){
        List<Course> courseList = getAllCourses();

        for (Course course : courseList) {
           String numeCurs = course.getCourseName();
            if(numeCurs.equals(courseName)){

                return true;
            }
        }
        return false;
    }

    public void updateCourse(Course course) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save the client object
            session.update(course);
            // commit transaction
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    //CRUD
    public void createCourse(Course course) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save the person object
            session.save(course);
            // commit transaction
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public Course getCourse(String nume) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Course course = session.find(Course.class, nume);
            return course;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Course> getAllCourses(){
        List<Course> coursesList = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("SELECT courses FROM Course courses");
            coursesList = query.getResultList();
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        return coursesList;
    }
}


