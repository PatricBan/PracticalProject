package dao;


import entity.Courses;
import util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CoursesRepository {

    public List<Courses> displayAllCourses(){
        List<Courses> coursesList = new ArrayList<>();

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("SELECT courses FROM Courses courses");
            coursesList = query.getResultList();



        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }

        return coursesList;
    }
}
