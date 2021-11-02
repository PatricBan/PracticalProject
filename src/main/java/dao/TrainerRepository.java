package dao;

import entity.Client;
import entity.Course;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class TrainerRepository {
    public List<Client> displayAllClients(){
        List<Client> clientList = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("select c from Client c", Client.class);
            clientList = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return clientList;
    }
    public List<Course> displayAllTrainerCourses() {
        List<Course> courseList = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("select c from Course c", Course.class);
            courseList = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return courseList;
    }


}
