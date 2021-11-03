package dao;

import entity.Course;
import entity.Trainer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class TrainerRepository {

    // TODO display courses of a specific trainer
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

    //CRUD

    public void createTrainer(Trainer trainer) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save the person object
            session.save(trainer);
            // commit transaction
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public Trainer getTrainer(String email) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Trainer trainer = session.find(Trainer.class, email);
            return trainer;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Trainer> getAllTrainers() {
        List<Trainer> trainerList = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("select t from Trainer t", Trainer.class);
            trainerList = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return trainerList;
    }
}
