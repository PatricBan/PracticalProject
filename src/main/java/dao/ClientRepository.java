package dao;


import entity.Trainer;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
public List<Trainer> displayAllTrainers() {
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
